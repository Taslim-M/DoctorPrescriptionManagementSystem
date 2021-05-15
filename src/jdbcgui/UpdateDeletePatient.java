/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcgui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Tasli
 */
public class UpdateDeletePatient extends javax.swing.JFrame {

    /**
     * Creates new form UpdateDeletePatient
     */
    myDBCon dbCon;

    ResultSet rs;

    public UpdateDeletePatient() {
        initComponents();
        this.setLocationRelativeTo(null);
        dbCon = new myDBCon();

        // set all error labels to invisible
        lblAgeErr.setVisible(false);
        lblBloodErr.setVisible(false);
        lblFnameErr.setVisible(false);
        lblHeightErr.setVisible(false);
        lblLnameErr.setVisible(false);
        lblWeightErr.setVisible(false);

        getNewData();
    }

    private void getNewData() {

        try {
            // populate deptno field
            rs = dbCon.executeStatement("SELECT eid,fname,lname,age,gender,weight,height,blood_type FROM dtw_patient");
            cmbGender.removeAllItems();
            cmbGender.addItem("M");
            cmbGender.addItem("F");

            // populate rest of fields
            rs.beforeFirst();
            rs.first();
            populateFields();
        } catch (SQLException e) {
            javax.swing.JLabel label = new javax.swing.JLabel("SQL Error - Display selected empno.");
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void populateFields() {
        try {
            txtEID.setText(rs.getString("eid"));
            txtFname.setText(rs.getString("fname"));
            txtLname.setText(rs.getString("lname"));
            txtAge.setText(rs.getString("age"));
            cmbGender.setSelectedItem(rs.getString("gender"));
            txtWeight.setText(rs.getString("weight"));
            txtHeight.setText(rs.getString("height"));
            txtBlood.setText(rs.getString("blood_type"));
            EnableDisableButtons();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void MoveNext() {
        try {
            // TODO add your handling code here:

            if (!rs.isLast()) {

                rs.next();
                populateFields();

            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void MovePrevious() {
        try {
            // TODO add your handling code here:

            if (!rs.isFirst()) {
                rs.previous();
                populateFields();

            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void EnableDisableButtons() {
        try {
            if (rs.isFirst()) {
                btnPrevious.setEnabled(false);
            } else {
                btnPrevious.setEnabled(true);
            }
            if (rs.isLast()) {
                btnNext.setEnabled(false);
            } else {
                btnNext.setEnabled(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteDoctor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

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

    void clearErrorLabels() {
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

    boolean isValidData() {
        clearErrorLabels();
        boolean result = true;
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbGender = new javax.swing.JComboBox<>();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtEID = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblFnameErr = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblLnameErr = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        lblAgeErr = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHeight = new javax.swing.JTextField();
        lblHeightErr = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        lblWeightErr = new javax.swing.JLabel();
        lblBloodErr = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBlood = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update/Delete Patient");

        cmbGender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtEID.setEditable(false);
        txtEID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEIDActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnNext.setText("Next >>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnPrevious.setText("<< Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Update/Delete Patient");

        lblFnameErr.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblFnameErr.setForeground(new java.awt.Color(255, 0, 0));
        lblFnameErr.setText("error label");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Emirates ID:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("First Name:");

        lblLnameErr.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblLnameErr.setForeground(new java.awt.Color(255, 0, 0));
        lblLnameErr.setText("error label");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Last Name:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Gender:");

        txtFname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtLname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLnameActionPerformed(evt);
            }
        });

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

        txtWeight.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWeightActionPerformed(evt);
            }
        });

        lblWeightErr.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblWeightErr.setForeground(new java.awt.Color(255, 0, 0));
        lblWeightErr.setText("error label");

        lblBloodErr.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblBloodErr.setForeground(new java.awt.Color(255, 0, 0));
        lblBloodErr.setText("error label");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Blood Type:");

        txtBlood.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtBlood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBloodActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtWeight)
                    .addComponent(txtEID)
                    .addComponent(txtFname, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtLname)
                    .addComponent(txtAge, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHeight, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeightErr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAgeErr, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblFnameErr, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(lblLnameErr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblWeightErr, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblBloodErr, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBlood, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(241, 241, 241))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(lblHeightErr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWeightErr)
                    .addComponent(jLabel8))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBlood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBloodErr))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:

        try {
            // make the result set scrolable forward/backward updatable
            //            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            if (isValidData()) {

                //Ask for confirmation
                int input_confirmation_update = JOptionPane.showConfirmDialog(null, "Confirm updating Patient?");
                if (input_confirmation_update == 0) {
                    if (txtHeight.getText().isEmpty()) {
                        txtHeight.setText("NULL");

                    }
                    if (txtWeight.getText().isEmpty()) {
                        txtWeight.setText("NULL");
                    }
                    String prepSQL = "UPDATE dtw_patient SET fname = "
                            + "'" + txtFname.getText() + "'"
                            + ", lname = '" + txtLname.getText() + "'"
                            + ", age =" + Integer.parseInt(txtAge.getText())
                            + ", gender ='" + cmbGender.getSelectedItem().toString() + "'"
                            + ", weight=" + txtWeight.getText().trim()
                            + ", height=" + txtHeight.getText().trim()
                            + ", blood_type ='" + txtBlood.getText().trim().toUpperCase() + "'"
                            + " WHERE eid =" + txtEID.getText().trim();

                    int result = dbCon.executePrepared(prepSQL);
                    if (result > 0) {

                        javax.swing.JLabel label = new javax.swing.JLabel("Patient EID:" + txtEID.getText() + " updated successfully.");
                        label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                        getNewData();

                    } else {
                        // check validation errors
                    }

                }

            } else {

                javax.swing.JLabel label = new javax.swing.JLabel("Please fix validation errors...");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error updating patient." + e.getMessage());

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:

        try {
            boolean visits_violate = false;
            ResultSet rs2 = dbCon.executeStatement("SELECT * FROM dtw_makevisit where PID=" + txtEID.getText().trim());
            if (rs2.next()) {
                visits_violate = true;
            }
            //If exists canot delete
            if (!visits_violate) {
                int input_confirmation_delete = JOptionPane.showConfirmDialog(null, "Confirm Delete Patient?");
                if (input_confirmation_delete == 0) {

                    String prepSQL = "DELETE dtw_patient WHERE EID=" + txtEID.getText().trim();

                    int result = dbCon.executePrepared(prepSQL);
                    if (result > 0) {
                        javax.swing.JLabel label = new javax.swing.JLabel("Patient EID:" + txtEID.getText().trim() + " deleted successfully.");
                        label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        getNewData();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cannot delete this patient since he has visits/prescription assinged.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting Patient.");

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtEIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEIDActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        MoveNext();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        MovePrevious();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void txtLnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLnameActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void txtHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHeightActionPerformed

    private void txtWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWeightActionPerformed

    private void txtBloodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBloodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBloodActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateDeletePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateDeletePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateDeletePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateDeletePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateDeletePatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnUpdate;
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
