/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.UserInterface;


import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import userinterface.SignUp.PatientSignUpJPanel;

/**
 *
 * @author Rajat
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    private EcoSystem ecoSystem;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    private static ServerSocket serverSocket = null;
    // The client socket.
    private static Socket clientSocket = null;

    // This chat server can accept up to maxClientsCount clients' connections.
    private static final int maxClientsCount = 10;
    private static final clientThread[] threads = new clientThread[maxClientsCount];

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
        setSize(970, 1039);
        ecoSystem = dB4OUtil.retrieveSystem();

        //CHAT
        Object[] selectioValues = {"Server", "Patient", "Doctor", "Nurse"};
        String initialSection = "Server";
        String IPServer = "localhost";//InetAddress.getLocalHost().toString();
        String[] arguments = new String[]{IPServer};

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        glossPainter1 = new org.jdesktop.swingx.painter.GlossPainter();
        jPanel3 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtLoginPassword = new javax.swing.JPasswordField();
        txtLoginName = new javax.swing.JTextField();
        btnlogout = new javax.swing.JButton();
        btnlogin = new javax.swing.JButton();
        btnsignIn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        userProcessContainer = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setFocusCycleRoot(false);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 30, true));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setFocusTraversalPolicyProvider(true);
        jPanel3.setPreferredSize(new java.awt.Dimension(960, 1050));

        jSplitPane1.setBackground(new java.awt.Color(255, 255, 255));
        jSplitPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jSplitPane1.setDividerLocation(220);
        jSplitPane1.setDividerSize(2);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtLoginPassword.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtLoginPassword.setText("Password");
        txtLoginPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLoginPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLoginPasswordFocusLost(evt);
            }
        });
        txtLoginPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginPasswordActionPerformed(evt);
            }
        });

        txtLoginName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtLoginName.setText("Login ID");
        txtLoginName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLoginNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLoginNameFocusLost(evt);
            }
        });

        btnlogout.setBackground(new java.awt.Color(1, 126, 1));
        btnlogout.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnlogout.setForeground(new java.awt.Color(255, 255, 255));
        btnlogout.setText("Logout");
        btnlogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlogoutMouseClicked(evt);
            }
        });
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });

        btnlogin.setBackground(new java.awt.Color(1, 126, 1));
        btnlogin.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnlogin.setForeground(new java.awt.Color(255, 255, 255));
        btnlogin.setText("Login");
        btnlogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnloginMouseClicked(evt);
            }
        });
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        btnsignIn.setBackground(new java.awt.Color(1, 126, 1));
        btnsignIn.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnsignIn.setForeground(new java.awt.Color(255, 255, 255));
        btnsignIn.setText("Sign Up");
        btnsignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsignInMouseClicked(evt);
            }
        });
        btnsignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsignInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnsignIn)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(btnsignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(txtLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/edu/UserInterface/mainpic.JPG"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jSplitPane1.setTopComponent(jPanel1);

        panel.setBackground(new java.awt.Color(255, 255, 255));

        jSplitPane2.setBorder(null);
        jSplitPane2.setDividerLocation(650);
        jSplitPane2.setDividerSize(-1);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane2.setFocusTraversalPolicyProvider(true);

        userProcessContainer.setBackground(new java.awt.Color(255, 255, 255));
        userProcessContainer.setPreferredSize(new java.awt.Dimension(900, 700));
        userProcessContainer.setLayout(new java.awt.CardLayout());
        jSplitPane2.setTopComponent(userProcessContainer);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setMinimumSize(new java.awt.Dimension(410, 40));
        jPanel5.setPreferredSize(new java.awt.Dimension(410, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/neu/edu/UserInterface/close.jpg"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(391, 391, 391)
                .addComponent(jLabel5)
                .addContainerGap(405, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5))
        );

        jSplitPane2.setRightComponent(jPanel5);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(panel);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1039, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed
        // TODO add your handling code here:
        btnlogout.setEnabled(false);
        txtLoginName.setEnabled(true);
        txtLoginPassword.setEnabled(true);
        btnlogin.setEnabled(true);
        btnsignIn.setEnabled(true);
         txtLoginName.setText("");
        txtLoginPassword.setText("");

        userProcessContainer.removeAll();
        JPanel jPanel3 = new JPanel();
        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        userProcessContainer.add("blank", jPanel3);
        CardLayout crdLyt = (CardLayout) userProcessContainer.getLayout();
        crdLyt.next(userProcessContainer);
        dB4OUtil.storeSystem(ecoSystem);
    }//GEN-LAST:event_btnlogoutActionPerformed

    private void btnlogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlogoutMouseClicked

    private void txtLoginNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginNameFocusLost
        // TODO add your handling code here:
         if (txtLoginName.getText().equalsIgnoreCase("Login ID")
                || txtLoginName.getText().trim().equalsIgnoreCase("")) {
            txtLoginName.setText("Login ID");
            txtLoginName.setForeground(Color.gray);
         }
    }//GEN-LAST:event_txtLoginNameFocusLost

    private void txtLoginNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginNameFocusGained
        // TODO add your handling code here:
        txtLoginName.setText("");
        txtLoginName.setForeground(Color.black);
    }//GEN-LAST:event_txtLoginNameFocusGained

    private void txtLoginPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginPasswordActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btnloginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnloginMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnloginMouseClicked

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        // TODO add your handling code here:
        String userName = txtLoginName.getText();
        // Get Password
        char[] passwordCharArray = txtLoginPassword.getPassword();
        String password = String.valueOf(passwordCharArray);

        Enterprise inEnterprise = null;
        Organization inOrganization = null;

        UserAccount userAccount = ecoSystem.getUserAccountDirectory().authenticateUser(userName, password);
        if (userAccount == null) {
            //Get each network from ecosystem
            for (Network network : ecoSystem.getNetworkList()) {
                //checking for each enterprise

                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {

                    userAccount = enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                    if (userAccount == null) {

                        //checking in the organization
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {

                            userAccount = organization.getUserAccountDirectory().authenticateUser(userName, password);

                            if (userAccount != null) {
                                inEnterprise = enterprise;
                                inOrganization = organization;
                                break;
                            }

                        }
                    } else {
                        inEnterprise = enterprise;
                        break;
                    }

                    if (inOrganization != null) {
                        break;
                    }

                }
                if (inEnterprise != null) {
                    break;
                }

            }

        }

        if (userAccount == null) {
            JOptionPane.showMessageDialog(null, "Invalid Credential");
            return;
        } else {
            CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add("WorkArea", userAccount.getRole().createWorkArea(userProcessContainer, userAccount, inOrganization, inEnterprise, ecoSystem));
            cardLayout.next(userProcessContainer);
        }

        btnlogin.setEnabled(false);
        btnlogout.setEnabled(true);
        txtLoginName.setEnabled(false);
        txtLoginPassword.setEnabled(false);
        btnsignIn.setEnabled(false);

    }//GEN-LAST:event_btnloginActionPerformed

    private void btnsignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsignInMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsignInMouseClicked

    private void btnsignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsignInActionPerformed
        // TODO add your handling code here:
        PatientSignUpJPanel patientSignUpJPanel = new PatientSignUpJPanel(userProcessContainer, ecoSystem);
        userProcessContainer.add("PatientSignUpJPanel", patientSignUpJPanel);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);

    }//GEN-LAST:event_btnsignInActionPerformed

    private void txtLoginPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginPasswordFocusGained
        // TODO add your handling code here:
        txtLoginPassword.setText("");
        txtLoginPassword.setForeground(Color.black);

    }//GEN-LAST:event_txtLoginPasswordFocusGained

    private void txtLoginPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginPasswordFocusLost
        // TODO add your handling code here:
        if (txtLoginPassword.getText().equalsIgnoreCase("Password")
                || txtLoginPassword.getText().trim().equalsIgnoreCase("")) {
            txtLoginPassword.setText("Password");
            txtLoginPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtLoginPasswordFocusLost

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btnsignIn;
    private org.jdesktop.swingx.painter.GlossPainter glossPainter1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtLoginName;
    private javax.swing.JPasswordField txtLoginPassword;
    private javax.swing.JPanel userProcessContainer;
    // End of variables declaration//GEN-END:variables
}
