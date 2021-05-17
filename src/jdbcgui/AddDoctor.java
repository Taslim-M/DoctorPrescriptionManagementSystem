package jdbcgui;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author wissam
 */
public class AddDoctor extends javax.swing.JFrame {

    /**
     * Creates new form AddEmployee
     */
    myDBCon dbCon;

    ResultSet rs;

    public AddDoctor() {
        initComponents();
        // center form in screen 
        this.setLocationRelativeTo(null);
        dbCon = new myDBCon();

        // set all error labels to invisible
        lblEID.setVisible(false);
        lblFnameErr.setVisible(false);
        lblLnameErr.setVisible(false);

        lblSpErr.setVisible(false);

        //populate mgr and deptno combo boxes 
        cmbGender.removeAllItems();
        cmbGender.addItem("M");
        cmbGender.addItem("F");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEID = new javax.swing.JTextField();
        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        txtSp = new javax.swing.JTextField();
        cmbGender = new javax.swing.JComboBox<>();
        btnAddNewDoc = new javax.swing.JButton();
        lblEID = new javax.swing.JLabel();
        lblLnameErr = new javax.swing.JLabel();
        lblFnameErr = new javax.swing.JLabel();
        lblSpErr = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Employee");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Add New Doctor");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Emirates ID:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("First Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Last Name:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Specialization:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Gender:");

        txtEID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtFname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtLname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLnameActionPerformed(evt);
            }
        });

        txtSp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSpActionPerformed(evt);
            }
        });

        cmbGender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnAddNewDoc.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAddNewDoc.setText("Add New");
        btnAddNewDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewDocActionPerformed(evt);
            }
        });

        lblEID.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEID.setForeground(new java.awt.Color(255, 0, 0));
        lblEID.setText("error label");

        lblLnameErr.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblLnameErr.setForeground(new java.awt.Color(255, 0, 0));
        lblLnameErr.setText("error label");

        lblFnameErr.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblFnameErr.setForeground(new java.awt.Color(255, 0, 0));
        lblFnameErr.setText("error label");

        lblSpErr.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblSpErr.setForeground(new java.awt.Color(255, 0, 0));
        lblSpErr.setText("error label");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSp)
                            .addComponent(txtEID)
                            .addComponent(txtFname)
                            .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblFnameErr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblLnameErr, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblEID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSpErr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(btnAddNewDoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFnameErr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLnameErr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblSpErr)
                    .addComponent(txtSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(btnAddNewDoc)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLnameActionPerformed

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public boolean isDouble(String s) {
        if(s.length()==0){
            return true;
        }
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
        lblFnameErr.setText("");
        lblFnameErr.setVisible(false);
        lblLnameErr.setText("");
        lblLnameErr.setVisible(false);
        lblSpErr.setText("");
        lblSpErr.setVisible(false);
    }

    boolean isValidData() {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        clearErrorLabels();
        boolean result = true;
        if (txtEID.getText().trim().isEmpty() || !pattern.matcher(txtEID.getText()).matches() || txtEID.getText().length() != 15) {
            if (txtEID.getText().trim().isEmpty()) {
                lblEID.setText("Invalid. Cannot be empty.");
            } else if (!pattern.matcher(txtEID.getText()).matches()) {
                lblEID.setText("Invalid. Must be integer.");
            } else {
                lblEID.setText("Invalid. Must be 15 numbers.");
            }

            lblEID.setVisible(true);
            result = false;
        }

        if (txtFname.getText().trim().isEmpty() || (txtFname.getText().trim().length() > 25)) {
            if (txtFname.getText().trim().isEmpty()) {
                lblFnameErr.setText("Invalid. Cannot be empty.");
            } else if ((txtFname.getText().trim().length() > 10)) {
                lblFnameErr.setText("Invalid. Must be < 25 chars.");
            }

            lblFnameErr.setVisible(true);
            result = false;
        }

        if (txtLname.getText().trim().isEmpty() || (txtLname.getText().trim().length() > 25)) {
            if (txtLname.getText().trim().isEmpty()) {
                lblLnameErr.setText("Invalid. Cannot be empty.");
            } else if (txtLname.getText().trim().length() > 25) {
                lblLnameErr.setText("Invalid. Must be < 25 chars.");
            }
            lblLnameErr.setVisible(true);
            result = false;
        }

        if (txtSp.getText().trim().isEmpty() || (txtLname.getText().trim().length() > 25)) {
            if ((txtLname.getText().trim().length() > 25)) {
                lblSpErr.setText("Invalid. Must be < 25 chars.");
            } else {
                lblSpErr.setText("Invalid. Cannot be empty.");
            }

            lblSpErr.setVisible(true);
            result = false;
        }

        return result;
    }

    void clearInputBoxes() {
        txtEID.setText("");
        txtFname.setText("");
        txtLname.setText("");
        txtSp.setText("");
        cmbGender.setSelectedIndex(0);
    }

    private void btnAddNewDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewDocActionPerformed
        // TODO add your handling code here:

        try {

            if (isValidData()) {
                String prepSQL = "INSERT INTO dtw_doctor (EID, fname, lname, specialization, gender) VALUES ("
                        + txtEID.getText().trim()
                        + ",'" + txtFname.getText() + "'"
                        + ", '" + txtLname.getText() + "'"
                        + ", '" + txtSp.getText() + "'"
                        + ", '" + cmbGender.getSelectedItem().toString() + "')";

                int result = dbCon.executePrepared(prepSQL);
                if (result > 0) {

                    javax.swing.JLabel label = new javax.swing.JLabel("New Doctor added successfully.");
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
            JOptionPane.showMessageDialog(null, "Error adding new doctor. Please enter unique EID and the other data correctly.");
        }
    }//GEN-LAST:event_btnAddNewDocActionPerformed
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
            java.util.logging.Logger.getLogger(AddPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddDoctor().setVisible(true);
            }
        });
    }
    private void txtSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewDoc;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblEID;
    private javax.swing.JLabel lblFnameErr;
    private javax.swing.JLabel lblLnameErr;
    private javax.swing.JLabel lblSpErr;
    private javax.swing.JTextField txtEID;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtSp;
    // End of variables declaration//GEN-END:variables
}
