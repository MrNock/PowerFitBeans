package mrnock.events;

import java.awt.event.ActionEvent;


/**
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 */

public class MiEventPlayVideo extends  ActionEvent{

    public String getVideoFile() {
        return videoFile;
    }

    public void setVideoFile(String videoFile) {
        this.videoFile = videoFile;
    }
  
    protected String videoFile;
    public MiEventPlayVideo(Object source, String videoFile) {
        super(source, 0, null);
        this.videoFile = videoFile;
    }
}
