package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi_db.Koneksi;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class PenjualanView extends javax.swing.JFrame {
    private final Connection conn;
    ResultSet rest;
    private static String username;
    static String nama;
    static int id;
    static String akses;
    static String email;
    private int total = 0;
    private int uangKembalian = 0;
    private int stokUpdate = 0;
    
    public PenjualanView(String username, String nama, int id, String akses, String email) {
        initComponents();
        conn = Koneksi.getConnect();
        PenjualanView.username = username;
        PenjualanView.nama = nama;
        PenjualanView.id = id;
        PenjualanView.akses = akses;
        PenjualanView.email = email;
        
        setTitle("Penjualan Obat");
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/icon_farma.png"));
        setIconImage(image);
        t_penjualan.setOpaque(true);
        t_penjualan.setBackground(new Color(75, 89, 69));
        
        getDataObat();
//        getDataStruk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_bar = new javax.swing.JPanel();
        t_obat = new javax.swing.JLabel();
        t_beranda = new javax.swing.JLabel();
        t_penjualan = new javax.swing.JLabel();
        t_admin = new javax.swing.JLabel();
        t_keluar = new javax.swing.JLabel();
        t_pengaturan = new javax.swing.JLabel();
        t_laporan = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        text_bar1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        t_namaItem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        t_jumlahItem = new javax.swing.JTextField();
        t_cari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_obat = new custom.JTable_Custom();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        t_uang = new javax.swing.JTextField();
        t_kembalian = new javax.swing.JTextField();
        t_total = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_display = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        side_bar.setBackground(new java.awt.Color(41, 54, 36));
        side_bar.setPreferredSize(new java.awt.Dimension(200, 750));

        t_obat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        t_obat.setForeground(new java.awt.Color(255, 255, 255));
        t_obat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        t_obat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/obat.png"))); // NOI18N
        t_obat.setText(" MANAGE OBAT");
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
        t_beranda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_berandaMouseClicked(evt);
            }
        });

        t_penjualan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        t_penjualan.setForeground(new java.awt.Color(255, 255, 255));
        t_penjualan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        t_penjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/penjualan.png"))); // NOI18N
        t_penjualan.setText(" PENJUALAN");

        t_admin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        t_admin.setForeground(new java.awt.Color(255, 255, 255));
        t_admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/admin2.png"))); // NOI18N
        t_admin.setText("ADMIN");
        t_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_adminMouseClicked(evt);
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
                    .addComponent(t_penjualan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_obat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_beranda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_keluar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(t_admin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_pengaturan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_laporan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        side_barLayout.setVerticalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_barLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(t_beranda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_obat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_penjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
                .addComponent(t_pengaturan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setPreferredSize(new java.awt.Dimension(800, 750));

        text_bar1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        text_bar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text_bar1.setText("PEMBAYARAN");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Nama Item");

        t_namaItem.setEditable(false);
        t_namaItem.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        t_namaItem.setMaximumSize(new java.awt.Dimension(150, 25));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Jumlah Item");

        t_jumlahItem.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        t_jumlahItem.setMaximumSize(new java.awt.Dimension(150, 25));

        t_cari.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        t_cari.setForeground(new java.awt.Color(153, 153, 153));
        t_cari.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_cari.setText("Cari");
        t_cari.setMaximumSize(new java.awt.Dimension(150, 25));
        t_cari.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_cariFokus(evt);
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

        tbl_obat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id obat", "Nama", "Harga", "Stok", "Kadaluarsa"
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

        btn_tambah.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_tambah.setText("Tambah");
        btn_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tambahMouseClicked(evt);
            }
        });

        btn_hapus.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hapusMouseClicked(evt);
            }
        });

        btn_print.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_print.setText("Print");
        btn_print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_printMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Display");

        t_uang.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        t_uang.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        t_uang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_uangActionPerformed(evt);
            }
        });
        t_uang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_uangKeyReleased(evt);
            }
        });

        t_kembalian.setEditable(false);
        t_kembalian.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        t_kembalian.setForeground(new java.awt.Color(255, 51, 51));
        t_kembalian.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        t_total.setEditable(false);
        t_total.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        t_total.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        t_total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_totalKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Total :");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Bayar :");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Kembalian :");

        t_display.setEditable(false);
        t_display.setColumns(20);
        t_display.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        t_display.setRows(5);
        jScrollPane1.setViewportView(t_display);

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addComponent(text_bar1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(257, 257, 257))
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(t_cari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainLayout.createSequentialGroup()
                            .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(t_namaItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(t_jumlahItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(mainLayout.createSequentialGroup()
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_kembalian, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(t_total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_uang, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_bar1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_namaItem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_jumlahItem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(t_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(t_uang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(t_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
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

    private void t_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_adminMouseClicked
        if (akses.equals("admin")) {
            AdminView admin = new AdminView(username, nama, id, akses, email);
            admin.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Anda bukan admin", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_t_adminMouseClicked

    private void t_berandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_berandaMouseClicked
        BerandaView beranda = new BerandaView(username, nama, id, akses, email);
        beranda.setVisible(true);
        dispose();
    }//GEN-LAST:event_t_berandaMouseClicked

    private void t_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_keluarMouseClicked
        LoginView login = new LoginView();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_t_keluarMouseClicked

    private void t_pengaturanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_pengaturanMouseClicked
        ResetView reset = new ResetView(PenjualanView.this, username, nama, id, akses, email);
        reset.setVisible(true);
        dispose();
    }//GEN-LAST:event_t_pengaturanMouseClicked

    private void t_obatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_obatMouseClicked
        KelolaView kelola = new KelolaView(username, nama, id, akses, email);
        kelola.setVisible(true);
        dispose();
    }//GEN-LAST:event_t_obatMouseClicked

    private void tbl_obatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_obatMouseClicked
        int selectedRow = tbl_obat.getSelectedRow();
        if (selectedRow != -1) {           
            String namaObat = tbl_obat.getValueAt(selectedRow, 1).toString();
//            String harga = tbl_obat.getValueAt(selectedRow, 2).toString();
//            String stokObat = tbl_obat.getValueAt(selectedRow, 3).toString();
//            String kadaluarsa = tbl_obat.getValueAt(selectedRow, 4).toString();

            t_namaItem.setText(namaObat);
            t_jumlahItem.setText("1");        
        }
    }//GEN-LAST:event_tbl_obatMouseClicked

    private void btn_tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMouseClicked
        int selectedRow = tbl_obat.getSelectedRow();
        
         if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Pilih baris yang akan diperbarui");
            return;
        }
        
        String idObat = tbl_obat.getValueAt(selectedRow, 0).toString();
        String namaObat = tbl_obat.getValueAt(selectedRow, 1).toString();
        int hargaObat = (int) tbl_obat.getValueAt(selectedRow, 2);
        int stokObat = (int) tbl_obat.getValueAt(selectedRow, 3);
        String kadaluarsa = tbl_obat.getValueAt(selectedRow, 4).toString();
        
        int stokDijual = Integer.parseInt(t_jumlahItem.getText());
        
        int hargaTotal = stokDijual * hargaObat;
        
        // Hitung harga obat
        total = hargaTotal + total;
        String totalString = String.valueOf(total);
//        t_total.setText(totalString);
        
        if (!totalString.equals("")) {
            String hargaStr = totalString.replaceAll("[^\\d]", "");
            double hargaRp = Double.parseDouble(hargaStr);
            DecimalFormat dec = new DecimalFormat("#,###,###");
            t_total.setText(dec.format(hargaRp));
        }
        
        // Hitung stok obat
        stokUpdate = stokObat - stokDijual;
        
        try {    
            String sql = "INSERT INTO struk(id_obat, name, harga_satuan, jumlah_item, total_harga_item) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement add = conn.prepareStatement(sql);
            add.setString(1, idObat);
            add.setString(2, namaObat);
            add.setInt(3, hargaObat);
            add.setInt(4, stokDijual);    
            add.setInt(5, hargaTotal);
            
            int rowsAffected = add.executeUpdate(); 
           
            if (rowsAffected > 0) {
                System.out.println("Obat Sukses Ditambahkan");
            }  
            
            add.close();
            updateDataObat(stokUpdate, idObat);
            displayObat(hargaObat);
            getDataObat();
            
            t_namaItem.setText("");
            t_jumlahItem.setText("");
        } catch (SQLException e) {
            Logger.getLogger(KelolaView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btn_tambahMouseClicked

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked
        t_display.setText("");
        t_total.setText("");
        t_uang.setText("");
        t_kembalian.setText("");
        total = 0;
        i = 0;
        
        try {
            String sql = "SELECT id_obat, SUM(jumlah_item) AS total_item FROM struk GROUP BY id_obat;"; 
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rst = stmt.executeQuery();
            
            String updateQuery = "UPDATE daftar_obat SET quantity = quantity + ? WHERE id_obat = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            
            while (rst.next()) {
                String idObat = rst.getString("id_obat");
                int stokObat = rst.getInt("total_item");
                updateStmt.setInt(1, stokObat);
                updateStmt.setString(2, idObat);
                updateStmt.addBatch();
           }
            
            int[] rowsAffected = updateStmt.executeBatch();
            if (rowsAffected.length > 0) {
                System.out.println("Stok berhasil diperbarui.");
            } else {
                System.out.println("Tidak ada baris yang diperbarui.");
            }
            
            String deleteStrukQuery = "DELETE FROM struk";
            PreparedStatement deleteStmt = conn.prepareStatement(deleteStrukQuery);
            deleteStmt.executeUpdate();
            
            String deleteNotaQuery = "DELETE FROM struk_nota";
            PreparedStatement notaStmt = conn.prepareStatement(deleteNotaQuery);
            notaStmt.executeUpdate();

            stmt.close();
            updateStmt.close();
            deleteStmt.close();
            rst.close();
            notaStmt.close();
            
            getDataObat();
        } catch (SQLException e) {
            Logger.getLogger(PenjualanView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btn_hapusMouseClicked

    private void btn_printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printMouseClicked
        if (t_uang.getText().isEmpty() && t_kembalian.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan uang yang dibayarkan");
            return;
        }
        
        int bayar = Integer.parseInt(t_uang.getText().replace( ",", ""));
        int kembalian = Integer.parseInt(t_kembalian.getText().replace( ",", ""));
        
        try {            
            String query = "INSERT INTO struk_nota(bayar, kembalian) VALUES (?, ?)";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, bayar);
            stm.setInt(2, kembalian);
                
            int rowsAffected = stm.executeUpdate(); 
            if (rowsAffected > 0) {
                System.out.println("Sukses struk_nota");
            }
            
            stm.close();
        } catch (SQLException e) {
             Logger.getLogger(PenjualanView.class.getName()).log(Level.SEVERE, null, e);
        }
        
        try {
            String reportPath = "src/file/struk.jasper";
        
            HashMap<String, Object> parameters = new HashMap<>();
        
            JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);
        } catch (JRException e) {
            Logger.getLogger(PenjualanView.class.getName()).log(Level.SEVERE, null, e);
        }     
        
        try {
            String sql = "SELECT SUM(total_harga_item) AS total_harga FROM struk"; 
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rst = stmt.executeQuery();
            
            String query = "INSERT INTO transaksi(id_transaksi, total_transaksi) VALUES (?, ?)";
            PreparedStatement stm = conn.prepareStatement(query);
            
            if (rst.next()) {
                int harga_total = rst.getInt("total_harga");
                stm.setString(1, generateAngkaTRS());
                stm.setInt(2, harga_total);
                
                 int rowsAffected = stm.executeUpdate(); 
                 if (rowsAffected > 0) {
                     System.out.println("Sukses");
                }
            }
            
            String deleteStrukQuery = "DELETE FROM struk";
            PreparedStatement deleteStmt = conn.prepareStatement(deleteStrukQuery);
            deleteStmt.executeUpdate();
            
            String deleteNotaQuery = "DELETE FROM struk_nota";
            PreparedStatement notaStmt = conn.prepareStatement(deleteNotaQuery);
            notaStmt.executeUpdate();
            
            rst.close();
            stmt.close();
            stm.close();
            deleteStmt.close();
            notaStmt.close();
            
        } catch (SQLException e) {
            Logger.getLogger(PenjualanView.class.getName()).log(Level.SEVERE, null, e);
        }
        
        i = 0;
        t_uang.setText("");
        t_kembalian.setText("");
    }//GEN-LAST:event_btn_printMouseClicked

    private void t_uangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_uangActionPerformed
                int uang = Integer.parseInt(t_uang.getText().replace( ",", ""));
        uangKembalian = uang - total;
        String uangKembalianString = String.valueOf(uangKembalian);
        
        if (!uangKembalianString.equals("")) {
            String hargaStr = uangKembalianString.replaceAll("[^\\d]", "");
            double hargaRp = Double.parseDouble(hargaStr);
            DecimalFormat dec = new DecimalFormat("#,###,###");
            t_kembalian.setText(dec.format(hargaRp));
        }
    }//GEN-LAST:event_t_uangActionPerformed

    private void t_cariFokus(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_cariFokus
        if (t_cari.getText().equals("Cari")) {
            t_cari.setText("");
            t_cari.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_t_cariFokus

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
            String sql = "SELECT * FROM daftar_obat WHERE id_obat LIKE ? OR name LIKE ? OR price LIKE ? OR quantity LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, "%" + cari + "%");
                stmt.setString(2, "%" + cari + "%");
                stmt.setString(3, "%" + cari + "%");
                stmt.setString(4, "%" + cari + "%");
            resultSet = stmt.executeQuery();
            
            while (resultSet.next()) {                
                String idObat = resultSet.getString("id_obat");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                String expdate = resultSet.getString("expdate");
                
                
                Object[] rowData = {idObat, name, price, quantity, expdate};
                model.addRow(rowData);                
            }
            
            resultSet.close();
            stmt.close();
        } catch (SQLException e) {
            Logger.getLogger(PenjualanView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_t_cariKeyTyped

    private void t_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_laporanMouseClicked
        LaporanView laporan = new LaporanView(username, nama, id, akses, email);
        laporan.setVisible(true);
        dispose();
    }//GEN-LAST:event_t_laporanMouseClicked

    private void t_totalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_totalKeyTyped
        if (!t_total.getText().equals("")) {
            String hargaStr = t_total.getText().replaceAll("[^\\d]", "");
            double hargaRp = Double.parseDouble(hargaStr);
            DecimalFormat dec = new DecimalFormat("#,###,###");
            t_total.setText(dec.format(hargaRp));
        }
    }//GEN-LAST:event_t_totalKeyTyped

    private void t_uangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_uangKeyReleased
        if (!t_uang.getText().equals("")) {
            String hargaStr = t_uang.getText().replaceAll("[^\\d]", "");
            double hargaRp = Double.parseDouble(hargaStr);
            DecimalFormat dec = new DecimalFormat("#,###,###");
            t_uang.setText(dec.format(hargaRp));
        }
    }//GEN-LAST:event_t_uangKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel main;
    private javax.swing.JPanel side_bar;
    private javax.swing.JLabel t_admin;
    private javax.swing.JLabel t_beranda;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTextArea t_display;
    private javax.swing.JTextField t_jumlahItem;
    private javax.swing.JLabel t_keluar;
    private javax.swing.JTextField t_kembalian;
    private javax.swing.JLabel t_laporan;
    private javax.swing.JTextField t_namaItem;
    private javax.swing.JLabel t_obat;
    private javax.swing.JLabel t_pengaturan;
    private javax.swing.JLabel t_penjualan;
    private javax.swing.JTextField t_total;
    private javax.swing.JTextField t_uang;
    private custom.JTable_Custom tbl_obat;
    private javax.swing.JLabel text_bar1;
    // End of variables declaration//GEN-END:variables

    private void getDataObat() {
        DefaultTableModel model = (DefaultTableModel) tbl_obat.getModel();
        model.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM daftar_obat ORDER BY name ASC;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            rest = stmt.executeQuery();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", new Locale("id", "ID"));
            
            while (rest.next()) {    
                String idObat = rest.getString("id_obat");
                String name = rest.getString("name");
                int price = rest.getInt("price");
                int quantity = rest.getInt("quantity");
                String expdate = dateFormat.format(rest.getDate("expdate"));
                
                
                Object[] rowData = {idObat, name, price, quantity, expdate};
                model.addRow(rowData);               
            }
            
            rest.close();
            stmt.close();
        } catch (SQLException e) {
            Logger.getLogger(PenjualanView.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void updateDataObat(int stokUpdate, String idObat) {
        
        try {       
            String query = "UPDATE daftar_obat SET quantity = ? WHERE id_obat = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, stokUpdate);
                stmt.setString(2, idObat);
                
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Stok berhasil diperbarui.");
                } else {
                    System.out.println("Tidak ada baris yang diperbarui.");
                }
                
                stmt.close();
            }
            
            getDataObat();
        } catch (SQLException e) {
            Logger.getLogger(PenjualanView.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private int i = 0;
    private void displayObat(int hargaObat) {
        i++;
//       if (i == 1) {
//            t_display.setText(String.format("%sNo   Nama\tJumlah\tHarga\n%s%d   %s\t%s\t%s\n", 
//            t_display.getText(), 
//            "   ", 
//            i, 
//            t_namaItem.getText(), 
//            t_jumlahItem.getText(), 
//            hargaObat));
//        } else {
//            t_display.setText(String.format("%s%d   %s\t%s\t%s\n", 
//            t_display.getText(), 
//            i, 
//            t_namaItem.getText(), 
//            t_jumlahItem.getText(), 
//            hargaObat));
//        }
        StringBuilder displayBuilder = new StringBuilder();
            if (i == 1) {
                // Menambahkan header tabel pada tampilan pertama
                displayBuilder.append(String.format("%-4s %-20s %-10s %-10s%n", "No", "Nama", "Jumlah", "Harga"));
            }

            // Menambahkan item ke dalam tampilan
                displayBuilder.append(String.format("%-4d %-20s %-10s %-10s%n", i, t_namaItem.getText(), t_jumlahItem.getText(), hargaObat));

            // Menampilkan hasil pada t_display
            t_display.setText(t_display.getText() + displayBuilder.toString()); 
    }
    
    public static String generateAngkaTRS() {
        Random random = new Random();
        StringBuilder angka = new StringBuilder("TRS");

        // Generate 4 digit angka secara random
        for (int i = 0; i < 4; i++) {
            int digit = random.nextInt(10);
            angka.append(digit);
        }

        return angka.toString();
    }

}
