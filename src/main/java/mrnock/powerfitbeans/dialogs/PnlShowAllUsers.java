/*
 */
package mrnock.powerfitbeans.dialogs;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import mrnock.powerfitbeans.MainForm;
import mrnock.powerfitbeans.dto.Intent;
import mrnock.powerfitbeans.dto.Usuari;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

/**
 *
 * @author SilviaRichard
 */
public class PnlShowAllUsers extends javax.swing.JPanel {

    private MainForm mainForm;
    private ArrayList<Usuari> users;
    private ArrayList<Intent> intents;
    private EmbeddedMediaPlayerComponent mediaPlayer;
    private boolean playVideo = false;
    private boolean isPlaying = false;

    String VIDEO_PATH = "C:\\Users\\SilviaRichard\\AppData\\Local\\Simulap\\videos";

    /**
     * Creates new form PnlShowAllUsers
     */
    public PnlShowAllUsers(MainForm mainForm) {
        this.mainForm = mainForm;

        initComponents();
        setBounds(10, 10, 900, 432);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlVideoPlayer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstUsers = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSelectedUserInfo = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnPauseResumeVideo = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setLayout(null);

        pnlVideoPlayer.setBorder(javax.swing.BorderFactory.createTitledBorder("Video Player"));
        pnlVideoPlayer.setLayout(new java.awt.BorderLayout());
        add(pnlVideoPlayer);
        pnlVideoPlayer.setBounds(450, 140, 280, 210);

        lstUsers.setBorder(javax.swing.BorderFactory.createTitledBorder("Users"));
        lstUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstUsers);

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 20, 190, 160);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Attempts of Selected User"));

        tblSelectedUserInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tblSelectedUserInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Activity", "Start_Date", "End_Date"
            }
        ));
        jScrollPane3.setViewportView(tblSelectedUserInfo);

        add(jScrollPane3);
        jScrollPane3.setBounds(20, 192, 380, 230);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(650, 20, 72, 23);

        btnPauseResumeVideo.setText("Pause");
        btnPauseResumeVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseResumeVideoActionPerformed(evt);
            }
        });
        add(btnPauseResumeVideo);
        btnPauseResumeVideo.setBounds(550, 370, 110, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        mainForm.showPnlIntentos();
    }//GEN-LAST:event_btnBackActionPerformed

    private void lstUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstUsersMouseClicked

        initializeUserDataTable(users.get(lstUsers.getSelectedIndex()));
    }//GEN-LAST:event_lstUsersMouseClicked

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

    public void initializeElements() {
        initializeUserList();
    }

    private void initializeUserList() {
        DefaultListModel dlm = new DefaultListModel();
        users = mainForm.getAllUsers();
        lstUsers.removeAll();
        for (Usuari u : users) {
            dlm.addElement(u.getNomUsuari());
        }

        lstUsers.setModel(dlm);
    }

    private void initializeUserDataTable(Usuari user) {
        playVideo = false;
        intents = mainForm.getAttemptsPerUser(user);
        DefaultTableModel dtm = (DefaultTableModel) tblSelectedUserInfo.getModel();

        dtm.setRowCount(0);
        for (Intent intent : intents) {
            String valueEndDate = (intent.getTimestamp_Fi() == null ? "" : intent.getTimestamp_Fi());
            dtm.insertRow(dtm.getRowCount(), new Object[]{
                intent.getId(), intent.getNomExercici(), intent.getTimestamp_Inici(), valueEndDate});
            //"ID", "EJERCICIO", "INICIO", "FIN"});
        }

        tblSelectedUserInfo.setModel(dtm);

        tblSelectedUserInfo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                playSelectedVideo(tblSelectedUserInfo.getSelectedRow());
            }
        });

        playVideo = true;
        tblSelectedUserInfo.setRowSelectionInterval(0, 0);
    }

    private void playSelectedVideo(int intento) {
        if (playVideo) {
            String videoName = intents.get(intento).getVideoFile();
            String videoFileAbsolutePath = VIDEO_PATH + File.separator + videoName;

            File f = new File(videoFileAbsolutePath);
            if (f.exists()) {

                mediaPlayer.mediaPlayer().media().play(videoFileAbsolutePath);
                pnlVideoPlayer.setBorder(javax.swing.BorderFactory.createTitledBorder("Video Player - " + videoName));
                isPlaying = true;
                btnPauseResumeVideo.setText("Pause");
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPauseResumeVideo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JList<String> lstUsers;
    private javax.swing.JPanel pnlVideoPlayer;
    private javax.swing.JTable tblSelectedUserInfo;
    // End of variables declaration//GEN-END:variables
}
