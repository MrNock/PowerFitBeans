/*
 */
package mrnock.powerfitbeans.dialogs;

import java.awt.BorderLayout;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

/**
 *
 * @author SilviaRichard
 */
public class PanelAuxiliar extends javax.swing.JPanel {

    private EmbeddedMediaPlayerComponent mediaPlayer;
    String VIDEO_PATH = "C:\\Users\\SilviaRichard\\AppData\\Local\\Simulap\\videos\\999661693.mp4";

    /**
     * Creates new form PanelAuxiliar
     */
    public PanelAuxiliar() {
        initComponents();
        mediaPlayer = new EmbeddedMediaPlayerComponent();
        //Add component and center its position within the panel
        panelVideo.add(mediaPlayer, BorderLayout.CENTER);
        panelVideo.repaint();
        
        //this.setVisible(true);
       // panelVideo.bor
        setBounds(10, 10, 500, 300);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        panelVideo = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        setLayout(new java.awt.BorderLayout());

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, java.awt.BorderLayout.PAGE_END);

        panelVideo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 51)));
        panelVideo.setLayout(new java.awt.BorderLayout());
        add(panelVideo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String videoFileAbsolutePath = VIDEO_PATH;
        mediaPlayer.mediaPlayer().media().play(videoFileAbsolutePath);
        panelVideo.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel panelVideo;
    // End of variables declaration//GEN-END:variables
}