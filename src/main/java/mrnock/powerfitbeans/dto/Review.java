package mrnock.powerfitbeans.dto;

/**
 * Public class Review with its private attributes. It contains the getters and
 * setters methods.
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 4.0 Final version to submit for Unit 4 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class Review {

    private int id;
    private int score;
    private int idAttempt;
    private int idReviewer;
    private String comment;

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getIdAttempt() {
        return idAttempt;
    }

    public void setIdAttempt(int idAttempt) {
        this.idAttempt = idAttempt;
    }

    public int getIdReviewer() {
        return idReviewer;
    }

    public void setIdReviewer(int idReviewer) {
        this.idReviewer = idReviewer;
    }
}
