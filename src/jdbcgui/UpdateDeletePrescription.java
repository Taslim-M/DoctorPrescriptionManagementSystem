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
import javax.swing.JOptionPane;

/**
 *
 * @author Tasli
 */
public class UpdateDeletePrescription extends javax.swing.JFrame {

    /**
     * Creates new form UpdateDeletePrescription
     */
    myDBCon dbCon;

    ResultSet rs;

    public UpdateDeletePrescription(String visitID) {
        initComponents();
        this.setLocationRelativeTo(null);
        dbCon = new myDBCon();
        txtEID.setText(visitID);
        getNewData(visitID);
    }

    private void getNewData(String visitID) {

        try {
            String str;
            // populate deptno field
            String prepSQL = "select p.mid, name, age_restriction, manufacturer, dosage_per_day from dtw_medicine m inner join dtw_prescribe p on m.id = p.mid where p.vid=" + visitID;
            rs = dbCon.executeStatement(prepSQL);

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

            txtMID.setText(rs.getString("mid"));
            txtName.setText(rs.getString("name"));
            txtAge.setText(rs.getString("age_restriction"));
            txtManu.setText(rs.getString("manufacturer"));
            txtDosage.setText(rs.getString("dosage_per_day"));
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        txtMID = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtDosage = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtEID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnPrevious = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtManu = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View/Delete Prescription");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Dosage Per Day:");

        txtMID.setEditable(false);
        txtMID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtAge.setEditable(false);
        txtAge.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });

        txtDosage.setEditable(false);
        txtDosage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDosage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDosageActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("View/Delete Prescription");

        btnDelete.setBackground(new java.awt.Color(255, 102, 102));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnDelete.setText("Delete Prescription");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Visit ID:");

        txtEID.setEditable(false);
        txtEID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEIDActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Medicine ID:");

        btnNext.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnNext.setText("Next >>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Age Restriction:");

        btnPrevious.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnPrevious.setText("<< Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Manufacturer:");

        txtManu.setEditable(false);
        txtManu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtManu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManuActionPerformed(evt);
            }
        });

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Medicine Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnPrevious)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNext)
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtManu, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtEID)
                    .addComponent(txtMID)
                    .addComponent(txtAge, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtDosage, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtName))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtManu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDosage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:

        try {

            int input_confirmation_delete = JOptionPane.showConfirmDialog(null, "Confirm delete prescription?");
            if (input_confirmation_delete == 0) {

                String prepSQL = "DELETE dtw_prescribe WHERE VID='" + txtEID.getText().trim() + "' AND MID='" + txtMID.getText().trim() + "'";

                int result = dbCon.executePrepared(prepSQL);
                if (result > 0) {
                    javax.swing.JLabel label = new javax.swing.JLabel("Prescription deleted successfully.");
                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    ResultSet rs3 = dbCon.executeStatement("SELECT * FROM dtw_prescribe where VID=" + txtEID.getText().trim());
                    if (rs3.next()) {
                        getNewData(txtEID.getText());
                    } else {
                        this.dispose();
                    }

                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error del. presc.");

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

    private void txtDosageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDosageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDosageActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void txtManuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtManuActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtDosage;
    private javax.swing.JTextField txtEID;
    private javax.swing.JTextField txtMID;
    private javax.swing.JTextField txtManu;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
