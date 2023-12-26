package mrnock.powerfitbeans.dto;

import java.util.Date;

/**
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 */
public class Activity {

    protected String userName;
    protected String exerciseName;
    protected Date timeStamp;
    protected int idReview = -1;
    protected String videofile;

    public String getVideofile() {
        return videofile;
    }

    public void setVideofile(String videofile) {
        this.videofile = videofile;
    }

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public Activity() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

}
