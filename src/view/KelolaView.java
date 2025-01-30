package view;

import koneksi_db.Koneksi;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class KelolaView extends javax.swing.JFrame {   
    private final Connection conn;
    private static String username;
    private static String nama;
    private static int id;
    private static String akses;
    private static String email;
    ResultSet rest;
    java.util.Date fabdate, expdate;
    java.sql.Date MyFabDate, MyExpDate;
    
    public KelolaView(String username, String nama, int id, String akses, String email) {
        initComponents();
        conn = Koneksi.getConnect();
        KelolaView.username = username;
        KelolaView.nama = nama;
        KelolaView.id = id;
        KelolaView.akses = akses;       
        KelolaView.email = email;
        
        setTitle("Kelola Obat");
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/icon_farma.png"));
        setIconImage(image);
        side_obat.setOpaque(true);
        side_obat.setBackground(new Color(75, 89, 69));
        
        getData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_bar = new javax.swing.JPanel();
        side_obat = new javax.swing.JLabel();
        side_beranda = new javax.swing.JLabel();
        side_penjualan = new javax.swing.JLabel();
        lbl_admin = new javax.swing.JLabel();
        lb_user = new javax.swing.JLabel();
        lb_keluar = new javax.swing.JLabel();
        t_laporan = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_obat = new custom.JTable_Custom();
        text_bar = new javax.swing.JLabel();
        text_bar1 = new javax.swing.JLabel();
        t_nama = new javax.swing.JTextField();
        t_harga = new javax.swing.JTextField();
        t_stok = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        t_produksi = new com.toedter.calendar.JDateChooser();
        t_kadaluarsa = new com.toedter.calendar.JDateChooser();
        t_pembuat = new javax.swing.JComboBox<>();
        btn_tambah = new javax.swing.JButton();
        btn_perbarui = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        t_cari = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        side_bar.setBackground(new java.awt.Color(41, 54, 36));
        side_bar.setPreferredSize(new java.awt.Dimension(200, 750));

        side_obat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        side_obat.setForeground(new java.awt.Color(255, 255, 255));
        side_obat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        side_obat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/obat.png"))); // NOI18N
        side_obat.setText(" KELOLA OBAT");
        side_obat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                side_obatMouseClicked(evt);
            }
        });

        side_beranda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        side_beranda.setForeground(new java.awt.Color(255, 255, 255));
        side_beranda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        side_beranda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/beranda3.png"))); // NOI18N
        side_beranda.setText(" BERANDA");
        side_beranda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                side_berandaMouseClicked(evt);
            }
        });

        side_penjualan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        side_penjualan.setForeground(new java.awt.Color(255, 255, 255));
        side_penjualan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        side_penjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/penjualan.png"))); // NOI18N
        side_penjualan.setText(" PENJUALAN");
        side_penjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                side_penjualanMouseClicked(evt);
            }
        });

        lbl_admin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_admin.setForeground(new java.awt.Color(255, 255, 255));
        lbl_admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/admin2.png"))); // NOI18N
        lbl_admin.setText("ADMIN");
        lbl_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_adminMouseClicked(evt);
            }
        });

        lb_user.setBackground(new java.awt.Color(178, 201, 173));
        lb_user.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_user.setForeground(new java.awt.Color(255, 255, 255));
        lb_user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-setting-25.png"))); // NOI18N
        lb_user.setText("PENGATURAN");
        lb_user.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_userMouseClicked(evt);
            }
        });

        lb_keluar.setBackground(new java.awt.Color(178, 201, 173));
        lb_keluar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_keluar.setForeground(new java.awt.Color(255, 255, 255));
        lb_keluar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-logout-25.png"))); // NOI18N
        lb_keluar.setText("KELUAR");
        lb_keluar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_keluar.setPreferredSize(new java.awt.Dimension(175, 25));
        lb_keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_keluarMouseClicked(evt);
            }
        });

        t_laporan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        t_laporan.setForeground(new java.awt.Color(255, 255, 255));
        t_laporan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        t_laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-note-30.png"))); // NOI18N
        t_laporan.setText("  LAPORAN");
        t_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_laporanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout side_barLayout = new javax.swing.GroupLayout(side_bar);
        side_bar.setLayout(side_barLayout);
        side_barLayout.setHorizontalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(side_barLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(side_penjualan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(side_obat, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(side_beranda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_keluar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(lb_user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_laporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        side_barLayout.setVerticalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_barLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(side_beranda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(side_obat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(side_penjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 297, Short.MAX_VALUE)
                .addComponent(lb_user, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setPreferredSize(new java.awt.Dimension(800, 750));

        tbl_obat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Harga", "Stok", "Produksi", "Kadaluarsa", "Pembuat"
            }
        ));
        tbl_obat.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tbl_obat.setShowVerticalLines(true);
        tbl_obat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_obatMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_obat);

        text_bar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        text_bar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text_bar.setText("DAFTAR OBAT");

        text_bar1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        text_bar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text_bar1.setText("KELOLA OBAT");

        t_nama.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        t_nama.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        t_nama.setMaximumSize(new java.awt.Dimension(150, 25));
        t_nama.setPreferredSize(new java.awt.Dimension(150, 25));

        t_harga.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        t_harga.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        t_harga.setMaximumSize(new java.awt.Dimension(150, 25));
        t_harga.setPreferredSize(new java.awt.Dimension(150, 25));

        t_stok.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        t_stok.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        t_stok.setMaximumSize(new java.awt.Dimension(150, 25));
        t_stok.setPreferredSize(new java.awt.Dimension(150, 25));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setText("Nama");
        jLabel2.setMaximumSize(new java.awt.Dimension(75, 16));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("Harga");
        jLabel3.setMaximumSize(new java.awt.Dimension(75, 16));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("Stok");
        jLabel4.setMaximumSize(new java.awt.Dimension(75, 16));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Tanggal diproduksi");
        jLabel5.setMaximumSize(new java.awt.Dimension(150, 16));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("Kadaluarsa");
        jLabel6.setMaximumSize(new java.awt.Dimension(150, 16));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("Pembuat");
        jLabel7.setMaximumSize(new java.awt.Dimension(150, 16));

        t_produksi.setBackground(new java.awt.Color(204, 204, 204));
        t_produksi.setToolTipText("InputDate");
        t_produksi.setDateFormatString("dd MMM y");
        t_produksi.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        t_produksi.setMaximumSize(new java.awt.Dimension(150, 25));
        t_produksi.setPreferredSize(new java.awt.Dimension(150, 25));

        t_kadaluarsa.setBackground(new java.awt.Color(204, 204, 204));
        t_kadaluarsa.setToolTipText("InputDate");
        t_kadaluarsa.setDateFormatString("dd MMM y");
        t_kadaluarsa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        t_kadaluarsa.setMaximumSize(new java.awt.Dimension(150, 25));
        t_kadaluarsa.setPreferredSize(new java.awt.Dimension(150, 25));

        t_pembuat.setBackground(new java.awt.Color(204, 204, 204));
        t_pembuat.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        t_pembuat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dexa Medica", "Sanbe Farma", "Kimia Farma", "Phapros", "Kalbe Farma" }));
        t_pembuat.setMaximumSize(new java.awt.Dimension(150, 25));

        btn_tambah.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_tambah.setText("Tambah");
        btn_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tambahMouseClicked(evt);
            }
        });

        btn_perbarui.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_perbarui.setText("Perbarui");
        btn_perbarui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_perbaruiMouseClicked(evt);
            }
        });

        btn_batal.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_batal.setText("Batal");
        btn_batal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_batalMouseClicked(evt);
            }
        });

        btn_hapus.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hapusMouseClicked(evt);
            }
        });

        t_cari.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        t_cari.setForeground(new java.awt.Color(153, 153, 153));
        t_cari.setText("Cari");
        t_cari.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_cariFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_cariFocusLost(evt);
            }
        });
        t_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_cariKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(mainLayout.createSequentialGroup()
                                    .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(t_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(t_stok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(t_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(mainLayout.createSequentialGroup()
                                    .addGap(236, 236, 236)
                                    .addComponent(text_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(mainLayout.createSequentialGroup()
                                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btn_perbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(mainLayout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainLayout.createSequentialGroup()
                                .addGap(232, 232, 232)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t_pembuat, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainLayout.createSequentialGroup()
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(mainLayout.createSequentialGroup()
                                        .addGap(232, 232, 232)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(t_produksi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t_kadaluarsa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(text_bar1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(text_bar1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(t_kadaluarsa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_pembuat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(t_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(t_produksi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_stok, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_perbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(text_bar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(side_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(side_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_adminMouseClicked
        if (akses.equals("admin")) {
            AdminView admin = new AdminView(username, nama, id, akses, email);
            admin.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Anda bukan admin", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_lbl_adminMouseClicked

    private void side_berandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_side_berandaMouseClicked
        BerandaView beranda = new BerandaView(username, nama, id, akses, email);
        beranda.setVisible(true);
        dispose();
    }//GEN-LAST:event_side_berandaMouseClicked

    private void lb_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_userMouseClicked
        ResetView reset = new ResetView(KelolaView.this, username, nama, id, akses, email);
        reset.setVisible(true);
        dispose();
    }//GEN-LAST:event_lb_userMouseClicked

    private void lb_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_keluarMouseClicked
        LoginView login = new LoginView();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_lb_keluarMouseClicked

    private void btn_tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMouseClicked
        fabdate = t_produksi.getDate();
        MyFabDate = new java.sql.Date(fabdate.getTime());
        expdate = t_kadaluarsa.getDate();
        MyExpDate = new java.sql.Date(expdate.getTime());
        try {    
            PreparedStatement add = conn.prepareStatement("INSERT INTO daftar_obat VALUES (?, ?, ?, ?, ?, ?, ?)");
            add.setString(1, generateAngkaOBT());
            add.setString(2, t_nama.getText());
            add.setInt(3, Integer.parseInt(t_harga.getText()));
            add.setInt(4, Integer.parseInt(t_stok.getText()));
            add.setDate(5, MyFabDate);
            add.setDate(6, MyExpDate);
            add.setString(7, t_pembuat.getSelectedItem().toString());
            
            int rowsAffected = add.executeUpdate(); 
           
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Obat Sukses Ditambahkan");
            }  
            
            add.close();
            resetForm();
            getData();
        } catch (SQLException e) {
            Logger.getLogger(KelolaView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btn_tambahMouseClicked

    private void btn_batalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_batalMouseClicked
        resetForm();
    }//GEN-LAST:event_btn_batalMouseClicked

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked
        int selectedRow = tbl_obat.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan dihapus");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String idObat = tbl_obat.getValueAt(selectedRow, 0).toString();
            try {
                String sql = "DELETE FROM daftar_obat WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, idObat);
                
                int rowDelete = stmt.executeUpdate();
                if (rowDelete > 0) {
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
                }
                
                stmt.close();
            } catch (SQLException e) {
                Logger.getLogger(KelolaView.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        resetForm();
        getData();
    }//GEN-LAST:event_btn_hapusMouseClicked

    private void btn_perbaruiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_perbaruiMouseClicked
        fabdate = t_produksi.getDate();
        MyFabDate = new java.sql.Date(fabdate.getTime());
        expdate = t_kadaluarsa.getDate();
        MyExpDate = new java.sql.Date(expdate.getTime());
        
        int seletedRow = tbl_obat.getSelectedRow();
        if (seletedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan diperbarui");
            return;
        }
        
        String idObat = tbl_obat.getValueAt(seletedRow, 0).toString();
        String namaObat = t_nama.getText();
        int harga = Integer.parseInt(t_harga.getText());
        int stok = Integer.parseInt(t_stok.getText());
        
        if (idObat.isEmpty() || namaObat.isEmpty() || t_harga.getText().isEmpty() || t_stok.getText().isEmpty() || MyFabDate.toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            fabdate = t_produksi.getDate();
            MyFabDate = new java.sql.Date(fabdate.getTime());
            expdate = t_kadaluarsa.getDate();
            MyExpDate = new java.sql.Date(expdate.getTime());
        
            String sql = "UPDATE daftar_obat SET name = ?, price = ?, quantity = ?, fabdate = ?, expdate = ?, company = ? WHERE id_obat = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, namaObat);
            stmt.setInt(2, harga);
            stmt.setInt(3, stok);
            stmt.setDate(4, MyFabDate);
            stmt.setDate(5, MyExpDate);
            stmt.setString(6, t_pembuat.getSelectedItem().toString());
            stmt.setString(7, idObat);
            
            int rowUpdate = stmt.executeUpdate();
            if (rowUpdate > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil diperbarui");
                resetForm();
                getData();
            }
            
            stmt.close();
        } catch (SQLException e) {
            Logger.getLogger(KelolaView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btn_perbaruiMouseClicked

    private void tbl_obatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_obatMouseClicked
        int selectedRow = tbl_obat.getSelectedRow();
        if (selectedRow != -1) {
            String namaObat = tbl_obat.getValueAt(selectedRow, 1).toString();
            String harga = tbl_obat.getValueAt(selectedRow, 2).toString();
            String stok = tbl_obat.getValueAt(selectedRow, 3).toString();
            String pembuat = tbl_obat.getValueAt(selectedRow, 6).toString();

            t_nama.setText(namaObat);
            t_harga.setText(harga);
            t_stok.setText(stok);
            t_pembuat.setSelectedItem(pembuat);
        }
    }//GEN-LAST:event_tbl_obatMouseClicked

    private void side_penjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_side_penjualanMouseClicked
        PenjualanView penjualan = new PenjualanView(username, nama, id, akses, email);
        penjualan.setVisible(true);
        dispose();
    }//GEN-LAST:event_side_penjualanMouseClicked

    private void t_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_laporanMouseClicked
        LaporanView laporan = new LaporanView(username, nama, id, akses, email);
        laporan.setVisible(true);
        dispose();
    }//GEN-LAST:event_t_laporanMouseClicked

    private void side_obatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_side_obatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_side_obatMouseClicked

    private void t_cariFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_cariFocusGained
        if (t_cari.getText().equals("Cari")) {
            t_cari.setText("");
            t_cari.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_t_cariFocusGained

    private void t_cariFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_cariFocusLost
        if (t_cari.getText().equals("")) {
            t_cari.setText("Cari");
            t_cari.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_t_cariFocusLost

    private void t_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_cariKeyTyped
        DefaultTableModel model = (DefaultTableModel) tbl_obat.getModel();
        model.setRowCount(0);

        String cari = t_cari.getText();
        ResultSet resultSet;

        try {
            String sql = "SELECT * FROM daftar_obat WHERE id_obat LIKE ? OR name LIKE ? OR price LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yy", new Locale("id", "ID"));
            stmt.setString(1, "%" + cari + "%");
            stmt.setString(2, "%" + cari + "%");
            stmt.setString(3, "%" + cari + "%");
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                String idObat = resultSet.getString("id_obat");
                String namaObat = resultSet.getString("name");
                int hargaObat = resultSet.getInt("price");
                 int stok = rest.getInt("quantity");
                String produksi = dateFormat.format(rest.getDate("fabdate"));
                String kadalursa = dateFormat.format(rest.getDate("expdate"));
                String pembuat = rest.getString("company");
                

                Object[] rowData = {idObat, namaObat, hargaObat, stok, produksi, kadalursa, pembuat};
                model.addRow(rowData);
            }

            resultSet.close();
            stmt.close();
        } catch (SQLException e) {
            Logger.getLogger(PenjualanView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_t_cariKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_perbarui;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_keluar;
    private javax.swing.JLabel lb_user;
    private javax.swing.JLabel lbl_admin;
    private javax.swing.JPanel main;
    private javax.swing.JPanel side_bar;
    private javax.swing.JLabel side_beranda;
    private javax.swing.JLabel side_obat;
    private javax.swing.JLabel side_penjualan;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTextField t_harga;
    private com.toedter.calendar.JDateChooser t_kadaluarsa;
    private javax.swing.JLabel t_laporan;
    private javax.swing.JTextField t_nama;
    private javax.swing.JComboBox<String> t_pembuat;
    private com.toedter.calendar.JDateChooser t_produksi;
    private javax.swing.JTextField t_stok;
    private custom.JTable_Custom tbl_obat;
    private javax.swing.JLabel text_bar;
    private javax.swing.JLabel text_bar1;
    // End of variables declaration//GEN-END:variables

    private void getData() {
        DefaultTableModel model = (DefaultTableModel) tbl_obat.getModel();
        model.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM daftar_obat ORDER BY name ASC;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            rest = stmt.executeQuery();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", new Locale("id", "ID"));
            
            while (rest.next()) {                
                String idObat = rest.getString("id_obat");
                String namaObat = rest.getString("name");
                int harga = rest.getInt("price");
                int stok = rest.getInt("quantity");
                String produksi = dateFormat.format(rest.getDate("fabdate"));
                String kadalursa = dateFormat.format(rest.getDate("expdate"));
                String pembuat = rest.getString("company");
                
                
                Object[] rowData = {idObat, namaObat, harga, stok, produksi, kadalursa, pembuat};
                model.addRow(rowData);               
            }
        } catch (SQLException e) {
            Logger.getLogger(KelolaView.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void resetForm() {
        t_nama.setText("");
        t_harga.setText("");
        t_stok.setText("");
        t_produksi.setDate(null);
        t_kadaluarsa.setDate(null);
        t_pembuat.setSelectedItem(null);
    }
    
    public static String generateAngkaOBT() {
        Random random = new Random();
        StringBuilder angka = new StringBuilder("OBT");

        // Generate 4 digit angka secara random
        for (int i = 0; i < 4; i++) {
            int digit = random.nextInt(10);
            angka.append(digit);
        }

        return angka.toString();
    }
}
