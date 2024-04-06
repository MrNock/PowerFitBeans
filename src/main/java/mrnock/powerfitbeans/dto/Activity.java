package mrnock.powerfitbeans.dto;

import java.util.Date;

/**
 * <p>
 * Public class Activity with its private attributes. It contains the getters
 * and setters methods.</p>
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 6.0 Final version to submit for Unit 6 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class Activity {

    /**
     * <p>
     * String with the name of the user.</p>
     */
    protected String userName;

    /**
     * <p>
     * String with the name of the exercise.</p>
     */
    protected String exerciseName;

    /**
     * <p>
     * Date object with the time stamp value.</p>
     */
    protected Date timeStamp = null;

    /**
     * <p>
     * Integer with the review identifier.</p>
     */
    protected int idReview = -1;

    /**
     * <p>
     * String with the name of video file.</p>
     */
    protected String videofile;

    /**
     * <p>
     * This constructor method to create a new Activity object.</p>
     */
    public Activity() {
    }

    /**
     * <p>
     * This method gets the value of the videofile variable.</p>
     *
     * @return video file name.
     */
    public String getVideofile() {
        return videofile;
    }

    /**
     * <p>
     * This method sets the value of the videofile variable.</p>
     *
     * @param videofile value to be set.
     */
    public void setVideofile(String videofile) {
        this.videofile = videofile;
    }

    /**
     * <p>
     * This method gets the value of the review identifier.</p>
     *
     * @return idReview with the Review ID.
     */
    public int getIdReview() {
        return idReview;
    }

    /**
     * <p>
     * This method sets the value of the review identifier.</p>
     *
     * @param idReview value to be set.
     */
    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    /**
     * <p>
     * This method gets the user name.</p>
     *
     * @return userName string with the user name.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * <p>
     * This method sets the user name.</p>
     *
     * @param userName string with the the user name to be set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * <p>
     * This method gets the exercise name.</p>
     *
     * @return exerciseName string with the exercise name.
     */
    public String getExerciseName() {
        return exerciseName;
    }

    /**
     * <p>
     * This method sets the exercise name.</p>
     *
     * @param exerciseName string with the exercise name to be set.
     */
    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    /**
     * <p>
     * This method gets the time stamp.</p>
     *
     * @return timeStamp Date object with the time stamp.
     */
    public Date getTimeStamp() {
        return timeStamp;
    }

    /**
     * <p>
     * This method sets the time stamp.</p>
     *
     * @param timeStamp Date object with the time stamp to be set.
     */
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

}
