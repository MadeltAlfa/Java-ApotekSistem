
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import koneksi_db.Koneksi;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author User
 */
public class AdminTest extends javax.swing.JFrame {
    private Connection conn;
    ResultSet rest;
    private static String username;
    private static String nama;
    private static int id;
    
    public AdminTest(String username) {
        initComponents();
        this.username = username;
        conn = Koneksi.getConnect();
        lbl_admin.setOpaque(true);
        lbl_admin.setBackground(new Color(75, 89, 69));
        text_bar.setText("SELAMAT DATANG KEMBALI, " + username.toUpperCase());
//        text_bar.setHorizontalAlignment(SwingConstants.CENTER);
//        text_bar.setText("<html>Selamat Datang,<br>ADMIN</html>");
        tableCustom();
        getData();
    }

    public void getData() {
        DefaultTableModel model = (DefaultTableModel) tbl_user.getModel();
        model.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM akses WHERE access_key = 'user'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            rest = stmt.executeQuery();
            
            while (rest.next()) {                
                int id = rest.getInt("id");
                String username = rest.getString("username");
                String password = rest.getString("password");
                String aksses_key = rest.getString("access_key");
                String fullname = rest.getString("fullname");
                
                
                Object[] rowData = {id, username, password, aksses_key, fullname};
                model.addRow(rowData);               
            }
        } catch (Exception e) {
            Logger.getLogger(AdminTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void tableCustom() {
        tbl_user.getTableHeader().setFont(new Font("Sans serif", Font.BOLD, 12));
        tbl_user.getTableHeader().setOpaque(true);
        tbl_user.getTableHeader().setBackground(new Color(31, 69, 41));
        tbl_user.getTableHeader().setForeground(new Color(255, 255, 255));
        tbl_user.setRowHeight(25); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_bar = new javax.swing.JPanel();
        side_obat = new javax.swing.JLabel();
        side_beranda = new javax.swing.JLabel();
        side_penjualan = new javax.swing.JLabel();
        lbl_admin = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        text_bar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lb_username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lb_password = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lb_firstname = new javax.swing.JTextField();
        lb_gambar = new javax.swing.JLabel();
        btn_pilih = new javax.swing.JButton();
        lb_path = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        lb_akses = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_user = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        lb_email = new javax.swing.JTextField();
        btn_perbarui = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        lbl_admin.setBackground(new java.awt.Color(178, 201, 173));
        lbl_admin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_admin.setForeground(new java.awt.Color(255, 255, 255));
        lbl_admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/admin2.png"))); // NOI18N
        lbl_admin.setText("ADMIN");
        lbl_admin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_adminMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout side_barLayout = new javax.swing.GroupLayout(side_bar);
        side_bar.setLayout(side_barLayout);
        side_barLayout.setHorizontalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_barLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_admin, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(side_beranda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(side_obat, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(side_penjualan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 448, Short.MAX_VALUE)
                .addComponent(lbl_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setPreferredSize(new java.awt.Dimension(800, 750));

        text_bar.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        text_bar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Username");

        lb_username.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Password");

        lb_password.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Akses key");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Fullname");

        lb_firstname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lb_gambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_gambar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_pilih.setText("Pilih File");
        btn_pilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pilihActionPerformed(evt);
            }
        });

        lb_path.setEditable(false);
        lb_path.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lb_path.setMaximumSize(new java.awt.Dimension(119, 25));
        lb_path.setMinimumSize(new java.awt.Dimension(119, 25));
        lb_path.setPreferredSize(new java.awt.Dimension(119, 25));

        btn_tambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        lb_akses.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lb_akses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));
        lb_akses.setSelectedIndex(1);

        tbl_user.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbl_user.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbl_user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Username", "Password", "Accses Key", "Fullname", "Email"
            }
        ));
        tbl_user.setToolTipText("tbl_daftarObat");
        tbl_user.setRowHeight(25);
        tbl_user.setSelectionBackground(new java.awt.Color(158, 223, 156));
        tbl_user.getTableHeader().setReorderingAllowed(false);
        tbl_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_userMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_user);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Email");

        lb_email.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lb_email.setMaximumSize(new java.awt.Dimension(100, 25));

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
        btn_hapus.setText("hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(text_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_perbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainLayout.createSequentialGroup()
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lb_password, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(lb_username, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainLayout.createSequentialGroup()
                                        .addGap(18, 313, Short.MAX_VALUE)
                                        .addComponent(lb_path, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_pilih, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainLayout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lb_akses, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lb_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(mainLayout.createSequentialGroup()
                                .addComponent(lb_email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(59, 59, 59))))
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
                            .addComponent(lb_username, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_akses, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_password, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lb_email, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lb_gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_path, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pilih, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_perbarui, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
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
        //lbl_admin.setForeground(new Color(211, 211, 211));
    }//GEN-LAST:event_lbl_adminMouseClicked

    private void btn_pilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pilihActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lb_path.setText(path);
            
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
        } catch (Exception e) {
        }
        }
    }//GEN-LAST:event_btn_pilihActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        PreparedStatement stmt = null;
        String username = lb_username.getText();
        String pass = lb_password.getText();
        String akses = lb_akses.getSelectedItem().toString();
        String fullname = lb_firstname.getText();
        String email = lb_email.getText();
        
        if(username.isEmpty() || pass.isEmpty() || akses.isEmpty() || fullname.isEmpty()){
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!");
            return;
        }
        
        try {
            String sql = "INSERT INTO akses (username, password, access_key, fullname, gambar, email) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, pass);
            stmt.setString(3, akses);
            stmt.setString(4, fullname);
//            stmt.setString(5, lb_path.getText());

            String imagePath = lb_path.getText();
            if (imagePath != null) {
                File imageFile = new File(imagePath);
                FileInputStream fis = new FileInputStream(imageFile);
                byte[] imageData = new byte[(int) imageFile.length()];
                fis.read(imageData);
                fis.close();
                stmt.setBytes(5, imageData);
            } else {
                stmt.setNull(5, java.sql.Types.BLOB);
            }
            stmt.setString(6, email);
            
            stmt.executeUpdate();
            stmt.close();
            JOptionPane.showMessageDialog(this, "Berhasil ditambahkan");
            resetForm();
        } catch (Exception e) {
            Logger.getLogger(AdminTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void side_berandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_side_berandaMouseClicked
        BerandaTest beranda = new BerandaTest(username);
        beranda.setVisible(true);
        dispose();
    }//GEN-LAST:event_side_berandaMouseClicked

    private void tbl_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_userMouseClicked
        int selectedRow = tbl_user.getSelectedRow();
        if (selectedRow != -1) {
            String id = tbl_user.getValueAt(selectedRow, 0).toString();
            String username = tbl_user.getValueAt(selectedRow, 1).toString();
            String password = tbl_user.getValueAt(selectedRow, 2).toString();
            String akses_key = tbl_user.getValueAt(selectedRow, 3).toString();
            String fullname = tbl_user.getValueAt(selectedRow, 4).toString();
            

            lb_username.setText(username);
            lb_password.setText(password);
            lb_akses.setSelectedItem(akses_key);
            lb_firstname.setText(fullname);
        }
    }//GEN-LAST:event_tbl_userMouseClicked

    private void btn_perbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perbaruiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_perbaruiActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hapusActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> lb_akses;
    private javax.swing.JTextField lb_email;
    private javax.swing.JTextField lb_firstname;
    private javax.swing.JLabel lb_gambar;
    private javax.swing.JTextField lb_password;
    private javax.swing.JTextField lb_path;
    private javax.swing.JTextField lb_username;
    private javax.swing.JLabel lbl_admin;
    private javax.swing.JPanel main;
    private javax.swing.JPanel side_bar;
    private javax.swing.JLabel side_beranda;
    private javax.swing.JLabel side_obat;
    private javax.swing.JLabel side_penjualan;
    private javax.swing.JTable tbl_user;
    private javax.swing.JLabel text_bar;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {
        lb_username.setText("");
        lb_password.setText("");
        lb_akses.setSelectedItem(null);
        lb_firstname.setText("");
        lb_path.setText("");
    }
}
