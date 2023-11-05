/*
 */
package mrnock.powerfitbeans.dialogs;
import mrnock.powerfitbeans.MainForm;

/**
 *
 * @author SilviaRichard
 */
public class PnlWelcome extends javax.swing.JPanel {

    /**
     * Creates new form PnlWelcome
     */
    public PnlWelcome(MainForm mainForm) {
        this.mainForm = mainForm;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblWelcome = new javax.swing.JLabel();
        lblAccessLogin = new javax.swing.JLabel();
        lblIconLogin = new javax.swing.JLabel();
        lblMoreInfo = new javax.swing.JLabel();
        lblUrlWeb = new javax.swing.JLabel();

        setLayout(null);

        lblWelcome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Welcome to the Power Fit Beans App");
        add(lblWelcome);
        lblWelcome.setBounds(8, 8, 310, 40);

        lblAccessLogin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAccessLogin.setText("Click to login:");
        add(lblAccessLogin);
        lblAccessLogin.setBounds(40, 190, 150, 30);

        lblIconLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-login-64.png"))); // NOI18N
        lblIconLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIconLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconLoginMouseClicked(evt);
            }
        });
        add(lblIconLogin);
        lblIconLogin.setBounds(200, 180, 70, 50);

        lblMoreInfo.setText("More info: ");
        add(lblMoreInfo);
        lblMoreInfo.setBounds(80, 390, 60, 16);

        lblUrlWeb.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblUrlWeb.setForeground(new java.awt.Color(0, 0, 255));
        lblUrlWeb.setText("www.powerfitbeans.com");
        lblUrlWeb.setToolTipText("https://paucasesnovescifp.cat/");
        lblUrlWeb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(lblUrlWeb);
        lblUrlWeb.setBounds(140, 390, 160, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void lblIconLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconLoginMouseClicked
        dlgLogin = new DlgLogin(mainForm);
        dlgLogin.setVisible(true);
      
    }//GEN-LAST:event_lblIconLoginMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAccessLogin;
    private javax.swing.JLabel lblIconLogin;
    private javax.swing.JLabel lblMoreInfo;
    private javax.swing.JLabel lblUrlWeb;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
    private DlgLogin dlgLogin;
    private MainForm mainForm;
}