/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import koneksi_db.Koneksi;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FormMedis extends javax.swing.JFrame {

    private Connection conn;
//    Statement stmt;
    ResultSet rest;
    java.util.Date fabdate, expdate;
    java.sql.Date MyFabDate, MyExpDate;
    
    public FormMedis() {
        initComponents();
        conn = Koneksi.getConnect();
        tableCustom();
        getData();
    }
    
    public void tableCustom() {
        tbl_daftarObat.getTableHeader().setFont(new Font("Sans serif", Font.BOLD, 12));
        tbl_daftarObat.getTableHeader().setOpaque(false);
        tbl_daftarObat.getTableHeader().setBackground(new Color(31, 69, 41));
        tbl_daftarObat.getTableHeader().setForeground(new Color(255, 255, 255));
        tbl_daftarObat.setRowHeight(25); 
    }

    private void getData() {
        DefaultTableModel model = (DefaultTableModel) tbl_daftarObat.getModel();
        model.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM daftar_obat";
            PreparedStatement stmt = conn.prepareStatement(sql);
            rest = stmt.executeQuery();
            
            while (rest.next()) {                
                int id = rest.getInt("id");
                String name = rest.getString("name");
                int price = rest.getInt("price");
                int quantity = rest.getInt("quantity");
                String fabdate = rest.getString("fabdate");
                String expdate = rest.getString("expdate");
                String company = rest.getString("company");
                
                
                Object[] rowData = {id, name, price, quantity, fabdate, expdate, company};
                model.addRow(rowData);               
            }
        } catch (Exception e) {
            Logger.getLogger(FormMedis.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas = new javax.swing.JPanel();
        label_manageObat = new javax.swing.JLabel();
        label_idObat = new javax.swing.JLabel();
        label_companyObat = new javax.swing.JLabel();
        label_nameObat = new javax.swing.JLabel();
        label_priceObat = new javax.swing.JLabel();
        obat_id = new javax.swing.JTextField();
        obat_name = new javax.swing.JTextField();
        obat_price = new javax.swing.JTextField();
        label_quantityObat = new javax.swing.JLabel();
        label_fabdateObat = new javax.swing.JLabel();
        label_expdateObat = new javax.swing.JLabel();
        obat_quantity = new javax.swing.JTextField();
        obat_company = new javax.swing.JComboBox<>();
        obat_fabdate = new com.toedter.calendar.JDateChooser();
        obat_expdate = new com.toedter.calendar.JDateChooser();
        btnObat_add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_daftarObat = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        btnObat_cancel = new javax.swing.JButton();
        btnObat_delete = new javax.swing.JButton();
        btnObat_update = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        canvas.setBackground(new java.awt.Color(255, 255, 255));
        canvas.setForeground(new java.awt.Color(255, 255, 255));

        label_manageObat.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        label_manageObat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_manageObat.setText("MANAGE OBAT");

        label_idObat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_idObat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_idObat.setText("ID");

        label_companyObat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_companyObat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_companyObat.setText("COMPANY");

        label_nameObat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_nameObat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_nameObat.setText("NAME");

        label_priceObat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_priceObat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_priceObat.setText("PRICE");

        obat_id.setBackground(new java.awt.Color(204, 204, 204));
        obat_id.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        obat_id.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        obat_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obat_idActionPerformed(evt);
            }
        });

        obat_name.setBackground(new java.awt.Color(204, 204, 204));
        obat_name.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        obat_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        obat_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obat_nameActionPerformed(evt);
            }
        });

        obat_price.setBackground(new java.awt.Color(204, 204, 204));
        obat_price.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        obat_price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        obat_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obat_priceActionPerformed(evt);
            }
        });

        label_quantityObat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_quantityObat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_quantityObat.setText("QUANTITY");

        label_fabdateObat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_fabdateObat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_fabdateObat.setText("FABDATE");

        label_expdateObat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_expdateObat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_expdateObat.setText("EXPDATE");

        obat_quantity.setBackground(new java.awt.Color(204, 204, 204));
        obat_quantity.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        obat_quantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        obat_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obat_quantityActionPerformed(evt);
            }
        });

        obat_company.setBackground(new java.awt.Color(204, 204, 204));
        obat_company.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        obat_company.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dexa Medica", "Sanbe Farma", "Kimia Farma", "Phapros", "Kalbe Farma" }));

        obat_fabdate.setBackground(new java.awt.Color(204, 204, 204));
        obat_fabdate.setToolTipText("InputDate");
        obat_fabdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        obat_expdate.setBackground(new java.awt.Color(204, 204, 204));
        obat_expdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnObat_add.setBackground(new java.awt.Color(204, 204, 204));
        btnObat_add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnObat_add.setText("ADD");
        btnObat_add.setBorder(null);
        btnObat_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnObat_addMouseClicked(evt);
            }
        });
        btnObat_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObat_addActionPerformed(evt);
            }
        });

        tbl_daftarObat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbl_daftarObat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbl_daftarObat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "FabDate", "ExpDate", "Company"
            }
        ));
        tbl_daftarObat.setToolTipText("tbl_daftarObat");
        tbl_daftarObat.setRowHeight(25);
        tbl_daftarObat.setSelectionBackground(new java.awt.Color(158, 223, 156));
        tbl_daftarObat.getTableHeader().setReorderingAllowed(false);
        tbl_daftarObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_daftarObatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_daftarObat);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("DAFTAR OBAT");

        btnObat_cancel.setBackground(new java.awt.Color(204, 204, 204));
        btnObat_cancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnObat_cancel.setText("CANCEL");
        btnObat_cancel.setBorder(null);
        btnObat_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnObat_cancelMouseClicked(evt);
            }
        });
        btnObat_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObat_cancelActionPerformed(evt);
            }
        });

        btnObat_delete.setBackground(new java.awt.Color(204, 204, 204));
        btnObat_delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnObat_delete.setText("DELETE");
        btnObat_delete.setBorder(null);
        btnObat_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnObat_deleteMouseClicked(evt);
            }
        });
        btnObat_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObat_deleteActionPerformed(evt);
            }
        });

        btnObat_update.setBackground(new java.awt.Color(204, 204, 204));
        btnObat_update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnObat_update.setText("UPDATE");
        btnObat_update.setBorder(null);
        btnObat_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnObat_updateMouseClicked(evt);
            }
        });
        btnObat_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObat_updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout canvasLayout = new javax.swing.GroupLayout(canvas);
        canvas.setLayout(canvasLayout);
        canvasLayout.setHorizontalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(canvasLayout.createSequentialGroup()
                .addGroup(canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(canvasLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(canvasLayout.createSequentialGroup()
                                .addGroup(canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_nameObat, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_idObat, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_priceObat, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_quantityObat, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(obat_name, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(obat_id, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(obat_price, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(obat_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(73, 73, 73))
                            .addGroup(canvasLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnObat_add, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnObat_update, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGroup(canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, canvasLayout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addGroup(canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_expdateObat, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_fabdateObat, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_companyObat, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(obat_expdate, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(obat_company, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(obat_fabdate, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, canvasLayout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(btnObat_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95)
                                .addComponent(btnObat_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(canvasLayout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(label_manageObat, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(canvasLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(canvasLayout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        canvasLayout.setVerticalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(canvasLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(label_manageObat)
                .addGap(35, 35, 35)
                .addGroup(canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(obat_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_idObat, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(label_fabdateObat))
                    .addGroup(canvasLayout.createSequentialGroup()
                        .addComponent(obat_fabdate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(20, 20, 20)
                .addGroup(canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(canvasLayout.createSequentialGroup()
                        .addGroup(canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(canvasLayout.createSequentialGroup()
                                .addGroup(canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_nameObat)
                                    .addComponent(obat_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_priceObat)
                                    .addComponent(obat_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_companyObat)
                                    .addComponent(obat_company, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(label_expdateObat))
                        .addGap(19, 19, 19)
                        .addGroup(canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_quantityObat)
                            .addComponent(obat_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnObat_add, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnObat_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnObat_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnObat_update, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(obat_expdate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jLabel12)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(41, 54, 36));
        jPanel2.setForeground(new java.awt.Color(41, 54, 36));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PENJUALAN");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MANAGE OBAT");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("HOME");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(158, 158, 158)
                    .addComponent(jLabel5)
                    .addContainerGap(517, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(canvas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void obat_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obat_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_obat_idActionPerformed

    private void obat_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obat_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_obat_nameActionPerformed

    private void obat_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obat_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_obat_priceActionPerformed

    private void obat_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obat_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_obat_quantityActionPerformed

    private void btnObat_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObat_addMouseClicked
//        fabdate = obat_fabdate.getDate();
//        MyFabDate = new java.sql.Date(fabdate.getTime());
//        expdate = obat_expdate.getDate();
//        MyExpDate = new java.sql.Date(expdate.getTime());
        // Convert util.Date to java.sql.Date
        java.util.Date fabDate = obat_fabdate.getDate();
        java.sql.Date MyFabDate = new java.sql.Date(fabDate.getTime());
        java.util.Date expDate = obat_expdate.getDate();
        java.sql.Date MyExpDate = new java.sql.Date(expDate.getTime());
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy"); // Format tahun-bulan-hari
        String fabdateStr = sdf.format(fabDate);
        String expdateStr = sdf.format(expDate);
        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_management_apotek", "root", "");
            PreparedStatement add = conn.prepareStatement("INSERT INTO daftar_obat VALUES (?, ?, ?, ?, ?, ?, ?)");
            add.setInt(1, Integer.parseInt(obat_id.getText()));
            add.setString(2, obat_name.getText());
            add.setInt(3, Integer.parseInt(obat_price.getText()));
            add.setInt(4, Integer.parseInt(obat_quantity.getText()));
            add.setString(5, fabdateStr);
            add.setString(6, expdateStr);
            add.setString(7, obat_company.getSelectedItem().toString());
            
            int rowsAffected = add.executeUpdate(); 
           
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Obat Sukses Ditambahkan");
            }  
            
            add.close();
            resetForm();
            getData();
        } catch (Exception e) {
            Logger.getLogger(FormMedis.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnObat_addMouseClicked

    private void btnObat_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObat_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnObat_addActionPerformed

    private void btnObat_cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObat_cancelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnObat_cancelMouseClicked

    private void btnObat_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObat_cancelActionPerformed
        resetForm();
    }//GEN-LAST:event_btnObat_cancelActionPerformed

    private void btnObat_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObat_deleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnObat_deleteMouseClicked

    private void btnObat_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObat_deleteActionPerformed
        int selectedRow = tbl_daftarObat.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan dihapus");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String id = tbl_daftarObat.getValueAt(selectedRow, 0).toString();
            try {
                String sql = "DELETE FROM daftar_obat WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, id);
                
                int rowDelete = stmt.executeUpdate();
                if (rowDelete > 0) {
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
                }
                
                stmt.close();
            } catch (Exception e) {
                Logger.getLogger(FormMedis.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        resetForm();
        getData();
    }//GEN-LAST:event_btnObat_deleteActionPerformed

    private void btnObat_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObat_updateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnObat_updateMouseClicked

    private void btnObat_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObat_updateActionPerformed
        fabdate = obat_fabdate.getDate();
        MyFabDate = new java.sql.Date(fabdate.getTime());
        expdate = obat_expdate.getDate();
        MyExpDate = new java.sql.Date(expdate.getTime());
        
        int seletedRow = tbl_daftarObat.getSelectedRow();
        if (seletedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan diperbarui");
            return;
        }
        
        String id = tbl_daftarObat.getValueAt(seletedRow, 0).toString();
        String name = obat_name.getText();
        int price = Integer.valueOf(obat_price.getText());
        int quantity = Integer.valueOf(obat_quantity.getText());
        
        if (id.isEmpty() || name.isEmpty() || label_priceObat.getText().isEmpty() || label_quantityObat.getText().isEmpty() || MyFabDate.toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            fabdate = obat_fabdate.getDate();
            MyFabDate = new java.sql.Date(fabdate.getTime());
            expdate = obat_expdate.getDate();
            MyExpDate = new java.sql.Date(expdate.getTime());
        
            String sql = "UPDATE daftar_obat SET name = ?, price = ?, quantity = ?, fabdate = ?, expdate = ?, company = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, price);
            stmt.setInt(3, quantity);
            stmt.setDate(4, MyFabDate);
            stmt.setDate(5, MyExpDate);
            stmt.setString(6, obat_company.getSelectedItem().toString());
            stmt.setString(7, id);
            
            int rowUpdate = stmt.executeUpdate();
            if (rowUpdate > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil diperbarui");
                resetForm();
                getData();
            }
            
            stmt.close();
        } catch (Exception e) {
            Logger.getLogger(FormMedis.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnObat_updateActionPerformed

    private void tbl_daftarObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_daftarObatMouseClicked
        int selectedRow = tbl_daftarObat.getSelectedRow();
        if (selectedRow != -1) {
            String id = tbl_daftarObat.getValueAt(selectedRow, 0).toString();
            String name = tbl_daftarObat.getValueAt(selectedRow, 1).toString();
            String price = tbl_daftarObat.getValueAt(selectedRow, 2).toString();
            String quantity = tbl_daftarObat.getValueAt(selectedRow, 3).toString();
            String fabbdate = tbl_daftarObat.getValueAt(selectedRow, 4).toString();
            //            String expdate = tbl_daftarObat.getValueAt(selectedRow, 5).toString();

//            Date date = (Date) tbl_daftarObat.getValueAt(selectedRow, 5);
//            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM y");
//            String expdate = sdf.format(date);
            Date expDate = (Date) tbl_daftarObat.getValueAt(selectedRow, 5);
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM y");
            String formattedExpDate = sdf.format(expDate); 
            

            String company = tbl_daftarObat.getValueAt(selectedRow, 6).toString();
//            
//            Date fabdate = (Date) fabbdate;
//            Date expdate = sdf.parse(expdateStr);

            obat_id.setText(id);
            obat_name.setText(name);
            obat_price.setText(price);
            obat_quantity.setText(quantity);
            //            obat_fabdate.setDate(fabdate);
            //            obat_expdate.setDateFormatString(expdate);
            obat_company.setSelectedItem(company);
//            obat_fabdate.setDate(fabdate);
            obat_expdate.setDate(expDate);
        }
    }//GEN-LAST:event_tbl_daftarObatMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMedis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMedis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMedis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMedis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMedis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnObat_add;
    private javax.swing.JButton btnObat_cancel;
    private javax.swing.JButton btnObat_delete;
    private javax.swing.JButton btnObat_update;
    private javax.swing.JPanel canvas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_companyObat;
    private javax.swing.JLabel label_expdateObat;
    private javax.swing.JLabel label_fabdateObat;
    private javax.swing.JLabel label_idObat;
    private javax.swing.JLabel label_manageObat;
    private javax.swing.JLabel label_nameObat;
    private javax.swing.JLabel label_priceObat;
    private javax.swing.JLabel label_quantityObat;
    private javax.swing.JComboBox<String> obat_company;
    private com.toedter.calendar.JDateChooser obat_expdate;
    private com.toedter.calendar.JDateChooser obat_fabdate;
    private javax.swing.JTextField obat_id;
    private javax.swing.JTextField obat_name;
    private javax.swing.JTextField obat_price;
    private javax.swing.JTextField obat_quantity;
    private javax.swing.JTable tbl_daftarObat;
    // End of variables declaration//GEN-END:variables

    private void resetForm() {
        obat_id.setText("");
        obat_name.setText("");
        obat_price.setText("");
        obat_quantity.setText("");
        obat_fabdate.setDate(null);
        obat_expdate.setDate(null);
        obat_company.setSelectedItem(null);
    }

}
