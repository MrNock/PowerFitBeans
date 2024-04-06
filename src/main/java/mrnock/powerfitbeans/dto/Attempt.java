package mrnock.powerfitbeans.dto;

/**
 * <p>
 * Public class Attempt with its private attributes. It contains the getters and
 * setters methods.</p>
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 6.0 Final version to submit for Unit 6 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class Attempt {

    private int id;
    private int idUser;
    private int idExercise;
    private String userName;
    private String exerciseName;
    private String timestampStart;
    private String timestartEnd;
    private String videoFile;

    /**
     * <p>
     * This method gets the identifier of an attempt.</p>
     *
     * @return integer with the attempt ID.
     */
    public int getId() {
        return id;
    }

    /**
     * <p>
     * This method sets the identifier of an attempt.</p>
     *
     * @param id with the attempt ID to be set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * <p>
     * This method gets the user identifier.</p>
     *
     * @return integer with the user ID.
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * <p>
     * This method sets the user identifier.</p>
     *
     * @param idUser integer with the user ID to be set.
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * <p>
     * This method gets the exercise identifier.</p>
     *
     * @return integer with the exercise ID.
     */
    public int getIdExercise() {
        return idExercise;
    }

    /**
     * <p>
     * This method sets the exercise identifier.</p>
     *
     * @param idExercise integer with the exercise ID to be set.
     */
    public void setIdExercise(int idExercise) {
        this.idExercise = idExercise;
    }

    /**
     * <p>
     * This method gets the value of the starting time.</p>
     *
     * @return String with the value of the starting time.
     */
    public String getTimestampStart() {
        return timestampStart;
    }

    /**
     * <p>
     * This method sets the value of the starting time.</p>
     *
     * @param timestampStart String with the value of the starting time to be
     * set.
     */
    public void setTimestampStart(String timestampStart) {
        this.timestampStart = timestampStart;
    }

    /**
     * <p>
     * This method gets the value of the end time.</p>
     *
     * @return String with the value of the end time.
     */
    public String getTimestartEnd() {
        return timestartEnd;
    }

    /**
     * <p>
     * This method sets the value of the end time.</p>
     *
     * @param timestartEnd String with the value of the end time to be set.
     */
    public void setTimestartEnd(String timestartEnd) {
        this.timestartEnd = timestartEnd;
    }

    /**
     * <p>
     * This method gets the value of the video file.</p>
     *
     * @return String with the value of the video file.
     */
    public String getVideoFile() {
        return videoFile;
    }

    /**
     * <p>
     * This method sets the value of the video file.</p>
     *
     * @param videoFile String with the value of the video file to be set.
     */
    public void setVideoFile(String videoFile) {
        this.videoFile = videoFile;
    }

    /**
     * <p>
     * This method gets the user name.</p>
     *
     * @return String with the user name.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * <p>
     * This method sets the user name.</p>
     *
     * @param userName String with the String of the user name to be set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * <p>
     * This method gets the name of an exercise.</p>
     *
     * @return String with the the name of an exercise.
     */
    public String getExerciseName() {
        return exerciseName;
    }

    /**
     * <p>
     * This method sets the name of an exercise.</p>
     *
     * @param exerciseName String with the the name of an exercise to be set.
     */
    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }
}
