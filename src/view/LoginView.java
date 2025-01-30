package view;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import koneksi_db.Koneksi;

/*

 */
public class LoginView extends javax.swing.JFrame {
    private final Connection conn;
    ResultSet result, rest;
    int count = 0;
    
    public LoginView() {
        initComponents();
        conn = Koneksi.getConnect();

        setTitle("Login Apotek Sistem");
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/icon_farma.png"));
        setIconImage(image);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frame_kiri = new javax.swing.JPanel();
        lb_gambar = new javax.swing.JLabel();
        frame_kanan = new javax.swing.JPanel();
        t_user = new javax.swing.JTextField();
        lb_masuk = new javax.swing.JLabel();
        lb_user = new javax.swing.JLabel();
        lb_pass = new javax.swing.JLabel();
        btn_login = new javax.swing.JButton();
        t_pass = new javax.swing.JPasswordField();
        btn_keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        frame_kiri.setBackground(new java.awt.Color(41, 54, 36));
        frame_kiri.setMaximumSize(new java.awt.Dimension(300, 300));
        frame_kiri.setMinimumSize(new java.awt.Dimension(300, 300));
        frame_kiri.setPreferredSize(new java.awt.Dimension(300, 300));

        lb_gambar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lb_gambar.setForeground(new java.awt.Color(255, 255, 255));
        lb_gambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_gambar.setText("APOTEK SEHATI");

        javax.swing.GroupLayout frame_kiriLayout = new javax.swing.GroupLayout(frame_kiri);
        frame_kiri.setLayout(frame_kiriLayout);
        frame_kiriLayout.setHorizontalGroup(
            frame_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_kiriLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lb_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        frame_kiriLayout.setVerticalGroup(
            frame_kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_kiriLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(lb_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        frame_kanan.setBackground(new java.awt.Color(255, 255, 255));
        frame_kanan.setMaximumSize(new java.awt.Dimension(300, 300));
        frame_kanan.setMinimumSize(new java.awt.Dimension(300, 300));
        frame_kanan.setPreferredSize(new java.awt.Dimension(300, 300));

        t_user.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        lb_masuk.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lb_masuk.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_masuk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/masuk100.png"))); // NOI18N

        lb_user.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lb_user.setText("Username");

        lb_pass.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lb_pass.setText("Password");

        btn_login.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_login.setText("MASUK");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        t_pass.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        t_pass.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        btn_keluar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_keluar.setText("KELUAR");
        btn_keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_keluarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout frame_kananLayout = new javax.swing.GroupLayout(frame_kanan);
        frame_kanan.setLayout(frame_kananLayout);
        frame_kananLayout.setHorizontalGroup(
            frame_kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_kananLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(frame_kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(frame_kananLayout.createSequentialGroup()
                        .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(t_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(frame_kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lb_masuk, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(t_user, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(lb_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_pass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        frame_kananLayout.setVerticalGroup(
            frame_kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frame_kananLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lb_masuk, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lb_user)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_user, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_pass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(frame_kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
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

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        String username = t_user.getText().trim().toLowerCase();
        char[] pass = t_pass.getPassword();
        String passwordString = String.valueOf(pass);
        
        if (username.isEmpty() || passwordString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan username dan password");
            return;
        }

        try {
            String sql = "SELECT * FROM akses WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, passwordString);
            result = stmt.executeQuery();

            if (result.next()) {
                String akses = result.getString("access_key");
                if (akses.equals("admin")) {                   
                    String nama = result.getString("fullname");
                    int id = result.getInt("id");
                    String email = result.getString("email");
                    AdminView admin = new AdminView(username, nama, id, akses, email);
                    admin.setVisible(true);
                    dispose();
                } else {
                    String nama = result.getString("fullname");
                    int id = result.getInt("id");
                    String email = result.getString("email");
                    BerandaView beranda = new BerandaView(username, nama, id, akses, email);
                    beranda.setVisible(true);
                    dispose();
                }
            } else {
                count++;                
                if (count == 3) {
                    
                    try {
                        String sqlValidasi = "SELECT * FROM akses WHERE username = ?";                       
                        PreparedStatement statement = conn.prepareStatement(sqlValidasi);
                        statement.setString(1, username);
                        rest = statement.executeQuery();
                        
                        if (rest.next()) {
                            String aksesValidasi = rest.getString("access_key");                            
                            if (aksesValidasi.equals("user")) {
                                JOptionPane.showMessageDialog(this, "Tunggu Konfirmasi", "Jangan tutup!", JOptionPane.WARNING_MESSAGE);
                                int id = rest.getInt("id");
                                String usernameValidasi = rest.getString("username");
                                String email = rest.getString("email");
                                resetPass(id, usernameValidasi, email);                               
                            } else {
                                JOptionPane.showMessageDialog(this, "Tunggu Konfirmasi", "Jangan tutup!", JOptionPane.WARNING_MESSAGE);                               
                                resetPassAdmin();
                                resetAdmin();
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Username tidak terdaftar", "Peringatan", JOptionPane.WARNING_MESSAGE);                            
                        }
                        
                        count = 0;
                        rest.close();
                        statement.close();
                    } catch (HeadlessException | SQLException e) {
                        Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, e);
                    }                    
                    
                    resetForm();                                                     
                } else {
                    JOptionPane.showMessageDialog(this, "Username atau Password salah!");
                    resetForm();
                }
            }

            result.close();
            stmt.close();
        } catch (HeadlessException | SQLException e) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_keluarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btn_keluarMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoginView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_login;
    private javax.swing.JPanel frame_kanan;
    private javax.swing.JPanel frame_kiri;
    private javax.swing.JLabel lb_gambar;
    private javax.swing.JLabel lb_masuk;
    private javax.swing.JLabel lb_pass;
    private javax.swing.JLabel lb_user;
    private javax.swing.JPasswordField t_pass;
    private javax.swing.JTextField t_user;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {
        t_user.setText("");
        t_pass.setText("");
    }

    private void resetPass(int id, String usernameValidasi, String email) {
        String emailPengirim = "thelegion.09.10.05@gmail.com";
        String passwordEmail = "vvibwtjnapezawgq";
        
        String emailPenerima = email;
        String userReset = usernameValidasi;
        String randomPass = randomPasswordGen();
        
        updatePass(id, userReset, randomPass);
        
        String subject = "Reset Password";
//        String bodyEmail = "Username = " + userReset + "\nPassword = " + randomPass;
        String bodyEmail = "<html><body>" +
                   "<div style=\"font-family: Arial, sans-serif; padding: 20px;\">" +
                   "<h2>Reset Password</h2>" +
                   "<p>Hai " + userReset + ",</p>" +
                   "<p>Anda telah meminta untuk mereset password Anda.</p>" +
                   "<p style=\"font-weight: bold; font-size: 18px;\">Password baru Anda adalah: " + randomPass + "</p>" +
                   "<p style=\"color: red;\"><b>PENTING:</b> Harap segera ganti password ini setelah login.</p>" +
                   "<p>Jika Anda tidak merasa melakukan permintaan ini, harap hubungi admin.</p>" +
                   "<p>Terima kasih,<br>APOTEK SEHATI</p>" +
                   "</div></body></html>";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(emailPengirim, passwordEmail);
            }
        });
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailPengirim));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailPenerima));
            message.setSubject(subject);
            message.setContent(bodyEmail, "text/html; charset=utf-8");
            
            Transport.send(message);
            
            JOptionPane.showMessageDialog(this, "Email Pemulihan Berhasil Dikirim");
        } catch (HeadlessException | MessagingException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
        }
    }

    private String randomPasswordGen() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }

    private void updatePass(int id, String userReset, String randomPass) {
        try {
            String sql = "UPDATE akses SET username = ?, password = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, userReset);
            stmt.setString(2, randomPass);
            stmt.setInt(3, id);
            
            int rowUpdate = stmt.executeUpdate();
            if (rowUpdate > 0) {
                System.out.println("updatePass Berhasil");
            }
            
            stmt.close();
        } catch (SQLException e) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void resetAdmin() {
        try {
            String sql = "DELETE FROM akses WHERE NOT (username = 'admin' OR access_key = 'user')";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                int rowUpdate = stmt.executeUpdate();
                if (rowUpdate > 0) {
                    System.out.println("resetAdmin Berhasil");
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void resetPassAdmin() {
        String emailPengirim = "thelegion.09.10.05@gmail.com";
        String passwordEmail = "vvibwtjnapezawgq";
        
        String emailPenerima = "thelegion.09.10.05@gmail.com";
        String userReset = "admin";
        String randomPass = "admin123";
        
        
        String subject = "Reset Password";
//        String bodyEmail = "Username = " + userReset + "\nPassword = " + randomPass;
        String bodyEmail = "<html><body>" +
                   "<div style=\"font-family: Arial, sans-serif; padding: 20px;\">" +
                   "<h2>Reset Password</h2>" +
                   "<p>Hai " + userReset + ",</p>" +
                   "<p>Anda telah meminta untuk mereset password Anda.</p>" +
                   "<p style=\"font-weight: bold; font-size: 18px;\">Password baru Anda adalah: " + randomPass + "</p>" +
                   "<p style=\"color: red;\"><b>PENTING:</b> Harap segera ganti password ini setelah login.</p>" +
                   "<p>Jika Anda tidak merasa melakukan permintaan ini, harap hubungi admin.</p>" +
                   "<p>Terima kasih,<br>APOTEK SEHATI</p>" +
                   "</div></body></html>";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(emailPengirim, passwordEmail);
            }
        });
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailPengirim));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailPenerima));
            message.setSubject(subject);
            message.setContent(bodyEmail, "text/html; charset=utf-8");
            
            Transport.send(message);
            
            JOptionPane.showMessageDialog(this, "Email Pemulihan Berhasil Dikirim");
        } catch (HeadlessException | MessagingException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
        }
    }
}
