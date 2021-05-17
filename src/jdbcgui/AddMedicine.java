/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcgui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Tasli
 */
public class AddMedicine extends javax.swing.JFrame {

    /**
     * Creates new form AddMedicine
     */
    myDBCon dbCon;

    ResultSet rs;

    public AddMedicine() {
        initComponents();

        this.setLocationRelativeTo(null);
        dbCon = new myDBCon();

        // set all error labels to invisible
        lblAgeErr.setVisible(false);
        lblEID.setVisible(false);
        lblManuErr.setVisible(false);
        lblNameErr.setVisible(false);

        cmbDosage.removeAllItems();
        for (int i = 1; i < 10; i++) {
            cmbDosage.addItem(String.valueOf(i));
        }

    }

    void clearInputBoxes() {

        txtEID.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtManu.setText("");
        cmbDosage.setSelectedIndex(0);
    }

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    void clearErrorLabels() {
        lblEID.setText("");
        lblEID.setVisible(false);

        lblManuErr.setText("");
        lblManuErr.setVisible(false);

        lblAgeErr.setVisible(false);
        lblAgeErr.setText("");

        lblNameErr.setVisible(false);
        lblNameErr.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtManu = new javax.swing.JTextField();
        lblManuErr = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmbDosage = new javax.swing.JComboBox<>();
        btnAddNewMed = new javax.swing.JButton();
        lblEID = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        lblAgeErr = new javax.swing.JLabel();
        lblNameErr = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Medicine");

        txtManu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtManu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManuActionPerformed(evt);
            }
        });

        lblManuErr.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblManuErr.setForeground(new java.awt.Color(255, 0, 0));
        lblManuErr.setText("error label");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Manufacturer:");

        txtEID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Add New Medicine");

        cmbDosage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnAddNewMed.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAddNewMed.setText("Add New");
        btnAddNewMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewMedActionPerformed(evt);
            }
        });

        lblEID.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEID.setForeground(new java.awt.Color(255, 0, 0));
        lblEID.setText("error label");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Age Restriction:");

        txtAge.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });

        lblAgeErr.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblAgeErr.setForeground(new java.awt.Color(255, 0, 0));
        lblAgeErr.setText("error label");

        lblNameErr.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblNameErr.setForeground(new java.awt.Color(255, 0, 0));
        lblNameErr.setText("error label");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Medicine ID:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Name:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Dosage Per Day:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddNewMed)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEID, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                    .addComponent(txtName)
                                    .addComponent(txtAge)
                                    .addComponent(txtManu)
                                    .addComponent(cmbDosage, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblManuErr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblNameErr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblAgeErr, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 21, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lblNameErr))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(lblAgeErr))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblManuErr)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtManu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbDosage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnAddNewMed)
                .addGap(0, 79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtManuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtManuActionPerformed
    boolean isValidData() {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        clearErrorLabels();
        boolean result = true;
        if (txtEID.getText().trim().isEmpty() || !pattern.matcher(txtEID.getText()).matches() || txtEID.getText().length() != 15) {
            if (txtEID.getText().trim().isEmpty()) {
                lblEID.setText("Invalid. Cannot be empty.");
            } else if (!pattern.matcher(txtEID.getText()).matches()) {
                lblEID.setText("Invalid. Must be NUMBERS only.");
            } else {
                lblEID.setText("Invalid. Must be 15 numbers.");
            }

            lblEID.setVisible(true);
            result = false;
        }

        if (txtName.getText().trim().isEmpty() || (txtName.getText().trim().length() > 50)) {
            if (txtName.getText().trim().isEmpty()) {
                lblNameErr.setText("Invalid. Cannot be empty.");
            } else if ((txtName.getText().trim().length() > 50)) {
                lblNameErr.setText("Invalid. Must be < 50 chars.");
            }
            lblNameErr.setVisible(true);
            result = false;
        }
        if ((txtAge.getText().trim().length() > 3 || !isInteger(txtAge.getText()))) {
            if (txtAge.getText().trim().length() > 3) {
                lblAgeErr.setText("Invalid. Must be 3 chars or less.");
            } else {
                lblAgeErr.setText("Invalid. Must be Number.");
            }

            lblAgeErr.setVisible(true);
            result = false;
        }
        if (txtManu.getText().trim().isEmpty() || (txtManu.getText().trim().length() > 30)) {
            if (txtManu.getText().trim().isEmpty()) {
                lblManuErr.setText("Invalid. Cannot be empty.");
            } else if (txtManu.getText().trim().length() > 30) {
                lblManuErr.setText("Invalid. Must be < 30 chars.");
            }
            lblManuErr.setVisible(true);
            result = false;
        }

        return result;
    }
    private void btnAddNewMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewMedActionPerformed
        // TODO add your handling code here:

        try {

            if (isValidData()) {

                String prepSQL = "INSERT INTO dtw_medicine (ID, name, age_restriction, manufacturer, dosage_per_day) VALUES ("
                        + txtEID.getText()
                        + ",'" + txtName.getText() + "'"
                        + "," + Integer.parseInt(txtAge.getText())
                        + ", '" + txtManu.getText() + "'"
                        + "," + cmbDosage.getSelectedItem().toString() + ")";

                int result = dbCon.executePrepared(prepSQL);
                if (result > 0) {

                    javax.swing.JLabel label = new javax.swing.JLabel("New Medicine added successfully.");
                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                    clearInputBoxes();
                } else {
                    // check validation errors
                }

            } else {

                javax.swing.JLabel label = new javax.swing.JLabel("Please fix validation errors...");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding new medicine. Please enter unique ID and the other data correctly.");
        }
    }//GEN-LAST:event_btnAddNewMedActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

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
            java.util.logging.Logger.getLogger(AddMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddMedicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewMed;
    private javax.swing.JComboBox<String> cmbDosage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblAgeErr;
    private javax.swing.JLabel lblEID;
    private javax.swing.JLabel lblManuErr;
    private javax.swing.JLabel lblNameErr;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtEID;
    private javax.swing.JTextField txtManu;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
