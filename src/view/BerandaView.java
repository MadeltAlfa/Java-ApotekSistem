package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import koneksi_db.Koneksi;

public class BerandaView extends javax.swing.JFrame {
    private final Connection conn;
    ResultSet rs, rest;
    private Blob gambar;
    private static String username;
    static String nama;
    static int id;
    static String akses;
    static String email;
    
    public BerandaView(String username, String nama, int id, String akses, String email) {
        initComponents();
        
        setTitle("Beranda Apotek");
//        ImageIcon image = new ImageIcon("../img/icon_farma.png");
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/icon_farma.png"));
//        Image icon = Toolkit.getDefaultToolkit().getImage("img/icon_farma.png");
        setIconImage(image);
        
        // Koneksi Database
        conn = Koneksi.getConnect();
        
        // Kirim parameter
        BerandaView.username = username;
        BerandaView.nama = nama;
        BerandaView.id = id;
        BerandaView.akses = akses;       
        BerandaView.email = email;       
        
        // custom tampilan
        t_beranda.setOpaque(true);
        t_beranda.setBackground(new Color(75, 89, 69));
        text_bar.setText("SELAMAT DATANG KEMBALI, " + username.toUpperCase());
        lb_nama.setText(nama.toUpperCase());
        lb_email.setText(email);
//        text_bar.setHorizontalAlignment(SwingConstants.CENTER);
//        text_bar.setText("<html>Selamat Datang,<br>ADMIN</html>");
        
        // Pemanggilan method
        Jam();
        Shift();
        getData();
        getDataStok();
        getDataKadaluarsa();
    }
    
    private void Jam() {
        new Timer(100, (ActionEvent e) -> {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formatTanggal = new SimpleDateFormat("E, dd-MM-yy", new Locale("id", "ID"));
            SimpleDateFormat formatWaktu = new SimpleDateFormat("HH:mm");
            String tanggalSekarang = formatTanggal.format(calendar.getTime());
            String waktuSekarang = formatWaktu.format(calendar.getTime());

            lb_tanggal.setText(tanggalSekarang);
            lb_jam.setText(waktuSekarang);
        }).start();            
    }
    
    private void Shift() {
        new Timer(100, e -> {
            Calendar calendar = Calendar.getInstance();
            int jam = calendar.get(Calendar.HOUR_OF_DAY);

            String shift;
            if (jam >= 8 && jam < 16) {
                shift = "Shift Pagi";
            } else if (jam >= 16 && jam < 23) {
                shift = "Shift Siang";
            } else {
                shift = "Shift Malam";
            }

            lb_shift.setText(shift);
        }).start();
    }
    
    public Blob getGambar() {
        return gambar;
    }
    
    private void getData() {
        String sql = "SELECT gambar FROM akses WHERE id = " + id;
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Blob gambarBlob = rs.getBlob("gambar");
                try {
//                    // 2217
                    if (gambarBlob == null) {
                        lb_gambar.setText("Tidak ada gambar");
                        return;
                    }
                    long blobLength = gambarBlob.length();
                    byte[] img = gambarBlob.getBytes(1, (int) blobLength);
                    ImageIcon imageIcon = new ImageIcon(img);
            
                    int labelWidth = 200;
                    int labelHeight = 200;
            
                    int imageWidth = imageIcon.getIconWidth();            
                    int imageHeight = imageIcon.getIconHeight();            
            
                    double scaleX = (double) labelWidth / (double) imageWidth;
                    double scaleY = (double) labelHeight / (double) imageHeight;
                    double scale = Math.min(scaleX, scaleY);
            
                    Image scaledImage = imageIcon.getImage().getScaledInstance((int) (scale * imageWidth), (int) (scale * imageHeight), Image.SCALE_SMOOTH);
            
                    lb_gambar.setIcon(new ImageIcon(scaledImage));
                } catch (SQLException e) {
                     Logger.getLogger(BerandaView.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(BerandaView.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_bar = new javax.swing.JPanel();
        t_obat = new javax.swing.JLabel();
        t_beranda = new javax.swing.JLabel();
        t_penjualan = new javax.swing.JLabel();
        t_pengaturan = new javax.swing.JLabel();
        t_keluar = new javax.swing.JLabel();
        t_admin = new javax.swing.JLabel();
        t_laporan1 = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        text_bar = new javax.swing.JLabel();
        lb_gambar = new javax.swing.JLabel();
        text_nama = new javax.swing.JLabel();
        lb_nama = new javax.swing.JLabel();
        text_email = new javax.swing.JLabel();
        lb_email = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_stok = new custom.JTable_Custom();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_kadaluarsa = new custom.JTable_Custom();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        navbar = new javax.swing.JPanel();
        lb_shift = new javax.swing.JLabel();
        lb_jam = new javax.swing.JLabel();
        lb_tanggal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 750));
        setName("Beranda"); // NOI18N
        setResizable(false);

        side_bar.setBackground(new java.awt.Color(41, 54, 36));
        side_bar.setPreferredSize(new java.awt.Dimension(200, 750));

        t_obat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        t_obat.setForeground(new java.awt.Color(255, 255, 255));
        t_obat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        t_obat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/obat.png"))); // NOI18N
        t_obat.setText(" KELOLA OBAT");
        t_obat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_obatMouseClicked(evt);
            }
        });

        t_beranda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        t_beranda.setForeground(new java.awt.Color(255, 255, 255));
        t_beranda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        t_beranda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/beranda3.png"))); // NOI18N
        t_beranda.setText(" BERANDA");

        t_penjualan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        t_penjualan.setForeground(new java.awt.Color(255, 255, 255));
        t_penjualan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        t_penjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/penjualan.png"))); // NOI18N
        t_penjualan.setText(" PENJUALAN");
        t_penjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_penjualanMouseClicked(evt);
            }
        });

        t_pengaturan.setBackground(new java.awt.Color(178, 201, 173));
        t_pengaturan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        t_pengaturan.setForeground(new java.awt.Color(255, 255, 255));
        t_pengaturan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t_pengaturan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-setting-25.png"))); // NOI18N
        t_pengaturan.setText("PENGATURAN");
        t_pengaturan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        t_pengaturan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_pengaturanMouseClicked(evt);
            }
        });

        t_keluar.setBackground(new java.awt.Color(178, 201, 173));
        t_keluar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        t_keluar.setForeground(new java.awt.Color(255, 255, 255));
        t_keluar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-logout-25.png"))); // NOI18N
        t_keluar.setText("KELUAR");
        t_keluar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        t_keluar.setPreferredSize(new java.awt.Dimension(175, 25));
        t_keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_keluarMouseClicked(evt);
            }
        });

        t_admin.setBackground(new java.awt.Color(178, 201, 173));
        t_admin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        t_admin.setForeground(new java.awt.Color(255, 255, 255));
        t_admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/admin2.png"))); // NOI18N
        t_admin.setText("ADMIN");
        t_admin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        t_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_adminMouseClicked(evt);
            }
        });

        t_laporan1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        t_laporan1.setForeground(new java.awt.Color(255, 255, 255));
        t_laporan1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        t_laporan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-note-30.png"))); // NOI18N
        t_laporan1.setText("  LAPORAN");
        t_laporan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_laporan1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout side_barLayout = new javax.swing.GroupLayout(side_bar);
        side_bar.setLayout(side_barLayout);
        side_barLayout.setHorizontalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_barLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t_penjualan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_obat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_beranda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_admin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_pengaturan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_keluar, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(t_laporan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        side_barLayout.setVerticalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_barLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(t_beranda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_obat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_penjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_laporan1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                .addComponent(t_pengaturan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setPreferredSize(new java.awt.Dimension(800, 700));

        text_bar.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        text_bar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lb_gambar.setBackground(new java.awt.Color(255, 255, 255));
        lb_gambar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lb_gambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_gambar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        text_nama.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        text_nama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        text_nama.setText("Nama");

        lb_nama.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lb_nama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        text_email.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        text_email.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        text_email.setText("Email");

        lb_email.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lb_email.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        tbl_stok.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Stok"
            }
        ));
        tbl_stok.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tbl_stok.setShowVerticalLines(true);
        jScrollPane2.setViewportView(tbl_stok);

        tbl_kadaluarsa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Kadaluarsa"
            }
        ));
        tbl_kadaluarsa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tbl_kadaluarsa.setShowVerticalLines(true);
        jScrollPane3.setViewportView(tbl_kadaluarsa);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Stok akan habis");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Stok akan kadaluarsa");

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(text_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(lb_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainLayout.createSequentialGroup()
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text_email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_email, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(text_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE))
                            .addComponent(lb_nama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(60, 60, 60))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(text_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lb_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(text_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lb_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lb_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        navbar.setBackground(new java.awt.Color(90, 108, 87));
        navbar.setPreferredSize(new java.awt.Dimension(800, 50));

        lb_shift.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lb_shift.setForeground(new java.awt.Color(255, 255, 255));
        lb_shift.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_shift.setPreferredSize(new java.awt.Dimension(200, 30));

        lb_jam.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lb_jam.setForeground(new java.awt.Color(255, 255, 255));
        lb_jam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_jam.setPreferredSize(new java.awt.Dimension(200, 25));

        lb_tanggal.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lb_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lb_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout navbarLayout = new javax.swing.GroupLayout(navbar);
        navbar.setLayout(navbarLayout);
        navbarLayout.setHorizontalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lb_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(lb_jam, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(lb_shift, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        navbarLayout.setVerticalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lb_shift, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_jam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(side_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(navbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(side_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(navbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void t_pengaturanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_pengaturanMouseClicked
        ResetView reset = new ResetView(BerandaView.this, username, nama, id, akses, email);
        reset.setVisible(true);
        dispose();
    }//GEN-LAST:event_t_pengaturanMouseClicked

    private void t_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_keluarMouseClicked
        LoginView login = new LoginView();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_t_keluarMouseClicked

    private void t_obatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_obatMouseClicked
        KelolaView kelola = new KelolaView(username, nama, id, akses, email);
        kelola.setVisible(true);
        dispose();
    }//GEN-LAST:event_t_obatMouseClicked

    private void t_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_adminMouseClicked
        //lbl_admin.setForeground(new Color(211, 211, 211));
        if (akses.equals("admin")) {
            AdminView admin = new AdminView(username, nama, id, akses, email);
            admin.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Anda bukan admin", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_t_adminMouseClicked

    private void t_penjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_penjualanMouseClicked
        PenjualanView penjualan = new PenjualanView(username, nama, id, akses, email);
        penjualan.setVisible(true);
        dispose();
    }//GEN-LAST:event_t_penjualanMouseClicked

    private void t_laporan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_laporan1MouseClicked
        LaporanView laporan = new LaporanView(username, nama, id, akses, email);
        laporan.setVisible(true);
        dispose();
    }//GEN-LAST:event_t_laporan1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_email;
    private javax.swing.JLabel lb_gambar;
    private javax.swing.JLabel lb_jam;
    private javax.swing.JLabel lb_nama;
    private javax.swing.JLabel lb_shift;
    private javax.swing.JLabel lb_tanggal;
    private javax.swing.JPanel main;
    private javax.swing.JPanel navbar;
    private javax.swing.JPanel side_bar;
    private javax.swing.JLabel t_admin;
    private javax.swing.JLabel t_beranda;
    private javax.swing.JLabel t_keluar;
    private javax.swing.JLabel t_laporan1;
    private javax.swing.JLabel t_obat;
    private javax.swing.JLabel t_pengaturan;
    private javax.swing.JLabel t_penjualan;
    private custom.JTable_Custom tbl_kadaluarsa;
    private custom.JTable_Custom tbl_stok;
    private javax.swing.JLabel text_bar;
    private javax.swing.JLabel text_email;
    private javax.swing.JLabel text_nama;
    // End of variables declaration//GEN-END:variables

    private void getDataStok() {
        DefaultTableModel model = (DefaultTableModel) tbl_stok.getModel();
        model.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM daftar_obat WHERE quantity <= 5 ORDER BY name ASC";
            PreparedStatement stmt = conn.prepareStatement(sql);
            rest = stmt.executeQuery();
            
            while (rest.next()) {                
                String nama_obat = rest.getString("name");
                int quantity = rest.getInt("quantity");                              
                
                Object[] rowData = {nama_obat, quantity};
                model.addRow(rowData);               
            }
            
            stmt.close();
            rest.close();
        } catch (SQLException e) {
            Logger.getLogger(BerandaView.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void getDataKadaluarsa() {
        DefaultTableModel model = (DefaultTableModel) tbl_kadaluarsa.getModel();
        model.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM daftar_obat WHERE expdate BETWEEN CURDATE() AND CURDATE() + INTERVAL 7 DAY ORDER BY name ASC";
            PreparedStatement stmt = conn.prepareStatement(sql);
            rest = stmt.executeQuery();
             SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("id", "ID"));
            
            while (rest.next()) {                
                String nama_obat = rest.getString("name");
                String kadaluarsa = dateFormat.format(rest.getDate("expdate"));                          
                
                Object[] rowData = {nama_obat, kadaluarsa};
                model.addRow(rowData);               
            }
            
            stmt.close();
            rest.close();
        } catch (SQLException e) {
            Logger.getLogger(BerandaView.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
