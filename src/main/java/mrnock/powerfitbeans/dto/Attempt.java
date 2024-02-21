package mrnock.powerfitbeans.dto;

/**
 * Public class Attempt with its private attributes. It contains the getters and
 * setters methods.
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 4.0 Final version to submit for Unit 4 (Desarrollo de Interfaces)
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

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(int idExercise) {
        this.idExercise = idExercise;
    }

    public String getTimestampStart() {
        return timestampStart;
    }

    public void setTimestampStart(String timestampStart) {
        this.timestampStart = timestampStart;
    }

    public String getTimestartEnd() {
        return timestartEnd;
    }

    public void setTimestartEnd(String timestartEnd) {
        this.timestartEnd = timestartEnd;
    }

    public String getVideoFile() {
        return videoFile;
    }

    public void setVideoFile(String videoFile) {
        this.videoFile = videoFile;
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
}
