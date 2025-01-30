package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import koneksi_db.Koneksi;

public class AdminView extends javax.swing.JFrame {
    private final Connection conn;
    ResultSet rest;
    private static String username;
    private static String nama;
    private static int id;
    private static String akses;    
    private static String email;    
    
    public AdminView(String username, String nama, int id, String akses, String email) {
        initComponents();
        AdminView.username = username;
        AdminView.nama = nama;
        AdminView.id = id;
        AdminView.akses = akses;
        AdminView.email = email;
        
        conn = Koneksi.getConnect();
        setTitle("Admin Area");
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/icon_farma.png"));
        setIconImage(image);
        lbl_admin.setOpaque(true);
        lbl_admin.setBackground(new Color(75, 89, 69));
        text_bar.setText("SELAMAT DATANG KEMBALI, " + username.toUpperCase());
//        text_bar.setHorizontalAlignment(SwingConstants.CENTER);
        getDataUser();
    }

    private void getDataUser() {
        DefaultTableModel model = (DefaultTableModel) tbl_user.getModel();
        model.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM akses WHERE access_key = 'user'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            rest = stmt.executeQuery();
            
            while (rest.next()) {                
                String namaUser = rest.getString("username");
                String passUser = rest.getString("password");
                String fullname = rest.getString("fullname");
                String emailUser = rest.getString("email");
                
                
                Object[] rowData = {namaUser, passUser, emailUser,  fullname};
                model.addRow(rowData);               
            }
        } catch (SQLException e) {
            Logger.getLogger(AdminView.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_bar = new javax.swing.JPanel();
        side_obat = new javax.swing.JLabel();
        side_beranda = new javax.swing.JLabel();
        side_penjualan = new javax.swing.JLabel();
        lbl_admin = new javax.swing.JLabel();
        lb_keluar = new javax.swing.JLabel();
        lb_pengaturan = new javax.swing.JLabel();
        t_laporan = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        text_bar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        t_username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        t_password = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        t_fullname = new javax.swing.JTextField();
        lb_gambar = new javax.swing.JLabel();
        btn_pilih = new javax.swing.JButton();
        t_path = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        t_akses = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        t_email = new javax.swing.JTextField();
        btn_perbarui = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_user = new custom.JTable_Custom();

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

        lbl_admin.setBackground(new java.awt.Color(178, 201, 173));
        lbl_admin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_admin.setForeground(new java.awt.Color(255, 255, 255));
        lbl_admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/admin2.png"))); // NOI18N
        lbl_admin.setText("ADMIN");
        lbl_admin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        lb_pengaturan.setBackground(new java.awt.Color(178, 201, 173));
        lb_pengaturan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_pengaturan.setForeground(new java.awt.Color(255, 255, 255));
        lb_pengaturan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_pengaturan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-setting-25.png"))); // NOI18N
        lb_pengaturan.setText("PENGATURAN");
        lb_pengaturan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_pengaturan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_pengaturanMouseClicked(evt);
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
            .addGroup(side_barLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(side_beranda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(side_obat, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(side_penjualan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(lb_keluar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_admin, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(lb_pengaturan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_laporan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                .addComponent(lb_pengaturan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setPreferredSize(new java.awt.Dimension(800, 750));

        text_bar.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        text_bar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Username");

        t_username.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Password");

        t_password.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Akses key");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Fullname");

        t_fullname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lb_gambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_gambar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_pilih.setText("Pilih File");
        btn_pilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pilihActionPerformed(evt);
            }
        });

        t_path.setEditable(false);
        t_path.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        t_path.setMaximumSize(new java.awt.Dimension(119, 25));
        t_path.setMinimumSize(new java.awt.Dimension(119, 25));
        t_path.setPreferredSize(new java.awt.Dimension(119, 25));

        btn_tambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        t_akses.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        t_akses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));
        t_akses.setSelectedIndex(1);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Email");

        t_email.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        t_email.setMaximumSize(new java.awt.Dimension(100, 25));

        btn_perbarui.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_perbarui.setText("Perbarui");
        btn_perbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_perbaruiActionPerformed(evt);
            }
        });

        btn_batal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        btn_hapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hapusMouseClicked(evt);
            }
        });
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        tbl_user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Password", "Email", "Fullname"
            }
        ));
        tbl_user.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbl_user.setGridColor(new java.awt.Color(0, 0, 0));
        tbl_user.setShowGrid(true);
        tbl_user.setShowVerticalLines(true);
        tbl_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_userMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_user);

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(t_email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainLayout.createSequentialGroup()
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(t_password, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(t_username)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(40, 40, 40)
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(t_akses, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(mainLayout.createSequentialGroup()
                                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_perbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(t_path, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_pilih, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(text_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(text_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_username, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_akses, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_password, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(t_email, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lb_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_path, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pilih, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_perbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
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

    private void btn_pilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pilihActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            t_path.setText(path);
            
            try {
            byte[] img = Files.readAllBytes(selectedFile.toPath());
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
        } catch (IOException e) {
        }
        }
    }//GEN-LAST:event_btn_pilihActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        PreparedStatement stmt = null;
        String namaUser = t_username.getText().trim().toLowerCase();
        String passUser = t_password.getText();
        String aksesKey = t_akses.getSelectedItem().toString();
        String fullname = t_fullname.getText();
        String emailUser = t_email.getText();
        
        if(namaUser.isEmpty() || passUser.isEmpty() || aksesKey.isEmpty() || fullname.isEmpty() || emailUser.isEmpty()){
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!");
            return;
        }
        
        try {
            String sql = "INSERT INTO akses (username, password, access_key, fullname, email, gambar) VALUES (?, ?, ?, ?, ?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, namaUser);
            stmt.setString(2, passUser);
            stmt.setString(3, aksesKey);
            stmt.setString(4, fullname);
            stmt.setString(5, emailUser);

            String imagePath = t_path.getText();
            if (imagePath != null && !imagePath.isEmpty()) {
                System.out.println("masuk ke validasi gambar");
                File imageFile = new File(imagePath);
                byte[] imageData;
                try (FileInputStream fis = new FileInputStream(imageFile)) {
                    imageData = new byte[(int) imageFile.length()];
                    fis.read(imageData);
                }
                stmt.setBytes(6, imageData);
            } else {
                stmt.setNull(6, java.sql.Types.BLOB);
            }           
            
            stmt.executeUpdate();
            stmt.close();
            
            JOptionPane.showMessageDialog(this, "Berhasil ditambahkan");
            resetForm();
            getDataUser();
            
            lb_gambar.setText("");
        } catch (HeadlessException | IOException | SQLException e) {
            Logger.getLogger(AdminView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void side_berandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_side_berandaMouseClicked
        BerandaView beranda = new BerandaView(username, nama, id, akses, email);
        beranda.setVisible(true);
        dispose();
    }//GEN-LAST:event_side_berandaMouseClicked

    private void btn_perbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perbaruiActionPerformed
        PreparedStatement st = null;
        String namaUser = t_username.getText().trim().toLowerCase();
        String passUser = t_password.getText();
        String aksesKey = t_akses.getSelectedItem().toString();
        String fullname = t_fullname.getText();
        String emailUser = t_email.getText();
        String imagePath = t_path.getText();
        
        if(namaUser.isEmpty() || passUser.isEmpty() || aksesKey.isEmpty() || fullname.isEmpty() || emailUser.isEmpty()){
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!");
            return;
        }
        
        String sql = "UPDATE akses SET username = ?, password = ?, access_key = ?, fullname = ?, email = ?";
        if (imagePath != null && !imagePath.isEmpty()) {
            sql += ", gambar = ?";
        }
            sql += " WHERE  username = ?";
            
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, namaUser);
            st.setString(2, passUser);
            st.setString(3, aksesKey);
            st.setString(4, fullname);
            st.setString(5, emailUser);
            
            if (imagePath != null && !imagePath.isEmpty()) {
                File imageFile = new File(imagePath);
                FileInputStream fis = new FileInputStream(imageFile);
                st.setBinaryStream(6, fis, (int) imageFile.length());
                st.setString(7, namaUser);
            } else {
                st.setString(6, namaUser);
            }
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(this, "Berhasil diperbarui");
            resetForm();
            getDataUser();
        } catch (FileNotFoundException | SQLException e) {
            Logger.getLogger(AdminView.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }//GEN-LAST:event_btn_perbaruiActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        t_username.setText("");
        t_password.setText("");
        t_email.setText("");
        t_fullname.setText("");
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void lb_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_keluarMouseClicked
        LoginView login = new LoginView();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_lb_keluarMouseClicked

    private void lb_pengaturanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_pengaturanMouseClicked
        ResetView reset = new ResetView(AdminView.this, username, nama, id, akses, email);
        AdminView admin = new AdminView(username, nama, id, akses, email);
        admin.setVisible(false);
        reset.setVisible(true);
//        dispose();
    }//GEN-LAST:event_lb_pengaturanMouseClicked

    private void side_obatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_side_obatMouseClicked
        KelolaView kelola = new KelolaView(username, nama, id, akses, email);
        kelola.setVisible(true);
        dispose();
    }//GEN-LAST:event_side_obatMouseClicked

    private void tbl_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_userMouseClicked
        int selectedRow = tbl_user.getSelectedRow();
        if (selectedRow != -1) {
            String userName = tbl_user.getValueAt(selectedRow, 0).toString();
            String pass = tbl_user.getValueAt(selectedRow, 1).toString();
            String emailUser = tbl_user.getValueAt(selectedRow, 2).toString();
            String fullname = tbl_user.getValueAt(selectedRow, 3).toString();

            t_username.setText(userName);
            t_password.setText(pass);
            t_email.setText(emailUser);
            t_fullname.setText(fullname);
        }    
    }//GEN-LAST:event_tbl_userMouseClicked

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

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked
       int selectedRow = tbl_user.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan dihapus");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String namaUser = tbl_user.getValueAt(selectedRow, 0).toString();
            try {
                String sql = "DELETE FROM akses WHERE username = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, namaUser);
                
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
        getDataUser();
    }//GEN-LAST:event_btn_hapusMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_perbarui;
    private javax.swing.JButton btn_pilih;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_gambar;
    private javax.swing.JLabel lb_keluar;
    private javax.swing.JLabel lb_pengaturan;
    private javax.swing.JLabel lbl_admin;
    private javax.swing.JPanel main;
    private javax.swing.JPanel side_bar;
    private javax.swing.JLabel side_beranda;
    private javax.swing.JLabel side_obat;
    private javax.swing.JLabel side_penjualan;
    private javax.swing.JComboBox<String> t_akses;
    private javax.swing.JTextField t_email;
    private javax.swing.JTextField t_fullname;
    private javax.swing.JLabel t_laporan;
    private javax.swing.JTextField t_password;
    private javax.swing.JTextField t_path;
    private javax.swing.JTextField t_username;
    private custom.JTable_Custom tbl_user;
    private javax.swing.JLabel text_bar;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {
        t_username.setText("");
        t_password.setText("");
        t_akses.setSelectedItem(null);
        t_fullname.setText("");
        t_path.setText("");
        t_email.setText("");
        t_path.setText(null);
    }
}
