/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ReceptionistRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.ReceptionistOrganization;
import Business.Organization.SpecialCareOrganization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ReceptionistTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Rajat
 */
public class ReceptionistPatientAppJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private ReceptionistOrganization organization;
    private EcoSystem business;
    private UserAccount userAccount;
    private Enterprise enterprise;
    public final String ACCOUNT_SID = "AC1fa19c67de6c5108275855f38d39370e";
    public final String AUTH_TOKEN = "9511e6b265d4a15df963743a91d1ad07";
    public final String APIVERSION = "2010-04-01";

    public ReceptionistPatientAppJPanel(JPanel userProcessContainer, UserAccount userAccount, ReceptionistOrganization organization, EcoSystem business, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        this.userAccount = userAccount;
        populateTable();

    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblAppointment.getModel();
        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof ReceptionistTestWorkRequest) {
                try {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
                    String DateToStr = format.format(new Date());
                    Date dt1 = format.parse(DateToStr);
                    if (!(request.getFinalAppointment() == null)) {
                        if (request.getFinalAppointment().after(dt1)) {
                            Object[] row = new Object[10];
                            row[0] = request;
                            row[1] = request.getPatientName();
                            row[2] = request.getDocName();
                            row[3] = request.getAppointmentDate();
                            row[4] = request.getAppointmentTime();
                            String result = request.getSpecialCarePerson();
                            row[5] = result == null ? "Pending Allocation" : result;
                            String result1 = ((ReceptionistTestWorkRequest) request).getAppStatus();
                            row[6] = result1 == null ? "Waiting Appointment" : result1;
                            model.addRow(row);
                        }
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(ReceptionistPatientAppJPanel.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
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

        refreshTestJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAppointment = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtPatientID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jLabel6 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEmpName = new javax.swing.JTextField();
        requestTestJButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        refreshTestJButton.setBackground(new java.awt.Color(1, 126, 1));
        refreshTestJButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });

        tblAppointment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PaitentID", "Patient Name", "Doctor Name", "AppointmentDate ", "Appointment Time", "CarePerson", "Status"
            }
        ));
        tblAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAppointmentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblAppointment);

        jButton1.setBackground(new java.awt.Color(1, 126, 1));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Send For Review");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("User Details"));
        jPanel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Name");

        txtName1.setEnabled(false);
        txtName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtName1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Patient ID");
        jLabel14.setToolTipText("");

        txtPatientID.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Date of Appointment");

        jXDatePicker2.setAutoscrolls(true);
        jXDatePicker2.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Time of Appointment");

        txtTime.setEnabled(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Remark ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Doctor Name");

        txtEmpName.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel14)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(129, 129, 129)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtEmpName, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jXDatePicker2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addComponent(txtName1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPatientID, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtTime)))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)))
        );

        requestTestJButton1.setBackground(new java.awt.Color(1, 126, 1));
        requestTestJButton1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        requestTestJButton1.setForeground(new java.awt.Color(255, 255, 255));
        requestTestJButton1.setText("Confirm Appointment");
        requestTestJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refreshTestJButton)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(requestTestJButton1)
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(refreshTestJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(requestTestJButton1)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void txtName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtName1ActionPerformed

    private void requestTestJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButton1ActionPerformed

        Patient par;
        int selectedRow = tblAppointment.getSelectedRow();
        ReceptionistTestWorkRequest request;
        if (selectedRow >= 0) {
           
            request = (ReceptionistTestWorkRequest) tblAppointment.getValueAt(selectedRow, 0);
             if(request.getStatus().equalsIgnoreCase("Complete")){
                 JOptionPane.showMessageDialog(null,"Selected Request is already completed.");
                 return;            
            }
            par = request.getSender().getPatient();
            request.setTestResult(jTextArea1.getText());
            String message = jTextArea1.getText();
            request.setMessage(message);
            request.setStatus("Complete");
            request.setAppStatus("Appointment Confirmed");
            Date obj = new Date();
            request.setResolveDate(obj);
            JOptionPane.showMessageDialog(null, "Appointment Scheduled");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a request message to process.");
            return;
        }

        Date date = new Date();
        String DocName = txtEmpName.getText();
        Date appointDate = jXDatePicker2.getDate();
        String appointTime = txtTime.getText();
        String pID = txtPatientID.getText();
        String pName = txtName1.getText();

        request.setPatient(par);
        request.setPatientID(pID);
        request.setPatientName(pName);
        request.setAppointmentDate(appointDate);
        request.setAppointmentTime(appointTime);
        request.setDocName(DocName.toString());
        request.setSender(userAccount);
        request.setRequestDate(date);
        request.setStatus("Complete");
        request.setAppStatus("Appointment Confirmed");
        AppointmentConfirmationMessage();

        Organization org = null;
        boolean t = true;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (t) {
                for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()) {
                    if (userAccount.getEmployee().getName().equals(DocName.toString())) {
                        this.userAccount.getWorkQueue().getWorkRequestList().add(request);
                        userAccount.getWorkQueue().getWorkRequestList().add(request);
                        t = false;
                        break;
                    }
                }
            }
        }

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof SpecialCareOrganization) {
                org = organization;
                break;
            }
        }
        if (org != null) {
            org.getWorkQueue().getWorkRequestList().add(request);
            for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                ua.getWorkQueue().getWorkRequestList().add(request);
            }
        }
        jTextArea1.setText("");

    }//GEN-LAST:event_requestTestJButton1ActionPerformed

    private void tblAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAppointmentMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblAppointment.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row first");
        } else {

            txtPatientID.setText((String) tblAppointment.getValueAt(selectedRow, 0).toString());
            txtName1.setText((String) tblAppointment.getValueAt(selectedRow, 1).toString());
            jXDatePicker2.setDate((Date) tblAppointment.getValueAt(selectedRow, 3));
            txtTime.setText((String) tblAppointment.getValueAt(selectedRow, 4).toString());
            txtEmpName.setText((String) tblAppointment.getValueAt(selectedRow, 2).toString());
        }


    }//GEN-LAST:event_tblAppointmentMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblAppointment.getSelectedRow();
        if (selectedRow >= 0) {
            ReceptionistTestWorkRequest request = (ReceptionistTestWorkRequest) tblAppointment.getValueAt(selectedRow, 0);
             if(request.getStatus().equalsIgnoreCase("Complete")){
                 JOptionPane.showMessageDialog(null,"Selected Request is already completed.");
                 return;            
            }
            request.setStatus("Complete");
            request.setTestResult(jTextArea1.getText());
            String message = jTextArea1.getText();
            request.setMessage(message);
            request.setAppStatus("Date/Time Unavailable.Please Review");
            Date obj = new Date();
            request.setResolveDate(obj);
            JOptionPane.showMessageDialog(null, "Request Send for Review");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a request message to process.");
            return;
        }
        jTextArea1.setText("");

    }//GEN-LAST:event_jButton1ActionPerformed

    public void AppointmentConfirmationMessage() {
        try {
            TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
            // Build a filter for the MessageList
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("Body", "Dear Patient, Your appointment is now confirmed"));
            params.add(new BasicNameValuePair("To", "+18578002942"));
            params.add(new BasicNameValuePair("From", "+16173963544"));
            MessageFactory messageFactory = client.getAccount().getMessageFactory();
            Message message = messageFactory.create(params);
            JOptionPane.showMessageDialog(null, "Message Sent Successfully");
            System.out.println(message.getSid());
        } catch (TwilioRestException e) {
            System.out.println("Exception Caught in Sending Message");
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton requestTestJButton1;
    private javax.swing.JTable tblAppointment;
    private javax.swing.JTextField txtEmpName;
    public javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtPatientID;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables
}