package mrnock.powerfitbeans.dataacccess;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.util.ArrayList;
import mrnock.powerfitbeans.dto.Activity;
import mrnock.powerfitbeans.dto.Attempt;
import mrnock.powerfitbeans.dto.Review;
import mrnock.powerfitbeans.dto.User;

/**
 * <p>
 * This Controller class is instantiated by the MainForm and it is used as an
 * abstraction level between the DataAccess class (query to DataBase) and
 * MainForm (dealing with the rest of windows in the app.</p>
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 6.0 Final version to submit for Unit 6 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class Controller {

    DataAccess da = null;

    /**
     * <p>
     * This Controller constructor creates a new DataAccess object.</p>
     */
    public Controller() {
        da = new DataAccess();
    }

    /**
     * <p>
     * This method validates the Login credentials provided by users and returns
     * an User object if successful. Otherwise, it returns null.</p>
     *
     * @param email String with the user's email
     * @param password char[] with the user's password
     * @return User object with its complete information or null.
     */
    public User validateLogin(String email, char[] password) {
        User user = da.getUser(email);

        if (user != null) {
            String userPasswordHashInDatabase = user.getPasswordHash();
            BCrypt.Result result = BCrypt.verifyer().verify(password, userPasswordHashInDatabase);
            if (result.verified) {
                return user;
            }
        }
        return null;
    }

    /**
     * <p>
     * This method gets a list of attempts pending of a review.</p>
     *
     * @return ArrayList of Attempt objects to be displayed to the instructor.
     */
    public ArrayList<Attempt> getAttemptsPendingReview() {
        return da.getAttemptsPendingReview();
    }

    /**
     * <p>
     * This method gets a list of all users.</p>
     *
     * @return ArrayList of normal users (not instructors) in the app.
     */
    public ArrayList<User> getAllNormalUsers() {
        return da.getAllNormalUsers();
    }

    /**
     * <p>
     * This method gets a list of all the attempts for a specific user.</p>
     *
     * @param user User from which we want to get all his/her attempts.
     * @return ArrayList of attempts for a certain user.
     */
    public ArrayList<Attempt> getAttemptsPerUser(User user) {
        return da.getAttemptsPerUser(user);
    }

    /**
     * <p>
     * This method gets a specific review by its attempt id.</p>
     *
     * @param idAttempt Identification of an attempt.
     * @return Review result from the query.
     */
    public Review getReviewByAttempt(int idAttempt) {
        return da.getReviewByAttempt(idAttempt);
    }

    /**
     * <p>
     * This method calls the DataAccess class to update a review.</p>
     *
     * @param review Item to be updated.
     */
    public void updateReview(Review review) {
        da.updateReview(review);
    }

    /**
     * <p>
     * This method calls the DataAccess class to insert a new review in the
     * Database.</p>
     *
     * @param review Item to be inserted.
     */
    public void insertReview(Review review) {
        da.insertReview(review);
    }

    /**
     * <p>
     * This method calls the DataAccess class to delete all the reviews for a
     * specific attempt and then, deletes the attempt afterwards.</p>
     *
     * @param attempt Attempt to be deleted from the Database.
     * @return int with the number of rows deleted.
     */
    public int deleteAttempt(Attempt attempt) {
        da.deleteReviewsByAttempt(attempt);
        return da.deleteAttempt(attempt);
    }

    /**
     * <p>
     * This method gets a list of all the pending activities for a specific
     * user.</p>
     *
     * @param user User from which we want to get all his/her attempts.
     * @return ArrayList of activities for a certain user.
     */
    public ArrayList<Activity> getPendingActivitiesByUser(User user) {
        return da.getPendingActivitiesByUser(user);
    }

    /**
     * <p>
     * This method gets a list of all the activities that are pending to be
     * reviewed by the instructor for a specific user.</p>
     *
     * @param user User from which we want to get all his/her attempts.
     * @return ArrayList of activities pending to be reviewed for a certain
     * user.
     */
    public ArrayList<Activity> getPendingReviewByUser(User user) {
        return da.getPendingReviewByUser(user);
    }
}
