/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcgui;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tasli
 */
public class AddLoginUser extends javax.swing.JFrame {

    myDBCon dbCon;

    ResultSet rs;

    /**
     * Creates new form AddLoginUser
     */
    public AddLoginUser() {
        initComponents();
        this.setLocationRelativeTo(null);
        dbCon = new myDBCon();
        clearErrorLabels();
        cmbUsertype.removeAllItems();
        cmbUsertype.addItem("0");
        cmbUsertype.addItem("1");
        //populate mgr and deptno combo boxes 

    }

    boolean isValidData() {
        clearErrorLabels();
        boolean result = true;
        if (username.getText().trim().isEmpty() || (username.getText().trim().length() > 25 || username.getText().trim().length() < 4)) {
            if (username.getText().trim().isEmpty()) {
                lblUsernameErr.setText("Invalid username Cannot be empty.");
            } else if (username.getText().trim().length() > 25 || username.getText().trim().length() < 8) {
                lblUsernameErr.setText("Invalid. Must be between 4 and 25 chars");
            }
            lblUsernameErr.setVisible(true);
            result = false;
        }

        if (name.getText().trim().isEmpty() || (name.getText().trim().length() > 25 || name.getText().trim().length() < 4)) {
            if (name.getText().trim().isEmpty()) {
                lblNameErr.setText("Invalid name Cannot be empty.");
            } else if ((name.getText().trim().length() > 25 || name.getText().trim().length() < 8)) {
                lblNameErr.setText("Invalid. Must be between 4 and 25 chars");
            }
            lblNameErr.setVisible(true);
            result = false;
        }

        if (!isValidPassword()) {
            result = false;
        }

        return result;
    }

    boolean isValidPassword() {
        boolean result = true;

        if (password.getText().trim().isEmpty() || (password.getText().trim().length() > 25 || password.getText().trim().length() < 4)) {
            if (password.getText().trim().isEmpty()) {
                lblPwdErr.setText("Invalid password Cannot be empty.");
            } else if (password.getText().trim().length() > 25 || password.getText().trim().length() < 8) {
                lblPwdErr.setText("Invalid.  Must be between 4 and 25 chars");
            }
            lblPwdErr.setVisible(true);
            result = false;
        }

        // if no issue with main - check if they match 
        if (result == true) {
            if (!password.getText().equals(confirmpassword.getText())) {
                lblPwdErr.setText("Passwords do not match.");
                lblPwdErr.setVisible(true);
                result = false;
            }
        }
        return result;
    }

    void clearErrorLabels() {

        lblNameErr.setText("");
        lblNameErr.setVisible(false);
        lblPwdErr.setText("");
        lblPwdErr.setVisible(false);
        lblUsernameErr.setText("");
        lblUsernameErr.setVisible(false);

    }

    void clearInputBoxes() {
        name.setText("");
        username.setText("");
        password.setText("");
        confirmpassword.setText("");
        cmbUsertype.setSelectedIndex(0);
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
        jLabel5 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        cmbUsertype = new javax.swing.JComboBox<>();
        btnAddNewUser = new javax.swing.JButton();
        lblPwdErr = new javax.swing.JLabel();
        lblUsernameErr = new javax.swing.JLabel();
        lblNameErr = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        showPwd = new javax.swing.JCheckBox();
        confirmpassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Add Login User");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("USERNAME:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("PASSWORD:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("User Type:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Name:");

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        cmbUsertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbUsertype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUsertypeActionPerformed(evt);
            }
        });

        btnAddNewUser.setBackground(new java.awt.Color(51, 255, 51));
        btnAddNewUser.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAddNewUser.setText("Add New");
        btnAddNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewUserActionPerformed(evt);
            }
        });

        lblPwdErr.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblPwdErr.setForeground(new java.awt.Color(255, 0, 0));
        lblPwdErr.setText("error label");

        lblUsernameErr.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblUsernameErr.setForeground(new java.awt.Color(255, 0, 0));
        lblUsernameErr.setText("error label");

        lblNameErr.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblNameErr.setForeground(new java.awt.Color(255, 0, 0));
        lblNameErr.setText("error label");

        jLabel6.setText("0 = Admin | 1 = Normal");

        showPwd.setText("Show Password");
        showPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPwdActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Confirm Password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addComponent(btnAddNewUser)))
                        .addGap(0, 307, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(116, 116, 116)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel7)))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(password)
                                        .addComponent(showPwd)
                                        .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUsernameErr, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                    .addComponent(lblPwdErr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNameErr, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(confirmpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbUsertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsernameErr))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPwdErr)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(confirmpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showPwd)
                        .addGap(40, 40, 40)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(lblNameErr))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbUsertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(38, 38, 38)
                .addComponent(btnAddNewUser)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void cmbUsertypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUsertypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUsertypeActionPerformed

    private void btnAddNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewUserActionPerformed
        // TODO add your handling code here:

        try {
            // make the result set scrolable forward/backward updatable
            if (isValidData()) {
                rs = dbCon.executeStatement("SELECT * FROM dtw_loginusers WHERE LOWER(username) = LOWER('" + username.getText().trim() + "')");
                if (rs.next()) {
                    javax.swing.JLabel label = new javax.swing.JLabel("USERNAME ALREADY EXISTS!");
                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
                    lblUsernameErr.setText("Username already exists");
                    lblUsernameErr.setVisible(true);
                    return;
                }
                //If odes not exist a duplicate uname
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] sign = md.digest(password.getText().trim().getBytes());
                String pwdHash = String.format("%032X", new BigInteger(1, sign));
                pwdHash = pwdHash.substring(0, Math.min(pwdHash.length(), 25));
                String prepSQL = "INSERT INTO dtw_loginusers (username, password, name, type) VALUES ("
                        + "'" + username.getText().trim() + "'"
                        + ", '" + pwdHash + "'"
                        + ", '" + name.getText().trim() + "'"
                        + ", " + Integer.parseInt(cmbUsertype.getSelectedItem().toString()) + ")";

                int result = dbCon.executePrepared(prepSQL);
                if (result > 0) {

                    javax.swing.JLabel label = new javax.swing.JLabel("New login user added successfully.");
                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                    clearInputBoxes();
                } else {
                    // check validation errors
                }

                rs.close();
            } else {

                javax.swing.JLabel label = new javax.swing.JLabel("Please fix validation errors...");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding new employee." + e.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AddLoginUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddNewUserActionPerformed

    private void showPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPwdActionPerformed
        // TODO add your handling code here:
        if (showPwd.isSelected()) {
            password.setEchoChar((char) 0); //password = JPasswordField
            confirmpassword.setEchoChar((char) 0);
        } else {
            password.setEchoChar('*');
            confirmpassword.setEchoChar('*');
        }
    }//GEN-LAST:event_showPwdActionPerformed

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
            java.util.logging.Logger.getLogger(AddLoginUser.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddLoginUser.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddLoginUser.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddLoginUser.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddLoginUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewUser;
    private javax.swing.JComboBox<String> cmbUsertype;
    private javax.swing.JPasswordField confirmpassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblNameErr;
    private javax.swing.JLabel lblPwdErr;
    private javax.swing.JLabel lblUsernameErr;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField password;
    private javax.swing.JCheckBox showPwd;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
