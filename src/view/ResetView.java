package view;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import koneksi_db.Koneksi;

public class ResetView extends javax.swing.JFrame {
    private final Connection conn;
    private static String username;
    private final JFrame previousFrame;
    
    public ResetView(JFrame previousFrame, String username,  String nama, int id, String akses, String email) {
        initComponents();
        conn = Koneksi.getConnect();
        this.previousFrame = previousFrame;
        ResetView.username = username;
        
        setTitle("Reset Password");
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/icon_farma.png"));
        setIconImage(image);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frame_kiri = new javax.swing.JPanel();
        lb_gambar = new javax.swing.JLabel();
        lb_pass1 = new javax.swing.JLabel();
        frame_kanan = new javax.swing.JPanel();
        lb_pass = new javax.swing.JLabel();
        btn_reset = new javax.swing.JButton();
        t_pass = new javax.swing.JTextField();
        lb_pass2 = new javax.swing.JLabel();
        lb_pass3 = new javax.swing.JLabel();
        btn_kembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        frame_kiri.setBackground(new java.awt.Color(41, 54, 36));
        frame_kiri.setMaximumSize(new java.awt.Dimension(300, 300));
        frame_kiri.setMinimumSize(new java.awt.Dimension(300, 300));
        frame_kiri.setPreferredSize(new java.awt.Dimension(300, 300));

        lb_gambar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lb_gambar.setForeground(new java.awt.Color(255, 255, 255));
        lb_gambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lb_pass1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lb_pass1.setForeground(new java.awt.Color(255, 255, 255));
        lb_pass1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_pass1.setText("Reset Password");

        javax.swing.GroupLayout frame_kiriLayout = new javax.swing.GroupLayout(frame_kiri);
        frame_kiri.setLayout(frame_kiriLayout);
        frame_kiriLayout.setHorizontalGroup(
            frame_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_kiriLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(lb_pass1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frame_kiriLayout.setVerticalGroup(
            frame_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_kiriLayout.createSequentialGroup()
                .addGroup(frame_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frame_kiriLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lb_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(frame_kiriLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(lb_pass1)))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        frame_kanan.setBackground(new java.awt.Color(255, 255, 255));
        frame_kanan.setMaximumSize(new java.awt.Dimension(300, 300));
        frame_kanan.setMinimumSize(new java.awt.Dimension(300, 300));
        frame_kanan.setPreferredSize(new java.awt.Dimension(300, 300));

        lb_pass.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lb_pass.setText("Password Baru");

        btn_reset.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_resetMouseClicked(evt);
            }
        });

        t_pass.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        lb_pass2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lb_pass2.setForeground(new java.awt.Color(255, 51, 51));
        lb_pass2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_pass2.setText("Password harus mengandung 1 huruf,");

        lb_pass3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lb_pass3.setForeground(new java.awt.Color(255, 51, 51));
        lb_pass3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_pass3.setText("1 angka, dan tidak ada spasi");

        btn_kembali.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_kembali.setText("Kembali");
        btn_kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_kembaliMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout frame_kananLayout = new javax.swing.GroupLayout(frame_kanan);
        frame_kanan.setLayout(frame_kananLayout);
        frame_kananLayout.setHorizontalGroup(
            frame_kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_kananLayout.createSequentialGroup()
                .addGroup(frame_kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frame_kananLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(frame_kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_pass2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(lb_pass3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(frame_kananLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(frame_kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(frame_kananLayout.createSequentialGroup()
                                .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lb_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        frame_kananLayout.setVerticalGroup(
            frame_kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_kananLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lb_pass2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lb_pass3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lb_pass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(frame_kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(frame_kanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(frame_kiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(frame_kiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(frame_kanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetMouseClicked
        String password = t_pass.getText();
        if (isValidPassword(password)) { 
            if (isValidPassword2(password)) {
                try {
                    String sql = "UPDATE akses SET password = ? WHERE username = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, password);
                    stmt.setString(2, username);
            
                    int rowUpdate = stmt.executeUpdate();
                    if (rowUpdate > 0) {
                        JOptionPane.showMessageDialog(this, "Password berhasil diubah");
                        JOptionPane.showMessageDialog(this, "Harap login kembali");
                        LoginView login = new LoginView();
                        login.setVisible(true);
                        dispose();
                    }
            
                    stmt.close();
                } catch (SQLException e) {
                    Logger.getLogger(ResetView.class.getName()).log(Level.SEVERE, null, e);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Password tidak boleh ada spasi");
            resetForm();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Password harus mengandung minimal 1 huruf dan 1 angka.");
            resetForm();
        }
    }//GEN-LAST:event_btn_resetMouseClicked

    private void btn_kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kembaliMouseClicked
//        BerandaView beranda = new BerandaView(username, nama, id, akses, email);
//        beranda.setVisible(true);
//        dispose();
        previousFrame.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btn_kembaliMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_kembali;
    private javax.swing.JButton btn_reset;
    private javax.swing.JPanel frame_kanan;
    private javax.swing.JPanel frame_kiri;
    private javax.swing.JLabel lb_gambar;
    private javax.swing.JLabel lb_pass;
    private javax.swing.JLabel lb_pass1;
    private javax.swing.JLabel lb_pass2;
    private javax.swing.JLabel lb_pass3;
    private javax.swing.JTextField t_pass;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {
        t_pass.setText("");
    }
    
    private boolean isValidPassword(String password) {
        // Regex untuk memeriksa minimal 1 huruf dan 1 angka
//        String regex = "^(?=.*[0-9])(?=.*[a-zA-Z])(?\\S).*$";
//        String regex = "[a-zA-Z0-9";
//        String regex = ".*[a-zA-Z].*[0-9].*";
        String regex = ".*[a-zA-Z].*[0-9]+$";
//        String regex = "^[a-zA-Z0-9]+$";
        return password.matches(regex);
    }
    
        private boolean isValidPassword2(String password) {
        // Regex untuk memeriksa minimal 1 huruf dan 1 angka
//        String regex = "^(?=.*[0-9])(?=.*[a-zA-Z])(?\\S).*$";
//        String regex = "[a-zA-Z0-9";
//        String regex = ".*[a-zA-Z].*[0-9].*";
//        String regex = ".*[a-zA-Z].*[0-9]+$";
        String regex = "^[a-zA-Z0-9]+$";
        return password.matches(regex);
    }
}
