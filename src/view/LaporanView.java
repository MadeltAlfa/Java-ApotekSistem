package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jnafilechooser.api.JnaFileChooser;
import koneksi_db.Koneksi;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import servis.*;

public class LaporanView extends javax.swing.JFrame {
    private final Connection conn;
    private static String username;
    private static String nama;
    private static int id;
    private static String akses;
    private static String email;
    
    public LaporanView(String username, String nama, int id, String akses, String email) {
        initComponents();
        conn = Koneksi.getConnect();
        
        LaporanView.username = username;
        LaporanView.nama = nama;
        LaporanView.id = id;
        LaporanView.akses = akses;       
        LaporanView.email = email;
        
        setTitle("Laporan Penjualan");
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/icon_farma.png"));
        setIconImage(image);
        t_laporan.setOpaque(true);
        t_laporan.setBackground(new Color(75, 89, 69));
        
        getData();
        getDataHasil();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_bar = new javax.swing.JPanel();
        t_obat = new javax.swing.JLabel();
        t_beranda = new javax.swing.JLabel();
        t_penjualan = new javax.swing.JLabel();
        lbl_admin = new javax.swing.JLabel();
        t_pengaturan = new javax.swing.JLabel();
        t_keluar = new javax.swing.JLabel();
        t_laporan = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        t_cari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_laporan = new custom.JTable_Custom();
        jLabel2 = new javax.swing.JLabel();
        t_excel = new javax.swing.JButton();
        text_bar1 = new javax.swing.JLabel();
        t_pdf = new javax.swing.JButton();
        t_hasil = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        side_bar.setBackground(new java.awt.Color(41, 54, 36));
        side_bar.setPreferredSize(new java.awt.Dimension(200, 750));

        t_obat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        t_obat.setForeground(new java.awt.Color(255, 255, 255));
        t_obat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        t_obat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/obat.png"))); // NOI18N
        t_obat.setText("  MANAGE OBAT");
        t_obat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_obatMouseClicked(evt);
            }
        });

        t_beranda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        t_beranda.setForeground(new java.awt.Color(255, 255, 255));
        t_beranda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        t_beranda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/beranda3.png"))); // NOI18N
        t_beranda.setText("  BERANDA");
        t_beranda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_berandaMouseClicked(evt);
            }
        });

        t_penjualan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        t_penjualan.setForeground(new java.awt.Color(255, 255, 255));
        t_penjualan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        t_penjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/penjualan.png"))); // NOI18N
        t_penjualan.setText("  PENJUALAN");
        t_penjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_penjualanMouseClicked(evt);
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

        t_laporan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        t_laporan.setForeground(new java.awt.Color(255, 255, 255));
        t_laporan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        t_laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-note-30.png"))); // NOI18N
        t_laporan.setText("  LAPORAN");

        javax.swing.GroupLayout side_barLayout = new javax.swing.GroupLayout(side_bar);
        side_bar.setLayout(side_barLayout);
        side_barLayout.setHorizontalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, side_barLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(t_laporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_penjualan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_admin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_obat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(t_beranda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_keluar, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(t_pengaturan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                .addComponent(t_pengaturan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setPreferredSize(new java.awt.Dimension(800, 750));

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

        tbl_laporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tanggal", "Total"
            }
        ));
        tbl_laporan.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tbl_laporan.setShowVerticalLines(true);
        jScrollPane2.setViewportView(tbl_laporan);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setText("Export :");
        jLabel2.setMaximumSize(new java.awt.Dimension(75, 16));

        t_excel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        t_excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel-25.png"))); // NOI18N
        t_excel.setText("Excel");
        t_excel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_excelMouseClicked(evt);
            }
        });

        text_bar1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        text_bar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text_bar1.setText("LAPORAN");

        t_pdf.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        t_pdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-pdf-25 (1).png"))); // NOI18N
        t_pdf.setText("Pdf");
        t_pdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_pdfMouseClicked(evt);
            }
        });

        t_hasil.setEditable(false);
        t_hasil.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(text_bar1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(257, 257, 257))
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(t_excel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(t_pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(t_hasil, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(text_bar1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(t_hasil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t_excel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
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

    private void lbl_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_adminMouseClicked
        if (akses.equals("admin")) {
            AdminView admin = new AdminView(username, nama, id, akses, email);
            admin.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Anda bukan admin", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_lbl_adminMouseClicked

    private void t_berandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_berandaMouseClicked
        BerandaView beranda = new BerandaView(username, nama, id, akses, email);
        beranda.setVisible(true);
        dispose();
    }//GEN-LAST:event_t_berandaMouseClicked

    private void t_pengaturanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_pengaturanMouseClicked
        ResetView reset = new ResetView(LaporanView.this, username, nama, id, akses, email);
        reset.setVisible(true);
        dispose();
    }//GEN-LAST:event_t_pengaturanMouseClicked

    private void t_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_keluarMouseClicked
        LoginView login = new LoginView();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_t_keluarMouseClicked

    private void t_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_cariKeyTyped
        DefaultTableModel model = (DefaultTableModel) tbl_laporan.getModel();
        model.setRowCount(0);
        
        String cari = t_cari.getText();
        ResultSet resultSet;
        
        try {
            String sql = "SELECT * FROM transaksi WHERE id_transaksi LIKE ? OR tanggal_transaksi LIKE ? OR total_transaksi LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yy", new Locale("id", "ID"));
                stmt.setString(1, "%" + cari + "%");
                stmt.setString(2, "%" + cari + "%");
                stmt.setString(3, "%" + cari + "%");
            resultSet = stmt.executeQuery();
            
            while (resultSet.next()) {                
                String idTransaksi = resultSet.getString("id_transaksi");
                String tglTransaksi = dateFormat.format(resultSet.getDate("tanggal_transaksi"));
                int totaltransaksi = resultSet.getInt("total_transaksi");
                
                
                Object[] rowData = {idTransaksi, tglTransaksi, totaltransaksi};
                model.addRow(rowData);                
            }
            
            resultSet.close();
            stmt.close();
        } catch (SQLException e) {
            Logger.getLogger(LaporanView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_t_cariKeyTyped

    private void t_penjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_penjualanMouseClicked
        PenjualanView penjualan = new PenjualanView(username, nama, id, akses, email);
        penjualan.setVisible(true);
        dispose();
    }//GEN-LAST:event_t_penjualanMouseClicked

    private void t_obatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_obatMouseClicked
        KelolaView kelola = new KelolaView(username, nama, id, akses, email);
        kelola.setVisible(true);
        dispose();
    }//GEN-LAST:event_t_obatMouseClicked

    private void t_pdfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_pdfMouseClicked
        int confirm = JOptionPane.showConfirmDialog(this, "Print dan hapus semua data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                String reportPath = "src/file/laporan.jasper";
        
                HashMap<String, Object> parameters = new HashMap<>();
        
                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setVisible(true);
            } catch (JRException e) {
                Logger.getLogger(LaporanView.class.getName()).log(Level.SEVERE, null, e);
            }
            
            try {
                String deleteNotaQuery = "DELETE FROM transaksi";
                PreparedStatement notaStmt = conn.prepareStatement(deleteNotaQuery);
                notaStmt.executeUpdate();
            } catch (SQLException e) {
                Logger.getLogger(LaporanView.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            try {
                String reportPath = "src/file/laporan.jasper";
        
                HashMap<String, Object> parameters = new HashMap<>();
        
                JasperPrint print = JasperFillManager.fillReport(reportPath, parameters, conn);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setVisible(true);
            } catch (JRException e) {
                 Logger.getLogger(LaporanView.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_t_pdfMouseClicked

    private void t_excelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_excelMouseClicked
        int confirm = JOptionPane.showConfirmDialog(this, "Print dan hapus semua data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            JnaFileChooser filechooser = new JnaFileChooser();
            Window window = null;
            boolean action = filechooser.showSaveDialog(window);
            if (action) {
                String fileString = filechooser.getSelectedFile().getAbsolutePath() + ".xlsx";
                ServisExcel servisExcel = new Excel();
                servisExcel.exportToExcel(tbl_laporan, fileString);
            }
            
            try {
                String deleteNotaQuery = "DELETE FROM transaksi";
                PreparedStatement notaStmt = conn.prepareStatement(deleteNotaQuery);
                notaStmt.executeUpdate();
            } catch (SQLException e) {
                Logger.getLogger(LaporanView.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
             JnaFileChooser filechooser = new JnaFileChooser();
            Window window = null;
            boolean action = filechooser.showSaveDialog(window);
            if (action) {
                String fileString = filechooser.getSelectedFile().getAbsolutePath() + ".xlsx";
                ServisExcel servisExcel = new Excel();
                servisExcel.exportToExcel(tbl_laporan, fileString);
            }
        }
    }//GEN-LAST:event_t_excelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_admin;
    private javax.swing.JPanel main;
    private javax.swing.JPanel side_bar;
    private javax.swing.JLabel t_beranda;
    private javax.swing.JTextField t_cari;
    private javax.swing.JButton t_excel;
    private javax.swing.JTextField t_hasil;
    private javax.swing.JLabel t_keluar;
    private javax.swing.JLabel t_laporan;
    private javax.swing.JLabel t_obat;
    private javax.swing.JButton t_pdf;
    private javax.swing.JLabel t_pengaturan;
    private javax.swing.JLabel t_penjualan;
    private custom.JTable_Custom tbl_laporan;
    private javax.swing.JLabel text_bar1;
    // End of variables declaration//GEN-END:variables

    private void getData() {
//       DefaultTableModel model = (DefaultTableModel) tbl_laporan.getModel();
       DefaultTableModel model = new DefaultTableModel();
//       model.setRowCount(0);
        
//        try {
//           String sql = "SELECT * FROM transaksi";
//           PreparedStatement stmt = conn.prepareStatement(sql);
//           ResultSet rest = stmt.executeQuery();
//           SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("id", "ID"));
//           
//           while (rest.next()) { 
//               String no = rest.getString("id_transaksi");
//               int total = rest.getInt("total_transaksi");
//               String tanggal = dateFormat.format(rest.getDate("tanggal_transaksi"));
//               
//               Object[] rowData = {no, tanggal, total};
//               model.addRow(rowData);
//           }
//            
//            rest.close();
//            stmt.close();
//        } catch (SQLException e) {
//            Logger.getLogger(KelolaView.class.getName()).log(Level.SEVERE, null, e);
//        }
        model.addColumn("id_transaksi");
        model.addColumn("total_transaksi");
        model.addColumn("tanggal_transaksi");
        
        ServisExcel servisExcel = new Excel();
        servisExcel.getData(model);
        tbl_laporan.setModel(model);
    }

    private void getDataHasil() {
        try {
            String sql = "SELECT SUM(total_transaksi) AS total FROM transaksi;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String hasil = rs.getString("total");
                
//                String hasilStr = (String) hasil;
//                t_hasil.setText(hasil);
                if (!hasil.equals("")) {
                    String hargaStr = hasil.replaceAll("[^\\d]", "");
                    double hargaRp = Double.parseDouble(hargaStr);
                    DecimalFormat dec = new DecimalFormat("#,###,###");
                    t_hasil.setText(dec.format(hargaRp));
                }
            }          
            
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            Logger.getLogger(LaporanView.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
