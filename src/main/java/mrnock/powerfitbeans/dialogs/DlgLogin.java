package mrnock.powerfitbeans.dialogs;

import mrnock.powerfitbeans.MainForm;

/**
 * <p>
 * This DlgLogin class extends from JDialog and it is used to get users
 * credentials and login into the app. It is instantiated from the MainForm.</p>
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 6.0 Final version to submit for Unit 6 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class DlgLogin extends javax.swing.JDialog {

    MainForm mainForm = null;

    /**
     * <p>
     * Creates new form Login.</p>
     *
     * @param mainForm information from the MainForm screen.
     */
    public DlgLogin(MainForm mainForm) {

        super(mainForm, DlgLogin.ModalityType.DOCUMENT_MODAL);
        this.mainForm = mainForm;
        initComponents();
        imgEMail.setSvgImage(
                "images/email.svg", 25, 25);
        imgPassword.setSvgImage(
                "images/incognito.svg", 25, 25);
        setLocationRelativeTo(null);
    }

    /**
     * <p>
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.</p>
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblLoginTitle = new javax.swing.JLabel();
        pnlLoginBody = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        imgEMail = new mrnock.tools.SVGImage();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        imgPassword = new mrnock.tools.SVGImage();
        btnSubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 200));
        setPreferredSize(new java.awt.Dimension(400, 200));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblLoginTitle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblLoginTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoginTitle.setText("LOGIN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        getContentPane().add(lblLoginTitle, gridBagConstraints);

        pnlLoginBody.setLayout(new java.awt.GridBagLayout());

        lblEmail.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmail.setText("E-Mail:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlLoginBody.add(lblEmail, gridBagConstraints);

        txtEmail.setToolTipText("john.doe@email.com");
        txtEmail.setMinimumSize(new java.awt.Dimension(100, 22));
        txtEmail.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        pnlLoginBody.add(txtEmail, gridBagConstraints);

        imgEMail.setLabelFor(txtEmail);
        imgEMail.setToolTipText("john.doe@email.com");
        imgEMail.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        pnlLoginBody.add(imgEMail, gridBagConstraints);

        lblPassword.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPassword.setText("Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlLoginBody.add(lblPassword, gridBagConstraints);

        txtPassword.setToolTipText("Your secret password");
        txtPassword.setMinimumSize(new java.awt.Dimension(100, 22));
        txtPassword.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        pnlLoginBody.add(txtPassword, gridBagConstraints);

        imgPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgPassword.setLabelFor(txtPassword);
        imgPassword.setToolTipText("Input your super secret password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        pnlLoginBody.add(imgPassword, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(pnlLoginBody, gridBagConstraints);

        btnSubmit.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.setToolTipText("Validate your credentials");
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        getContentPane().add(btnSubmit, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * <p>
     * This method validates the user login, enabling him/her access into the
     * app.</p>
     */
    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        String email = txtEmail.getText();
        char[] password = txtPassword.getPassword();
        mainForm.validateUser(email, password);
    }//GEN-LAST:event_btnSubmitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private mrnock.tools.SVGImage imgEMail;
    private mrnock.tools.SVGImage imgPassword;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLoginTitle;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JPanel pnlLoginBody;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
