package mrnock.powerfitbeans.dialogs;

import mrnock.powerfitbeans.MainForm;

/**
 * This DlgLogin class extends from JDialog and it is used to get users
 * credentials and login into the app. It is instantiated from the MainForm.
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 2.0 Final version to submit for Unit 3 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class DlgLogin extends javax.swing.JDialog {

    MainForm mainForm = null;

    /**
     * Creates new form Login
     *
     * @param mainForm information from the MainForm screen.
     */
    public DlgLogin(MainForm mainForm) {

        super(mainForm, DlgLogin.ModalityType.DOCUMENT_MODAL);
        this.mainForm = mainForm;
        initComponents();
        setSize(432, 432);
        setLayout(null);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        lblPassword = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblLoginTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        pnlLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlLogin.setLayout(null);

        lblPassword.setText("Password:");
        pnlLogin.add(lblPassword);
        lblPassword.setBounds(110, 150, 80, 20);

        lblEmail.setText("E-Mail:");
        pnlLogin.add(lblEmail);
        lblEmail.setBounds(110, 120, 70, 20);

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        pnlLogin.add(btnSubmit);
        btnSubmit.setBounds(210, 200, 90, 30);

        txtEmail.setToolTipText("john.doe@email.com");
        pnlLogin.add(txtEmail);
        txtEmail.setBounds(190, 120, 130, 22);

        txtPassword.setToolTipText("Your secret password");
        pnlLogin.add(txtPassword);
        txtPassword.setBounds(190, 150, 130, 22);

        lblLoginTitle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblLoginTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoginTitle.setText("LOGIN");
        pnlLogin.add(lblLoginTitle);
        lblLoginTitle.setBounds(20, 20, 380, 50);

        getContentPane().add(pnlLogin);
        pnlLogin.setBounds(6, 6, 419, 374);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method validates the user login, enabling him/her access into the
     * app.
     */
    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        String email = txtEmail.getText();
        char[] password = txtPassword.getPassword();
        mainForm.validateUser(email, password);
    }//GEN-LAST:event_btnSubmitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLoginTitle;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
