package mrnock.powerfitbeans;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatLightOwlIJTheme;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import mrnock.powerfitbeans.dataacccess.Controller;
import mrnock.powerfitbeans.dialogs.DlgLogin;
import mrnock.powerfitbeans.dialogs.PnlActivities;
import mrnock.powerfitbeans.dialogs.PnlShowAllUsers;
import mrnock.powerfitbeans.dialogs.PnlWelcome;
import mrnock.powerfitbeans.dto.Activity;
import mrnock.powerfitbeans.dto.Attempt;
import mrnock.powerfitbeans.dto.Review;
import mrnock.powerfitbeans.dto.User;

/**
 * This sports-training application provides users with the capability to submit
 * workout videos, receiving personalized feedback and ratings from expert
 * instructors. Users benefit from detailed comments and a precise 1-to-5 score,
 * facilitating targeted improvements in athletic performance.
 *
 * This MainForm is in charge of interacting with the rest of panels from within
 * the app, calling different methods implemented in the Controller. This
 * Controller is used as an intermediate interface from the DataAccess class, in
 * order to give some additional security and freeing the MainForm to deal with
 * the logic of the program.
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 4.0 Final version to submit for Unit 4 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class MainForm extends javax.swing.JFrame {

    private DlgLogin dlgLogin;
    private PnlWelcome pnlWelcome;
    private Controller controller;
    private PnlActivities pnlAttempts;
    private PnlShowAllUsers pnlShowAllUsers;
    private User loggedUser;
    private GridBagConstraints gridBagConstraints;
    private VideoCloud azureVideo;

    /**
     * MainForm constructor method with its settings
     */
    public MainForm() {
        initComponents();
        setSize(1000, 600);
        setResizable(true);
        setLocationRelativeTo(null);

        controller = new Controller();
        azureVideo = new VideoCloud();
        azureVideo.initializeVideoListFromCloud();
        showWelcomePanel();
    }

    public void showWelcomePanel() {
        getContentPane().removeAll();
        getContentPane().repaint();
        pnlWelcome = new PnlWelcome(this);
        pnlWelcome.setBounds(0, 10, 1000, 500);
        getContentPane().setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(pnlWelcome, gridBagConstraints);
        //pnlWelcome.repaint();
        pnlWelcome.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method validates the Login credentials provided by users
     */
    public void validateLogin() {

        dlgLogin = new DlgLogin(this);
        dlgLogin.setVisible(true);
    }

    /**
     * This method validates the Login credentials provided by users
     *
     * @param email String with the user's email
     * @param password String with the user's password
     */
    public void validateUser(String email, char[] password) {

        loggedUser = controller.validateLogin(email, password);
        if (loggedUser == null) {
            JOptionPane.showMessageDialog(this, "The e-mail or"
                    + " password provided is incorrect", "Login Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            dlgLogin.dispose();
            showPnlAttempts();
        }
    }

    /**
     * This method updates the score and comments provided by the instructor
     *
     * @param review Review with the updated values
     */
    public void updateReview(Review review) {
        controller.updateReview(review);
    }

    /**
     * This method adds a new review in the Database
     *
     * @param review Review with the newly created values
     */
    public void insertReview(Review review) {
        controller.insertReview(review);
    }

    /**
     * This method prompts the user to confirm a deletion of an attempt and if
     * confirmed, it removes the specific record from the Database. To conclude,
     * it displays a message with the result.
     *
     * @param attempt Attempt to be deleted
     * @return boolean with the number of rows affected
     */
    public boolean deleteAttempt(Attempt attempt) {
        int result = JOptionPane.showConfirmDialog(this, "Are you sure"
                + " you want to delete the attempt with id. " + attempt.getId()
                + "?", "Please confirm action", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            if (controller.deleteAttempt(attempt) > 0) {

                JOptionPane.showMessageDialog(this, "Attempt with id. "
                        + attempt.getId() + " has been deleted successfully",
                        "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Attempt with id. "
                        + attempt.getId() + " was not deleted", "Error message",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    /**
     * This method gets all the information from users and initializes the GUI
     * elements.
     */
    public void showAllUsers() {
        getContentPane().removeAll();
        pnlShowAllUsers = new PnlShowAllUsers(this, loggedUser.getId(), azureVideo);

        getContentPane().setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(pnlShowAllUsers, gridBagConstraints);
        pnlShowAllUsers.initializeElements();
        pnlShowAllUsers.updateUI();
    }

    /**
     * This method gets a list with all users and their information.
     *
     * @return ArrayList of all user and their information.
     */
    public ArrayList<User> getAllNormalUsers() {
        return controller.getAllNormalUsers();
    }

    /**
     * This method displays the main page with the attempts pending of a review
     * from the instructor. It gives the possibility to navigate to the screen
     * with all the information from all users, not only for those with a
     * pending review.
     */
    public void showPnlAttempts() {
        //ArrayList<Attempt> attempts = controller.getAttemptsPendingReview();

        getContentPane().removeAll();
        if (pnlShowAllUsers != null) {
            pnlShowAllUsers.updateUI();
        }

//        pnlAttempts = new PnlActivities(this, attempts, userName);
        pnlAttempts = new PnlActivities(this, loggedUser, azureVideo);
        getContentPane().setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(pnlAttempts, gridBagConstraints);

        pnlAttempts.updateUI();
        pnlAttempts.playSelectedVideo("");
    }

    /**
     * This method gets a list with all the attempts for a specific user.
     *
     * @param user User for which we want to get the information from.
     * @return ArrayList of users for a certain user.
     */
    public ArrayList<Attempt> getAttemptsPerUser(User user) {
        return controller.getAttemptsPerUser(user);
    }

    /**
     * This method gets a review by its attempt identification.
     *
     * @param idAttempt Attempt identification
     * @return Review based on an attempt id.
     */
    public Review getReviewByAttempt(int idAttempt) {
        return controller.getReviewByAttempt(idAttempt);
    }

    public ArrayList<Activity> getActivitiesByUser(User u) {
        return controller.getPendingActivitiesByUser(u);
    }

    public ArrayList<Activity> getPendingReviewByUser(User u) {
        return controller.getPendingReviewByUser(u);
    }

    public void changeLookAndFeel(boolean isEnabled) throws UnsupportedLookAndFeelException {
        if (isEnabled) {
            UIManager.setLookAndFeel(new FlatArcDarkIJTheme());
            FlatDarkLaf.registerCustomDefaultsSource("style"); //Properties
            FlatDarkLaf.setup();

        } else {
            UIManager.setLookAndFeel(new FlatLightOwlIJTheme());
            FlatLightLaf.registerCustomDefaultsSource("style"); //Properties
            FlatLightLaf.setup();
        }
        SwingUtilities.updateComponentTreeUI(this);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        FlatLightLaf.registerCustomDefaultsSource("style"); //Properties
        FlatLightLaf.setup(); //FlatLightLaf (Light) || FlatDarkLaf (Dark) 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
