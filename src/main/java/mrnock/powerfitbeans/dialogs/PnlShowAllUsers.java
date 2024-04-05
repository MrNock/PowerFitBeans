package mrnock.powerfitbeans.dialogs;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.Cursor;
import mrnock.powerfitbeans.MainForm;
import mrnock.powerfitbeans.VideoCloud;
import mrnock.powerfitbeans.dto.Attempt;
import mrnock.powerfitbeans.dto.Review;
import mrnock.powerfitbeans.dto.User;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

/**
 * This PnlShowAllUsers class extends from JPanel and it is used to get all
 * users information in the app, enabling the instructor to provide new reviews
 * or edit those already provided. Besides, the instructor can delete attempts
 * after confirming the action.
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 4.0 Final version to submit for Unit 4 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class PnlShowAllUsers extends javax.swing.JPanel {

    private MainForm mainForm;
    private ArrayList<User> users;
    private ArrayList<Attempt> attempts;
    private EmbeddedMediaPlayerComponent mediaPlayer;
    private boolean playVideo = false;
    private boolean isPlaying = false;
    private int idReviewer;
    private VideoCloud azureVideo;
    private Review selectedReview;

    /**
     * Creates new form PnlShowAllUsers
     *
     * @param mainForm information from the MainForm screen
     * @param idReviewer to identify the Reviewer
     * @param azureVideo
     */
    public PnlShowAllUsers(MainForm mainForm, int idReviewer, VideoCloud azureVideo) {
        this.mainForm = mainForm;
        this.idReviewer = idReviewer;
        this.azureVideo = azureVideo;

        initComponents();
        setBounds(10, 10, 950, 500);
        add(pnlHeaderSAU, BorderLayout.NORTH);
        icnBack.setSvgImage("images/arrow-left.svg", 45, 45);
        icnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mediaPlayer = new EmbeddedMediaPlayerComponent();

        pnlVideoPlayer.add(mediaPlayer, BorderLayout.CENTER);
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

        pnlHeaderSAU = new javax.swing.JPanel();
        icnBack = new mrnock.tools.SVGImage();
        pnlMainSAU = new javax.swing.JPanel();
        scrListUsers = new javax.swing.JScrollPane();
        lstUsers = new javax.swing.JList<>();
        scrTableSelectedUser = new javax.swing.JScrollPane();
        tblSelectedUserInfo = new javax.swing.JTable();
        pnlVideoContainer = new javax.swing.JPanel();
        pnlVideoPlayer = new javax.swing.JPanel();
        btnPauseResumeVideo = new javax.swing.JButton();
        pnlExtraInfo = new javax.swing.JPanel();
        lblQualification = new javax.swing.JLabel();
        sldQualification = new javax.swing.JSlider();
        lblComments = new javax.swing.JLabel();
        scrComments = new javax.swing.JScrollPane();
        txtComments = new javax.swing.JTextArea();
        btnEditReview = new javax.swing.JButton();
        btnAddReview = new javax.swing.JButton();
        btnDeleteAttempt = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        pnlHeaderSAU.setLayout(new java.awt.BorderLayout());

        icnBack.setToolTipText("Navigate to main screen");
        icnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                icnBackMouseReleased(evt);
            }
        });
        pnlHeaderSAU.add(icnBack, java.awt.BorderLayout.WEST);

        add(pnlHeaderSAU, java.awt.BorderLayout.NORTH);

        pnlMainSAU.setLayout(new java.awt.GridBagLayout());

        scrListUsers.setPreferredSize(new java.awt.Dimension(200, 200));

        lstUsers.setBorder(javax.swing.BorderFactory.createTitledBorder("Users"));
        lstUsers.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lstUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lstUsers.setMaximumSize(new java.awt.Dimension(200, 200));
        lstUsers.setMinimumSize(new java.awt.Dimension(200, 200));
        lstUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstUsersMouseClicked(evt);
            }
        });
        scrListUsers.setViewportView(lstUsers);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pnlMainSAU.add(scrListUsers, gridBagConstraints);

        scrTableSelectedUser.setBorder(javax.swing.BorderFactory.createTitledBorder("Attempts of Selected User"));

        tblSelectedUserInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tblSelectedUserInfo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblSelectedUserInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Activity", "Start_Date", "End_Date"
            }
        ));
        tblSelectedUserInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblSelectedUserInfo.setMaximumSize(new java.awt.Dimension(200, 200));
        tblSelectedUserInfo.setMinimumSize(new java.awt.Dimension(200, 200));
        tblSelectedUserInfo.setPreferredSize(new java.awt.Dimension(200, 200));
        scrTableSelectedUser.setViewportView(tblSelectedUserInfo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pnlMainSAU.add(scrTableSelectedUser, gridBagConstraints);

        pnlVideoContainer.setMaximumSize(new java.awt.Dimension(200, 200));
        pnlVideoContainer.setMinimumSize(new java.awt.Dimension(200, 200));
        pnlVideoContainer.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlVideoContainer.setLayout(new java.awt.GridBagLayout());

        pnlVideoPlayer.setBorder(javax.swing.BorderFactory.createTitledBorder("Video Player"));
        pnlVideoPlayer.setMaximumSize(new java.awt.Dimension(200, 200));
        pnlVideoPlayer.setMinimumSize(new java.awt.Dimension(200, 200));
        pnlVideoPlayer.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.9;
        pnlVideoContainer.add(pnlVideoPlayer, gridBagConstraints);

        btnPauseResumeVideo.setText("Pause");
        btnPauseResumeVideo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPauseResumeVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseResumeVideoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        pnlVideoContainer.add(btnPauseResumeVideo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pnlMainSAU.add(pnlVideoContainer, gridBagConstraints);

        pnlExtraInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Extra Info"));
        pnlExtraInfo.setMaximumSize(new java.awt.Dimension(200, 200));
        pnlExtraInfo.setMinimumSize(new java.awt.Dimension(200, 200));
        pnlExtraInfo.setPreferredSize(new java.awt.Dimension(200, 200));
        pnlExtraInfo.setLayout(new java.awt.GridBagLayout());

        lblQualification.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblQualification.setText("Qualification");
        lblQualification.setToolTipText("");
        lblQualification.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weighty = 0.3;
        pnlExtraInfo.add(lblQualification, gridBagConstraints);

        sldQualification.setMajorTickSpacing(1);
        sldQualification.setMaximum(5);
        sldQualification.setPaintLabels(true);
        sldQualification.setPaintTicks(true);
        sldQualification.setSnapToTicks(true);
        sldQualification.setToolTipText("");
        sldQualification.setValue(3);
        sldQualification.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlExtraInfo.add(sldQualification, gridBagConstraints);

        lblComments.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblComments.setText("Comments");
        lblComments.setToolTipText("");
        lblComments.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        pnlExtraInfo.add(lblComments, gridBagConstraints);

        txtComments.setColumns(20);
        txtComments.setLineWrap(true);
        txtComments.setRows(5);
        scrComments.setViewportView(txtComments);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        pnlExtraInfo.add(scrComments, gridBagConstraints);

        btnEditReview.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEditReview.setText("Edit Review");
        btnEditReview.setToolTipText("Click to edit the review");
        btnEditReview.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditReviewActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlExtraInfo.add(btnEditReview, gridBagConstraints);

        btnAddReview.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAddReview.setText("Add Review");
        btnAddReview.setToolTipText("Click to update your review");
        btnAddReview.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddReviewActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlExtraInfo.add(btnAddReview, gridBagConstraints);

        btnDeleteAttempt.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDeleteAttempt.setText("Delete Attempt");
        btnDeleteAttempt.setToolTipText("Click to delete the exercise");
        btnDeleteAttempt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteAttempt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAttemptActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlExtraInfo.add(btnDeleteAttempt, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        pnlMainSAU.add(pnlExtraInfo, gridBagConstraints);

        add(pnlMainSAU, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method initializes the Datatable component with the information.
     */
    private void lstUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstUsersMouseClicked

        initializeUserDataTable(users.get(lstUsers.getSelectedIndex()));
    }//GEN-LAST:event_lstUsersMouseClicked

    /**
     * This method controls the video player by playing and pausing the
     * recordings.
     */
    private void btnPauseResumeVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseResumeVideoActionPerformed
        if (isPlaying) {
            btnPauseResumeVideo.setText("Resume");
            mediaPlayer.mediaPlayer().controls().pause();
            isPlaying = false;

        } else {
            btnPauseResumeVideo.setText("Play");
            mediaPlayer.mediaPlayer().controls().play();
            isPlaying = true;
        }
    }//GEN-LAST:event_btnPauseResumeVideoActionPerformed

    /**
     * This method calls the updateReview method.
     */
    private void btnEditReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditReviewActionPerformed
        Review review = new Review();

        review.setId(selectedReview.getId());
        review.setIdReviewer(idReviewer);
        review.setScore(sldQualification.getValue());
        review.setComment(txtComments.getText());
        mainForm.updateReview(review);
    }//GEN-LAST:event_btnEditReviewActionPerformed

    /**
     * This method calls the insertReview method.
     */
    private void btnAddReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddReviewActionPerformed
        Review review = new Review();
        Attempt attempt = attempts.get(tblSelectedUserInfo.getSelectedRow());
        review.setIdAttempt(attempt.getId());
        review.setIdReviewer(idReviewer);
        review.setScore(sldQualification.getValue());
        review.setComment(txtComments.getText());
        mainForm.insertReview(review);
    }//GEN-LAST:event_btnAddReviewActionPerformed

    /**
     * This method calls the deleteAttempt method.
     */
    private void btnDeleteAttemptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAttemptActionPerformed
        playVideo = false;
        Attempt attempt = attempts.get(tblSelectedUserInfo.getSelectedRow());
        if (mainForm.deleteAttempt(attempt)) {

            DefaultTableModel dtm = (DefaultTableModel) tblSelectedUserInfo.getModel();
            dtm.removeRow(tblSelectedUserInfo.getSelectedRow());

            tblSelectedUserInfo.setModel(dtm);

            if (tblSelectedUserInfo.getRowCount() > 0) {
                tblSelectedUserInfo.setRowSelectionInterval(0, 0);
            }
        }
        playVideo = true;
    }//GEN-LAST:event_btnDeleteAttemptActionPerformed

    private void icnBackMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icnBackMouseReleased
        mainForm.showPnlAttempts();
    }//GEN-LAST:event_icnBackMouseReleased

    /**
     * This public method initializes the list of users.
     */
    public void initializeElements() {
        initializeUserList();
    }

    /**
     * This private method initializes the list of users.
     */
    private void initializeUserList() {
        DefaultListModel dlm = new DefaultListModel();
        users = mainForm.getAllNormalUsers();
        lstUsers.removeAll();
        for (User u : users) {
            dlm.addElement(u.getUserName());
        }
        lstUsers.setModel(dlm);
    }

    /**
     * This private method initializes the Datatable of users.
     */
    private void initializeUserDataTable(User user) {
        playVideo = false;
        attempts = mainForm.getAttemptsPerUser(user);
        DefaultTableModel dtm = (DefaultTableModel) tblSelectedUserInfo.getModel();

        dtm.setRowCount(0);
        for (Attempt intent : attempts) {
            String valueEndDate = (intent.getTimestartEnd() == null ? "" : intent.getTimestartEnd());
            dtm.insertRow(dtm.getRowCount(), new Object[]{
                intent.getId(), intent.getExerciseName(), intent.getTimestampStart(), valueEndDate});
        }

        tblSelectedUserInfo.setModel(dtm);

        tblSelectedUserInfo.getSelectionModel().addListSelectionListener((ListSelectionEvent evt) -> {
            if (evt.getValueIsAdjusting()) {
                return;
            }
            playSelectedVideo(tblSelectedUserInfo.getSelectedRow());
            setReviewData(tblSelectedUserInfo.getSelectedRow());
        });

        playVideo = true;
        if (tblSelectedUserInfo.getRowCount() > 0) {
            tblSelectedUserInfo.setRowSelectionInterval(0, 0);
        }

    }

    /**
     * This method adds the review details for a specific selected row.
     */
    private void setReviewData(int row) {
        if (playVideo) {
            Attempt intent = attempts.get(row);
            selectedReview = mainForm.getReviewByAttempt(intent.getId());

            if (selectedReview.getComment() == null || selectedReview.getComment().isEmpty()) {
                btnEditReview.setVisible(false);
                txtComments.setText("");
                sldQualification.setValue(3);
            } else {
                btnEditReview.setVisible(true);
                sldQualification.setValue(selectedReview.getScore());
                txtComments.setText(selectedReview.getComment());
            }
        }
    }

    /**
     * This method plays the video for a specific selected row.
     */
    private void playSelectedVideo(int attempt) {
        if (playVideo) {
            String videoName = attempts.get(attempt).getVideoFile();
            String userName = attempts.get(attempt).getUserName();
            String videoFileAbsolutePath = VideoCloud.videoFileAbsoluteTempPath + File.separator + videoName;
            if (azureVideo.downloadVideoIfNecessary(videoName)) {
                mediaPlayer.mediaPlayer().media().play(videoFileAbsolutePath);
                pnlVideoPlayer.setBorder(javax.swing.BorderFactory.createTitledBorder("Video Player - " + videoName));
                scrTableSelectedUser.setBorder(javax.swing.BorderFactory.createTitledBorder(userName + "'s Attempts"));
                isPlaying = true;
                btnPauseResumeVideo.setText("Pause");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddReview;
    private javax.swing.JButton btnDeleteAttempt;
    private javax.swing.JButton btnEditReview;
    private javax.swing.JButton btnPauseResumeVideo;
    private mrnock.tools.SVGImage icnBack;
    private javax.swing.JLabel lblComments;
    private javax.swing.JLabel lblQualification;
    private javax.swing.JList<String> lstUsers;
    private javax.swing.JPanel pnlExtraInfo;
    private javax.swing.JPanel pnlHeaderSAU;
    private javax.swing.JPanel pnlMainSAU;
    private javax.swing.JPanel pnlVideoContainer;
    private javax.swing.JPanel pnlVideoPlayer;
    private javax.swing.JScrollPane scrComments;
    private javax.swing.JScrollPane scrListUsers;
    private javax.swing.JScrollPane scrTableSelectedUser;
    private javax.swing.JSlider sldQualification;
    private javax.swing.JTable tblSelectedUserInfo;
    private javax.swing.JTextArea txtComments;
    // End of variables declaration//GEN-END:variables
}
