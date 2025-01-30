
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import koneksi_db.Koneksi;

public class BerandaTest extends javax.swing.JFrame {
    private Connection conn;
    ResultSet rs;
    private Blob gambar;
    private static String username;
    private static String nama;
    private static int id;
    
    public BerandaTest(String username, String nama, int id) {
        initComponents();
        
        setTitle("Beranda Apotek");
//        ImageIcon image = new ImageIcon("../img/icon_farma.png");
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/icon_farma.png"));
//        Image icon = Toolkit.getDefaultToolkit().getImage("img/icon_farma.png");
        setIconImage(image);
        
        // Koneksi Database
        conn = Koneksi.getConnect();
        
        // Kirim parameter
        this.id = id;
        this.username = username;
        
        // custom tampilan
        side_beranda.setOpaque(true);
        side_beranda.setBackground(new Color(75, 89, 69));
        text_bar.setText("SELAMAT DATANG KEMBALI, " + username.toUpperCase());
        lb_nama.setText(nama.toUpperCase());               
//        text_bar.setHorizontalAlignment(SwingConstants.CENTER);
//        text_bar.setText("<html>Selamat Datang,<br>ADMIN</html>");
        
        // Pemanggilan method
        Jam();
        Shift();
        getData();
    }
    
    public BerandaTest(String username){
        super(username);
        initComponents();
        
//        this.id = id;
        
        conn = Koneksi.getConnect();
        
        side_beranda.setOpaque(true);
        side_beranda.setBackground(new Color(75, 89, 69));
        text_bar.setText("SELAMAT DATANG KEMBALI, " + username.toUpperCase());
        lb_nama.setText(username.toUpperCase());
    }
    
    public void Jam() {
        Map<String, String> hariMap = new HashMap<>();
        hariMap.put("Mon", "Senin");
        hariMap.put("Tue", "Selasa");
        hariMap.put("Wed", "Rabu");
        hariMap.put("Thu", "Kamis");
        hariMap.put("Fri", "Jumat");
        hariMap.put("Sat", "Sabtu");
        hariMap.put("Sun", "Minggu");
        
        new Timer(1000, e -> {
            Calendar calendar = Calendar.getInstance();
//            SimpleDateFormat format = new SimpleDateFormat("E, dd HH:mm:ss");
            SimpleDateFormat formatTanggal = new SimpleDateFormat("E, dd - MM - yy");
            SimpleDateFormat formatWaktu = new SimpleDateFormat("HH:mm");
            String tanggalSekarang = formatTanggal.format(calendar.getTime());
            String waktuSekarang = formatWaktu.format(calendar.getTime());
            
        for (Map.Entry<String, String> entry : hariMap.entrySet()) {
            tanggalSekarang = tanggalSekarang.replace(entry.getKey(), entry.getValue());
        }
            
            lb_tanggal.setText(tanggalSekarang);
            lb_jam.setText(waktuSekarang);
        }).start();
    }
    
    public void Shift() {
        new Timer(1000, e -> {
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
    
    public void getData() {
        String sql = "SELECT gambar FROM akses WHERE id = " + id;
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Blob gambarBlob = rs.getBlob("gambar");
                try {
//                    // kode ini salah
//                    byte[] img = gambarBlob.getBytes(1, (int) gambarBlob.getGambar);
                    long blobLength = gambarBlob.length();
                    // Membaca seluruh blob ke dalam array byte
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
                } catch (Exception e) {
                    lb_gambar.setText("Tidak ada gambar");
                }
            }
        } catch (Exception e) {
            Logger.getLogger(BerandaTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_bar = new javax.swing.JPanel();
        side_obat = new javax.swing.JLabel();
        side_beranda = new javax.swing.JLabel();
        side_penjualan = new javax.swing.JLabel();
        lb_tanggal = new javax.swing.JLabel();
        lb_jam = new javax.swing.JLabel();
        lb_user = new javax.swing.JLabel();
        lb_keluar = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        text_bar = new javax.swing.JLabel();
        lb_gambar = new javax.swing.JLabel();
        text_nama = new javax.swing.JLabel();
        lb_nama = new javax.swing.JLabel();
        text_email = new javax.swing.JLabel();
        lb_email = new javax.swing.JLabel();
        lb_jmlh = new javax.swing.JTextField();
        navbar = new javax.swing.JPanel();
        lb_shift = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 750));
        setName("Beranda"); // NOI18N
        setResizable(false);

        side_bar.setBackground(new java.awt.Color(41, 54, 36));
        side_bar.setPreferredSize(new java.awt.Dimension(200, 750));

        side_obat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        side_obat.setForeground(new java.awt.Color(255, 255, 255));
        side_obat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        side_obat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/obat.png"))); // NOI18N
        side_obat.setText(" MANAGE OBAT");

        side_beranda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        side_beranda.setForeground(new java.awt.Color(255, 255, 255));
        side_beranda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        side_beranda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/beranda3.png"))); // NOI18N
        side_beranda.setText(" BERANDA");

        side_penjualan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        side_penjualan.setForeground(new java.awt.Color(255, 255, 255));
        side_penjualan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        side_penjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/penjualan.png"))); // NOI18N
        side_penjualan.setText(" PENJUALAN");

        lb_tanggal.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lb_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lb_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lb_jam.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lb_jam.setForeground(new java.awt.Color(255, 255, 255));
        lb_jam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_jam.setPreferredSize(new java.awt.Dimension(200, 25));

        lb_user.setBackground(new java.awt.Color(178, 201, 173));
        lb_user.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_user.setForeground(new java.awt.Color(255, 255, 255));
        lb_user.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-setting-25.png"))); // NOI18N
        lb_user.setText("USER");
        lb_user.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_userMouseClicked(evt);
            }
        });

        lb_keluar.setBackground(new java.awt.Color(178, 201, 173));
        lb_keluar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_keluar.setForeground(new java.awt.Color(255, 255, 255));
        lb_keluar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-logout-25.png"))); // NOI18N
        lb_keluar.setText("LOG OUT");
        lb_keluar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_keluar.setPreferredSize(new java.awt.Dimension(175, 25));
        lb_keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_keluarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout side_barLayout = new javax.swing.GroupLayout(side_bar);
        side_bar.setLayout(side_barLayout);
        side_barLayout.setHorizontalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_barLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(side_penjualan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(side_obat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(side_beranda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(side_barLayout.createSequentialGroup()
                        .addComponent(lb_jam, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, side_barLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_tanggal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_keluar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        side_barLayout.setVerticalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_barLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lb_jam, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(side_beranda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(side_obat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(side_penjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 408, Short.MAX_VALUE)
                .addComponent(lb_user, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setPreferredSize(new java.awt.Dimension(800, 700));

        text_bar.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        text_bar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lb_gambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_gambar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        text_nama.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        text_nama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        text_nama.setText("Nama");

        lb_nama.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_nama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        text_email.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        text_email.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        text_email.setText("Email");

        lb_email.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_email.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(text_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_jmlh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(lb_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(text_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lb_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(text_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lb_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61)
                .addComponent(lb_jmlh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(281, Short.MAX_VALUE))
        );

        navbar.setBackground(new java.awt.Color(90, 108, 87));
        navbar.setPreferredSize(new java.awt.Dimension(800, 50));

        lb_shift.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lb_shift.setForeground(new java.awt.Color(255, 255, 255));
        lb_shift.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_shift.setPreferredSize(new java.awt.Dimension(200, 30));

        javax.swing.GroupLayout navbarLayout = new javax.swing.GroupLayout(navbar);
        navbar.setLayout(navbarLayout);
        navbarLayout.setHorizontalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarLayout.createSequentialGroup()
                .addContainerGap(580, Short.MAX_VALUE)
                .addComponent(lb_shift, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        navbarLayout.setVerticalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_shift, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void lb_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_userMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_userMouseClicked

    private void lb_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_keluarMouseClicked
        dispose();
    }//GEN-LAST:event_lb_keluarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Template.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Template.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Template.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Template.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Template().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_email;
    private javax.swing.JLabel lb_gambar;
    private javax.swing.JLabel lb_jam;
    private javax.swing.JTextField lb_jmlh;
    private javax.swing.JLabel lb_keluar;
    private javax.swing.JLabel lb_nama;
    private javax.swing.JLabel lb_shift;
    private javax.swing.JLabel lb_tanggal;
    private javax.swing.JLabel lb_user;
    private javax.swing.JPanel main;
    private javax.swing.JPanel navbar;
    private javax.swing.JPanel side_bar;
    private javax.swing.JLabel side_beranda;
    private javax.swing.JLabel side_obat;
    private javax.swing.JLabel side_penjualan;
    private javax.swing.JLabel text_bar;
    private javax.swing.JLabel text_email;
    private javax.swing.JLabel text_nama;
    // End of variables declaration//GEN-END:variables
}
