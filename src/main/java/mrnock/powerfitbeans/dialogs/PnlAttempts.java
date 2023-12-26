package mrnock.powerfitbeans.dialogs;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import mrnock.powerfitbeans.MainForm;
import mrnock.powerfitbeans.dto.Activity;
import mrnock.powerfitbeans.dto.User;
import javax.swing.JScrollPane;
import mrnock.events.MiEventPlayVideo;
import mrnock.events.MiEventPlayVideoListener;
import mrnock.events.MiEventSwipe;
import mrnock.events.MiEventSwipeListener;
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
 * @version 2.0 Final version to submit for Unit 1 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class PnlAttempts extends javax.swing.JPanel implements MiEventSwipeListener, MiEventPlayVideoListener {

    SimpleDateFormat pattern = new SimpleDateFormat("EEE, dd MMM yyyy @ HH:mm"); //Tue, 16 Nov 2023 @ 18:24
    //String formattedDate = pattern.formatted(timeStamp);
    MainForm mainForm;
    //ArrayList<Attempt> attempts;
    private EmbeddedMediaPlayerComponent mediaPlayer;
    private JScrollPane scrollPane;
    private javax.swing.JPanel pnlContenedor = new javax.swing.JPanel();

    final String VIDEO_PATH = "C:\\Users\\SilviaRichard\\AppData\\Local\\Simulap\\videos";

    /**
     * Creates new form PnlIntentos
     *
     * @param mainForm information from the MainForm screen.
     * @param attempt ArrayList of attempts pending of review.
     * @param username to be displayed in the Welcome Label.
     */
    public PnlAttempts(MainForm mainForm, User user) {
        initComponents();

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/logout.png"));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(54, 54, java.awt.Image.SCALE_SMOOTH);
        this.lblLogOut.setIcon(new ImageIcon(newimg));

        scrollPane = new JScrollPane(pnlContenedor);

        this.pnlExercises.add(scrollPane);
        this.pnlContenedor.setLayout(new BoxLayout(pnlContenedor, javax.swing.BoxLayout.Y_AXIS));

        this.mainForm = mainForm;

        lblWelcomeInstructor.setText("Welcome " + user.getUserName());

        mediaPlayer = new EmbeddedMediaPlayerComponent();
        pnlVideoPlayer.add(mediaPlayer, BorderLayout.CENTER);
        setBounds(10, 10, 950, 500);

        if (user.getIsInstructor()) {
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
        ArrayList<Activity> activities = mainForm.getPendingActivitiesByUser(user);
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
     * @param row number for the video to be played.
     */
    public void playSelectedVideo(String videoFile) {
        if (videoFile == null || videoFile.isEmpty()) {

            mediaPlayer.mediaPlayer().controls().stop();
        } else {
//        String videoName = attempts.get(row).getVideoFile();
            String videoFileAbsolutePath = VIDEO_PATH + File.separator + videoFile;

            File f = new File(videoFileAbsolutePath);
            if (f.exists()) {

                mediaPlayer.mediaPlayer().media().play(videoFileAbsolutePath);
                pnlVideoPlayer.setBorder(javax.swing.BorderFactory.createTitledBorder("Video Player - " + videoFile));
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

        jLabel1 = new javax.swing.JLabel();
        lblLogoImg = new javax.swing.JLabel();
        lblWelcomeInstructor = new javax.swing.JLabel();
        pnlVideoPlayer = new javax.swing.JPanel();
        lblSwipeEvent = new javax.swing.JLabel();
        btnSeeUsers = new javax.swing.JButton();
        pnlExercises = new javax.swing.JPanel();
        lblLogOut = new javax.swing.JLabel();
        lblActivities = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setPreferredSize(new java.awt.Dimension(1000, 432));

        lblLogoImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/54x54_PowerFitBeans.png"))); // NOI18N
        lblLogoImg.setText("jLabel1");

        lblWelcomeInstructor.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        lblWelcomeInstructor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblWelcomeInstructor.setText("Welcome <Instructor Name>");

        pnlVideoPlayer.setBorder(javax.swing.BorderFactory.createTitledBorder("Playing <Ejercicio>"));
        pnlVideoPlayer.setLayout(new java.awt.BorderLayout());

        lblSwipeEvent.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        btnSeeUsers.setText("See users...");
        btnSeeUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeUsersActionPerformed(evt);
            }
        });

        pnlExercises.setLayout(new javax.swing.BoxLayout(pnlExercises, javax.swing.BoxLayout.Y_AXIS));

        lblLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogOutMouseClicked(evt);
            }
        });

        lblActivities.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblActivities.setText("Activities");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(pnlExercises, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSeeUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblActivities, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblSwipeEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(170, 170, 170)))
                        .addComponent(pnlVideoPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(56, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLogoImg, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblWelcomeInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblLogoImg, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSwipeEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblActivities, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlExercises, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSeeUsers)
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWelcomeInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlVideoPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method navigates to the PnlShowAllUsers screen in order to see the
     * information for all users.
     */
    private void btnSeeUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeUsersActionPerformed
        mainForm.showAllUsers();
    }//GEN-LAST:event_btnSeeUsersActionPerformed

    private void lblLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseClicked
        mainForm.showWelcomePanel();
    }//GEN-LAST:event_lblLogOutMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeeUsers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblActivities;
    private javax.swing.JLabel lblLogOut;
    private javax.swing.JLabel lblLogoImg;
    private javax.swing.JLabel lblSwipeEvent;
    private javax.swing.JLabel lblWelcomeInstructor;
    private javax.swing.JPanel pnlExercises;
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
