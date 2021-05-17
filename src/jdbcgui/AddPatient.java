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
public class AddPatient extends javax.swing.JFrame {

    /**
     * Creates new form AddPatient
     */
    myDBCon dbCon;

    ResultSet rs;

    public AddPatient() {
        initComponents();
        // center form in screen 
        this.setLocationRelativeTo(null);
        dbCon = new myDBCon();

        // set all error labels to invisible
        lblAgeErr.setVisible(false);
        lblBloodErr.setVisible(false);
        lblEID.setVisible(false);
        lblFnameErr.setVisible(false);
        lblHeightErr.setVisible(false);
        lblLnameErr.setVisible(false);
        lblWeightErr.setVisible(false);

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
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHeight = new javax.swing.JTextField();
        lblHeightErr = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEID = new javax.swing.JTextField();
        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        txtBlood = new javax.swing.JTextField();
        cmbGender = new javax.swing.JComboBox<>();
        btnAddNewDoc = new javax.swing.JButton();
        lblEID = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        lblWeightErr = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        lblAgeErr = new javax.swing.JLabel();
        lblLnameErr = new javax.swing.JLabel();
        lblFnameErr = new javax.swing.JLabel();
        lblBloodErr = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Patient");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Add New Patient");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Blood Type:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Gender:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Weight:");

        txtHeight.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtHeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHeightActionPerformed(evt);
            }
        });

        lblHeightErr.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblHeightErr.setForeground(new java.awt.Color(255, 0, 0));
        lblHeightErr.setText("error label");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Height:");

        txtEID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtFname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtLname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLnameActionPerformed(evt);
            }
        });

        txtBlood.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtBlood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBloodActionPerformed(evt);
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

        txtWeight.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWeightActionPerformed(evt);
            }
        });

        lblWeightErr.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblWeightErr.setForeground(new java.awt.Color(255, 0, 0));
        lblWeightErr.setText("error label");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Age:");

        txtAge.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });

        lblAgeErr.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblAgeErr.setForeground(new java.awt.Color(255, 0, 0));
        lblAgeErr.setText("error label");

        lblLnameErr.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblLnameErr.setForeground(new java.awt.Color(255, 0, 0));
        lblLnameErr.setText("error label");

        lblFnameErr.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblFnameErr.setForeground(new java.awt.Color(255, 0, 0));
        lblFnameErr.setText("error label");

        lblBloodErr.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblBloodErr.setForeground(new java.awt.Color(255, 0, 0));
        lblBloodErr.setText("error label");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Emirates ID:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("First Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Last Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel1)
                .addContainerGap(196, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEID)
                            .addComponent(txtFname)
                            .addComponent(txtLname)
                            .addComponent(txtAge)
                            .addComponent(txtHeight)
                            .addComponent(txtWeight)
                            .addComponent(txtBlood, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAddNewDoc)
                                    .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEID, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(lblHeightErr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblFnameErr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblLnameErr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAgeErr, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblWeightErr)
                            .addComponent(lblBloodErr, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(jLabel3)
                    .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFnameErr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLnameErr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAgeErr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHeightErr)
                    .addComponent(jLabel10))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWeightErr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBlood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(lblBloodErr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAddNewDoc)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHeightActionPerformed

    private void txtLnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLnameActionPerformed
    void clearInputBoxes() {

        txtEID.setText("");
        txtFname.setText("");
        txtLname.setText("");
        txtAge.setText("");
        txtHeight.setText("");
        txtWeight.setText("");
        txtBlood.setText("");
        cmbGender.setSelectedIndex(0);
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

        lblFnameErr.setText("");
        lblFnameErr.setVisible(false);

        lblLnameErr.setText("");
        lblLnameErr.setVisible(false);

        lblAgeErr.setVisible(false);
        lblAgeErr.setText("");

        lblBloodErr.setVisible(false);
        lblBloodErr.setText("");

        lblHeightErr.setVisible(false);
        lblHeightErr.setText("");

        lblWeightErr.setVisible(false);
        lblWeightErr.setText("");

    }
    
    private void txtBloodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBloodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBloodActionPerformed
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

        if (txtFname.getText().trim().isEmpty() || (txtFname.getText().trim().length() > 25)) {
            if (txtFname.getText().trim().isEmpty()) {
                lblFnameErr.setText("Invalid. Cannot be empty.");
            } else if ((txtFname.getText().trim().length() > 25)) {
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

        if ((txtAge.getText().trim().length() > 3 || !isInteger(txtAge.getText()))) {
            if (txtAge.getText().trim().length() > 3) {
                lblAgeErr.setText("Invalid. Must be < 3 chars.");
            } else {
                lblAgeErr.setText("Invalid. Must be Number.");
            }

            lblAgeErr.setVisible(true);
            result = false;
        }
        if (!isDouble(txtWeight.getText())) {
            //can be NULL
            if (!txtWeight.getText().trim().isEmpty()) {
                lblWeightErr.setText("Invalid. Must be Number.");
                lblWeightErr.setVisible(true);
                result = false;
            }

        }
        if (!isDouble(txtHeight.getText())) {
            if (!txtHeight.getText().trim().isEmpty()) {
                lblHeightErr.setText("Invalid. Must be Number.");
                lblHeightErr.setVisible(true);
                result = false;
            }

        }
        if ((txtBlood.getText().trim().length() > 2)) {
            lblBloodErr.setText("Invalid. Must be max 2 chars.");
            lblBloodErr.setVisible(true);
            result = false;
        }

        return result;
    }

    private void btnAddNewDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewDocActionPerformed
        // TODO add your handling code here:

        try {

            if (isValidData()) {
 
                if (txtHeight.getText().isEmpty()) {
                    txtHeight.setText("NULL");
                    
                }
                if (txtWeight.getText().isEmpty()) {
                    txtWeight.setText("NULL");
                }
                String prepSQL = "INSERT INTO dtw_patient (EID, fname, lname, age, gender, weight, height, blood_type) VALUES ("
                        + txtEID.getText()
                        + ",'" + txtFname.getText() + "'"
                        + ", '" + txtLname.getText() + "'"
                        + "," + Integer.parseInt(txtAge.getText())
                        + ", '" + cmbGender.getSelectedItem().toString() + "'"
                        + "," + (txtWeight.getText())
                        + "," + (txtHeight.getText())
                        + ", '" + txtBlood.getText().toUpperCase() + "')";

                int result = dbCon.executePrepared(prepSQL);
                if (result > 0) {

                    javax.swing.JLabel label = new javax.swing.JLabel("New Patient added successfully.");
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
            JOptionPane.showMessageDialog(null, "Error adding new employee. Please enter unique EID and the other data correctly.");
        }
    }//GEN-LAST:event_btnAddNewDocActionPerformed

    private void txtWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWeightActionPerformed

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
                new AddPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewDoc;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblAgeErr;
    private javax.swing.JLabel lblBloodErr;
    private javax.swing.JLabel lblEID;
    private javax.swing.JLabel lblFnameErr;
    private javax.swing.JLabel lblHeightErr;
    private javax.swing.JLabel lblLnameErr;
    private javax.swing.JLabel lblWeightErr;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtBlood;
    private javax.swing.JTextField txtEID;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables
}
