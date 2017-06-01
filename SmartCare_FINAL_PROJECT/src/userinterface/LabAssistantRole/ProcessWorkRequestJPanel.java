/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.LabAssistantRole;

import Business.Validation.Validation;
import Business.WorkQueue.LabTestWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.io.File;
import java.util.Date;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author rajat
 */
public class ProcessWorkRequestJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    LabTestWorkRequest request;
    private userinterface.LabAssistantRole.ConfigUtility configUtil;

    /**
     * Creates new form ProcessWorkRequestJPanel
     */
    public ProcessWorkRequestJPanel(JPanel userProcessContainer, LabTestWorkRequest request) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        configUtil = new userinterface.LabAssistantRole.ConfigUtility();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submitJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultJTextField = new javax.swing.JTextArea();
        btnEmail = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        submitJButton.setBackground(new java.awt.Color(1, 126, 1));
        submitJButton.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        submitJButton.setText("Submit Result");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel1.setText("Results Generated");

        resultJTextField.setColumns(20);
        resultJTextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        resultJTextField.setRows(5);
        resultJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                resultJTextFieldFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(resultJTextField);

        btnEmail.setBackground(new java.awt.Color(1, 126, 1));
        btnEmail.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        btnEmail.setText("Send Email");
        btnEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/edu/UserInterface/back_button_black.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel14)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitJButton)
                    .addComponent(btnEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        if (!Validation.isEmpty(resultJTextField)) {
            JOptionPane.showMessageDialog(null, "Please enter test results generated.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Date date = new Date();
            request.setTestResult(resultJTextField.getText());
            request.setResolveDate(date);
            request.setStatus("Completed");
            JOptionPane.showMessageDialog(null, "Result Processed Succeefully");
            resultJTextField.setText("");
        }
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void btnEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailActionPerformed
        // TODO add your handling code here:
        File[] attachFiles = null;
        try {
            Properties smtpProperties = configUtil.loadProperties();
            userinterface.LabAssistantRole.EmailUtility.sendEmail(smtpProperties, "rajatddun@gmail.com", "Reports Created", "Request you please collect the reports.", attachFiles);

            JOptionPane.showMessageDialog(this,
                    "The e-mail has been sent successfully!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error while sending the e-mail: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnEmailActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        LabAssistantWorkAreaJPanel dwjp = (LabAssistantWorkAreaJPanel) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void resultJTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_resultJTextFieldFocusLost
        // TODO add your handling code here:
        Validation.isEmptyFieldOnFocusLostTextArea(evt);
    }//GEN-LAST:event_resultJTextFieldFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea resultJTextField;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
