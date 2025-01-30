
public class RekapTest extends javax.swing.JFrame {

    
    public RekapTest(String username) {
        initComponents();
    }

    // METHOD
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_bar = new javax.swing.JPanel();
        side_obat = new javax.swing.JLabel();
        side_beranda = new javax.swing.JLabel();
        side_penjualan = new javax.swing.JLabel();
        side_admin = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        text_bar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 750));

        side_bar.setBackground(new java.awt.Color(41, 54, 36));
        side_bar.setMaximumSize(new java.awt.Dimension(200, 750));
        side_bar.setMinimumSize(new java.awt.Dimension(200, 750));
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

        side_admin.setBackground(new java.awt.Color(178, 201, 173));
        side_admin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        side_admin.setForeground(new java.awt.Color(255, 255, 255));
        side_admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        side_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/admin2.png"))); // NOI18N
        side_admin.setText("ADMIN");
        side_admin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        side_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                side_adminMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout side_barLayout = new javax.swing.GroupLayout(side_bar);
        side_bar.setLayout(side_barLayout);
        side_barLayout.setHorizontalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_barLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(side_admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(side_penjualan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(side_obat, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(side_beranda, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        side_barLayout.setVerticalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_barLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(side_beranda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(side_obat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(side_penjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 441, Short.MAX_VALUE)
                .addComponent(side_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setMaximumSize(new java.awt.Dimension(800, 750));
        main.setMinimumSize(new java.awt.Dimension(800, 750));
        main.setPreferredSize(new java.awt.Dimension(800, 750));

        text_bar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        text_bar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                .addContainerGap(211, Short.MAX_VALUE)
                .addComponent(text_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(694, Short.MAX_VALUE))
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

    private void side_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_side_adminMouseClicked
        //lbl_admin.setForeground(new Color(211, 211, 211));
    }//GEN-LAST:event_side_adminMouseClicked

    private void side_berandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_side_berandaMouseClicked

    }//GEN-LAST:event_side_berandaMouseClicked

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
    private javax.swing.JPanel main;
    private javax.swing.JLabel side_admin;
    private javax.swing.JPanel side_bar;
    private javax.swing.JLabel side_beranda;
    private javax.swing.JLabel side_obat;
    private javax.swing.JLabel side_penjualan;
    private javax.swing.JLabel text_bar;
    // End of variables declaration//GEN-END:variables


}
