package mrnock.events;

import java.awt.event.ActionEvent;

/**
 * <p>
 * This MiEventPlayVideo public class is created to support the app and extends
 * the ActionEvent super class.</p>
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 6.0 Final version to submit for Unit 6 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class MyEventPlayVideo extends ActionEvent {

    /**
     * <p>
     * Getter method to obtain the video file name.</p>
     *
     * @return String with the video file name.
     */
    public String getVideoFile() {
        return videoFile;
    }

    /**
     * <p>
     * This method sets the video file name.</p>
     *
     * @param videoFile String with the video file name to be set.
     */
    public void setVideoFile(String videoFile) {
        this.videoFile = videoFile;
    }

    /**
     * <p>
     * Protected String variable for the video file name.</p>
     */
    protected String videoFile;

    /**
     * <p>
     * Public method to trigger the play video event.</p>
     *
     * @param source that has triggered the play video event.
     * @param videoFile String variable with the video file name.
     */
    public MyEventPlayVideo(Object source, String videoFile) {
        super(source, 0, null);
        this.videoFile = videoFile;
    }
}
