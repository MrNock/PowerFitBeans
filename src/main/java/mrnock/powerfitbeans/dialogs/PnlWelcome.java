package mrnock.powerfitbeans.dialogs;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Cursor;
import javax.swing.UnsupportedLookAndFeelException;
import mrnock.powerfitbeans.MainForm;

/**
 * <p>
 * This PnlWelcome class extends from JPanel and it is used to welcome the users
 * with a welcome message and a link to the Power Fit Beans website.</p>
 *
 * <p>
 * By clicking the icon, the user will be prompted with the Login form to access
 * the app after validation.</p>
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 6.0 Final version to submit for Unit 6 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class PnlWelcome extends javax.swing.JPanel {

    /**
     * <p>
     * Creates new form PnlWelcome.</p>
     *
     * @param mainForm information from the MainForm screen.
     */
    public PnlWelcome(MainForm mainForm) {

        this.mainForm = mainForm;
        initComponents();
        imgWelcome.setSvgImage("images/PowerFitBeansLogo.svg", 450, 450);
        icnLogin.setSvgImage("images/login-2.svg", 45, 45);
        icnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
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

        pnlLeft = new javax.swing.JPanel();
        imgWelcome = new mrnock.tools.SVGImage();
        pnlLeftFooter = new javax.swing.JPanel();
        lblMoreInfo = new javax.swing.JLabel();
        lblUrlWeb = new javax.swing.JLabel();
        pnlRight = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        pnlLoginWelcome = new javax.swing.JPanel();
        lblAccessLogin = new javax.swing.JLabel();
        icnLogin = new mrnock.tools.SVGImage();
        pnlLoginFooter = new javax.swing.JPanel();
        tglDarkLight = new javax.swing.JToggleButton();

        setLayout(new java.awt.GridBagLayout());

        pnlLeft.setLayout(new java.awt.GridBagLayout());

        imgWelcome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        imgWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgWelcome.setAlignmentX(0.5F);
        imgWelcome.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlLeft.add(imgWelcome, gridBagConstraints);

        lblMoreInfo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMoreInfo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblMoreInfo.setText("More info: ");
        lblMoreInfo.setToolTipText("");
        lblMoreInfo.setAlignmentX(0.5F);
        lblMoreInfo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        pnlLeftFooter.add(lblMoreInfo);

        lblUrlWeb.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblUrlWeb.setForeground(new java.awt.Color(0, 0, 255));
        lblUrlWeb.setText("www.powerfitbeans.com");
        lblUrlWeb.setToolTipText("https://paucasesnovescifp.cat/");
        lblUrlWeb.setAlignmentX(0.5F);
        lblUrlWeb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUrlWeb.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        pnlLeftFooter.add(lblUrlWeb);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlLeft.add(pnlLeftFooter, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        add(pnlLeft, gridBagConstraints);

        pnlRight.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlRight.setLayout(new java.awt.BorderLayout());

        lblWelcome.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Welcome to the Power Fit Beans App");
        lblWelcome.setAlignmentX(0.5F);
        pnlRight.add(lblWelcome, java.awt.BorderLayout.NORTH);

        pnlLoginWelcome.setLayout(new java.awt.GridBagLayout());

        lblAccessLogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAccessLogin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAccessLogin.setText("Click to login:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlLoginWelcome.add(lblAccessLogin, gridBagConstraints);

        icnLogin.setToolTipText("Click to access the Power Fit Beans App");
        icnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                icnLoginMouseReleased(evt);
            }
        });
        pnlLoginWelcome.add(icnLogin, new java.awt.GridBagConstraints());

        pnlRight.add(pnlLoginWelcome, java.awt.BorderLayout.CENTER);

        tglDarkLight.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tglDarkLight.setText("Dark Mode");
        tglDarkLight.setToolTipText("");
        tglDarkLight.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tglDarkLight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglDarkLightActionPerformed(evt);
            }
        });
        pnlLoginFooter.add(tglDarkLight);

        pnlRight.add(pnlLoginFooter, java.awt.BorderLayout.SOUTH);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        add(pnlRight, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * <p>
     * Switch look and feel from light to dark mode and vice-versa.</p>
     */
    private void tglDarkLightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglDarkLightActionPerformed

        boolean mode = tglDarkLight.isSelected();
        try {
            mainForm.changeLookAndFeel(mode);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PnlWelcome.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (isEnabled()) {
            tglDarkLight.setText("Light Mode");
        } else {
            tglDarkLight.setText("Dark Mode");
        }
    }//GEN-LAST:event_tglDarkLightActionPerformed
    /**
     * <p>
     * This method instantiates the validateLogin function when the mouse is
     * released after clicking the login icon element.</p>
     */
    private void icnLoginMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icnLoginMouseReleased
        mainForm.validateLogin();
    }//GEN-LAST:event_icnLoginMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private mrnock.tools.SVGImage icnLogin;
    private mrnock.tools.SVGImage imgWelcome;
    private javax.swing.JLabel lblAccessLogin;
    private javax.swing.JLabel lblMoreInfo;
    private javax.swing.JLabel lblUrlWeb;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlLeftFooter;
    private javax.swing.JPanel pnlLoginFooter;
    private javax.swing.JPanel pnlLoginWelcome;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JToggleButton tglDarkLight;
    // End of variables declaration//GEN-END:variables
private MainForm mainForm;

}
