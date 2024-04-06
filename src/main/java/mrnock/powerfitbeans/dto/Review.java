package mrnock.powerfitbeans.dto;

/**
 * <p>
 * Public class Review with its private attributes. It contains the getters and
 * setters methods.</p>
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 6.0 Final version to submit for Unit 6 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class Review {

    private int id;
    private int score;
    private int idAttempt;
    private int idReviewer;
    private String comment;

    /**
     * <p>
     * This method gets the identifier of a review.</p>
     *
     * @return integer with the review ID.
     */
    public int getId() {
        return id;
    }

    /**
     * <p>
     * This method sets the identifier of a review.</p>
     *
     * @param id integer with the review ID to be set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * <p>
     * This method gets the score of a review.</p>
     *
     * @return integer with the review score.
     */
    public int getScore() {
        return score;
    }

    /**
     * <p>
     * This method sets the score of a review.</p>
     *
     * @param score integer with the review score to be set.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * <p>
     * This method gets the comments of a review.</p>
     *
     * @return String with the review comments.
     */
    public String getComment() {
        return comment;
    }

    /**
     * <p>
     * This method sets the comments of a review.</p>
     *
     * @param comment String with the review comments to be set.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * <p>
     * This method gets the identifier of an attempt.</p>
     *
     * @return integer with the attempt ID.
     */
    public int getIdAttempt() {
        return idAttempt;
    }

    /**
     * <p>
     * This method sets the identifier of an attempt.</p>
     *
     * @param idAttempt integer with the attempt ID to be set.
     */
    public void setIdAttempt(int idAttempt) {
        this.idAttempt = idAttempt;
    }

    /**
     * <p>
     * This method gets the identifier of a reviewer.</p>
     *
     * @return integer with the reviewer ID.
     */
    public int getIdReviewer() {
        return idReviewer;
    }

    /**
     * <p>
     * This method sets the identifier of a reviewer.</p>
     *
     * @param idReviewer integer with the reviewer ID to be set.
     */
    public void setIdReviewer(int idReviewer) {
        this.idReviewer = idReviewer;
    }
}
