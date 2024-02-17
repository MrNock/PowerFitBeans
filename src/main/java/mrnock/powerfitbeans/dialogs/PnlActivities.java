package mrnock.powerfitbeans.dialogs;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobClientBuilder;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mrnock.powerfitbeans.MainForm;
import mrnock.powerfitbeans.dto.Activity;
import mrnock.powerfitbeans.dto.User;
import javax.swing.JScrollPane;
import mrnock.events.MiEventPlayVideo;
import mrnock.events.MiEventPlayVideoListener;
import mrnock.events.MiEventSwipe;
import mrnock.events.MiEventSwipeListener;
import mrnock.powerfitbeans.VideoCloud;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

/**
 * This PnlAttempts class extends from JPanel and it is used to display a list
 * of users having pending reviews. Apart from this, it displays automatically a
 * video with the first record.
 *
 * The panel has a button to navigate to the screen with the information of all
 * users.
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 2.0 Final version to submit for Unit 3 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class PnlActivities extends javax.swing.JPanel implements MiEventSwipeListener, MiEventPlayVideoListener {

    SimpleDateFormat pattern = new SimpleDateFormat("EEE, dd MMM yyyy @ HH:mm"); //Tue, 16 Nov 2023 @ 18:24
    MainForm mainForm;
    private EmbeddedMediaPlayerComponent mediaPlayer;
    private JScrollPane scrollPane;
    private VideoCloud azureVideo = null;
    private javax.swing.JPanel pnlContenedor = new javax.swing.JPanel();


    /**
     * Creates new form PnlIntentos
     *
     * @param mainForm information from the MainForm screen.
     * @param user logged in user into the app.
     */
    public PnlActivities(MainForm mainForm, User user, VideoCloud azureVideo) {
        this.azureVideo = azureVideo;
        initComponents();
        //pnlContenedor.add(pnlActivitiesHeader,BorderLayout.NORTH);
        icnLogo.setSvgImage("images/login-2.svg", 45, 45);
        icnLogout.setSvgImage("images/login-2.svg", 45, 45);
        lblSwipeEvent.setText("");
        btnPlayPause.setText("...");
        btnPlayPause.setEnabled(false);
        // ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/home.svg"));
        //  Image image = imageIcon.getImage();
        //   Image newimg = image.getScaledInstance(54, 54, java.awt.Image.SCALE_SMOOTH);
        //this.lblLogOut.setIcon(new ImageIcon(newimg));

        scrollPane = new JScrollPane(pnlContenedor);

        this.pnlExercises.add(scrollPane);
        this.pnlContenedor.setLayout(new BoxLayout(pnlContenedor, javax.swing.BoxLayout.Y_AXIS));

        this.mainForm = mainForm;

        lblWelcomeInstructor.setText("Welcome " + user.getUserName());

        mediaPlayer = new EmbeddedMediaPlayerComponent();
        pnlVideoPlayer.add(mediaPlayer, BorderLayout.CENTER);
        setBounds(10, 10, 950, 500);

        if (user.isInstructor()) {
            ArrayList<User> allUsers = mainForm.getAllNormalUsers();
            for (User u : allUsers) {
                fillContainer(u);

            }

        } else {
            fillContainer(user);
            btnSeeUsers.setVisible(false);
        }
        

    }

   

    private void fillContainer(User user) {
        ArrayList<Activity> activities = mainForm.getActivitiesByUser(user);
        for (Activity activity : activities) {

            PnlExercise pne = new PnlExercise(activity.getExerciseName(), PnlExercise.IconExercise.NOT_ATTEMPTED_YET,
                    user.getUserName(), "", activity.getVideofile());
            pne.addMiEventoSwipe(this);
            pne.addMiEventoPlayVideo(this);
            this.pnlContenedor.add(pne);

        }
        //Activities pending review
        ArrayList<Activity> activitiesPendingReview = mainForm.getPendingReviewByUser(user);
        for (Activity activity : activitiesPendingReview) {
            PnlExercise pne = null;
            if (activity.getIdReview() < 0) {
                pne = new PnlExercise(activity.getExerciseName(), PnlExercise.IconExercise.PENDING_REVIEW, user.getUserName(),
                        pattern.format(activity.getTimeStamp()), activity.getVideofile());
            } else {
                pne = new PnlExercise(activity.getExerciseName(), PnlExercise.IconExercise.COMPLETE, user.getUserName(),
                        pattern.format(activity.getTimeStamp()), activity.getVideofile());
            }
            pne.addMiEventoSwipe(this);
            pne.addMiEventoPlayVideo(this);

            this.pnlContenedor.add(pne);
        }

    }

    /**
     * This method is used to play the selected video with the performance of
     * the training.
     *
     * @param videoFile video to be played
     */
    public void playSelectedVideo(String videoFile) {
        if (videoFile == null || videoFile.isEmpty()) {
            mediaPlayer.mediaPlayer().controls().stop();
            btnPlayPause.setText("...");
            btnPlayPause.setEnabled(false);
        } else {

            if (azureVideo.downloadVideoIfNecessary(videoFile)) {
                mediaPlayer.mediaPlayer().media().play(VideoCloud.videoFileAbsoluteTempPath + File.separator + videoFile);
                pnlVideoPlayer.setBorder(javax.swing.BorderFactory.createTitledBorder("Video Player - " + videoFile));
                btnPlayPause.setText("Pause");
                btnPlayPause.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "File is not in azure", "File not found", JOptionPane.ERROR_MESSAGE);
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
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        pnlActivitiesHeader = new javax.swing.JPanel();
        icnLogo = new mrnock.tools.SVGImage();
        lblWelcomeInstructor = new javax.swing.JLabel();
        icnLogout = new mrnock.tools.SVGImage();
        pnlActivitiesMain = new javax.swing.JPanel();
        pnlMainLeft = new javax.swing.JPanel();
        pnlExercises = new javax.swing.JPanel();
        lblSwipeEvent = new javax.swing.JLabel();
        pnlMainRight = new javax.swing.JPanel();
        pnlVideoPlayer = new javax.swing.JPanel();
        btnPlayPause = new javax.swing.JButton();
        pnlActivitiesFooter = new javax.swing.JPanel();
        btnSeeUsers = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        button1.setLabel("button1");

        setLayout(new java.awt.BorderLayout());

        pnlActivitiesHeader.setLayout(new java.awt.BorderLayout());
        pnlActivitiesHeader.add(icnLogo, java.awt.BorderLayout.WEST);

        lblWelcomeInstructor.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        lblWelcomeInstructor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblWelcomeInstructor.setText("Welcome <Instructor Name>");
        pnlActivitiesHeader.add(lblWelcomeInstructor, java.awt.BorderLayout.CENTER);

        icnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                icnLogoutMouseReleased(evt);
            }
        });
        pnlActivitiesHeader.add(icnLogout, java.awt.BorderLayout.EAST);

        add(pnlActivitiesHeader, java.awt.BorderLayout.NORTH);

        pnlActivitiesMain.setLayout(new java.awt.GridBagLayout());

        pnlMainLeft.setBorder(javax.swing.BorderFactory.createTitledBorder("Activities"));
        pnlMainLeft.setLayout(new java.awt.GridBagLayout());

        pnlExercises.setLayout(new javax.swing.BoxLayout(pnlExercises, javax.swing.BoxLayout.Y_AXIS));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.9;
        pnlMainLeft.add(pnlExercises, gridBagConstraints);

        lblSwipeEvent.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblSwipeEvent.setText("xxxxxxxxxxx");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        pnlMainLeft.add(lblSwipeEvent, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pnlActivitiesMain.add(pnlMainLeft, gridBagConstraints);

        pnlMainRight.setLayout(new java.awt.GridBagLayout());

        pnlVideoPlayer.setBorder(javax.swing.BorderFactory.createTitledBorder("Playing <Ejercicio>"));
        pnlVideoPlayer.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pnlMainRight.add(pnlVideoPlayer, gridBagConstraints);

        btnPlayPause.setText("Pause");
        btnPlayPause.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnPlayPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayPauseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        pnlMainRight.add(btnPlayPause, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pnlActivitiesMain.add(pnlMainRight, gridBagConstraints);

        add(pnlActivitiesMain, java.awt.BorderLayout.CENTER);

        pnlActivitiesFooter.setLayout(new java.awt.GridBagLayout());

        btnSeeUsers.setText("See users...");
        btnSeeUsers.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSeeUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeUsersActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        pnlActivitiesFooter.add(btnSeeUsers, gridBagConstraints);

        add(pnlActivitiesFooter, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method navigates to the PnlShowAllUsers screen in order to see the
     * information for all users.
     */
    private void btnSeeUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeUsersActionPerformed
        mainForm.showAllUsers();
    }//GEN-LAST:event_btnSeeUsersActionPerformed

    private void btnPlayPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayPauseActionPerformed
        if ("Pause".equals(btnPlayPause.getText())) {
            btnPlayPause.setText("Resume");
            mediaPlayer.mediaPlayer().controls().pause();

        } else {
            btnPlayPause.setText("Pause");
            mediaPlayer.mediaPlayer().controls().play();
        }

    }//GEN-LAST:event_btnPlayPauseActionPerformed

    private void icnLogoutMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icnLogoutMouseReleased
        mainForm.showWelcomePanel();
    }//GEN-LAST:event_icnLogoutMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlayPause;
    private javax.swing.JButton btnSeeUsers;
    private java.awt.Button button1;
    private mrnock.tools.SVGImage icnLogo;
    private mrnock.tools.SVGImage icnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblSwipeEvent;
    private javax.swing.JLabel lblWelcomeInstructor;
    private javax.swing.JPanel pnlActivitiesFooter;
    private javax.swing.JPanel pnlActivitiesHeader;
    private javax.swing.JPanel pnlActivitiesMain;
    private javax.swing.JPanel pnlExercises;
    private javax.swing.JPanel pnlMainLeft;
    private javax.swing.JPanel pnlMainRight;
    private javax.swing.JPanel pnlVideoPlayer;
    // End of variables declaration//GEN-END:variables

    @Override
    public void miEventoSwipeActionPerformed(MiEventSwipe evt) {
        lblSwipeEvent.setText(evt.swipeInfo());
    }

    @Override
    public void miEventoPlayVideoActionPerformed(MiEventPlayVideo evt) {
        playSelectedVideo(evt.getVideoFile());
    }
}
