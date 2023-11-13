package mrnock.powerfitbeans.dataacccess;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.util.ArrayList;
import mrnock.powerfitbeans.MainForm;
import mrnock.powerfitbeans.dto.Attempt;
import mrnock.powerfitbeans.dto.Review;
import mrnock.powerfitbeans.dto.User;

/**
 * This Controller class is instantiated by the MainForm and it is used as an
 * abstraction level between the DataAccess class (query to DataBase) and
 * MainForm (dealing with the rest of windows in the app.
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 2.0 Final version to submit for Unit 1 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class Controller {

    MainForm main = null;
    DataAccess da = null;

    public Controller(MainForm main) {
        this.main = main;
        da = new DataAccess();
    }

    /**
     * This method validates the Login credentials provided by users and returns
     * an User object if successful. Otherwise, it returns null.
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
     * This method gets a list of attempts pending of a review.
     *
     * @return ArrayList of Attempt objects to be displayed to the instructor.
     */
    public ArrayList<Attempt> getAttemptsPendingReview() {
        return da.getAttemptsPendingReview();
    }

    /**
     * This method gets a list of all users.
     *
     * @return ArrayList of users in the app.
     */
    public ArrayList<User> getAllUsers() {
        return da.getAllUsers();
    }

    /**
     * This method gets a list of all the attempts for a specific user.
     *
     * @param user User from which we want to get all his/her attempts.
     * @return ArrayList of attempts for a certain user.
     */
    public ArrayList<Attempt> getAttemptsPerUser(User user) {
        return da.getAttemptsPerUser(user);
    }

    /**
     * This method gets a specific review by its attempt id.
     *
     * @param idAttempt Identification of an attempt.
     * @return Review result from the query.
     */
    public Review getReviewByAttempt(int idAttempt) {
        return da.getReviewByAttempt(idAttempt);
    }

    /**
     * This method calls the DataAccess class to update a review.
     *
     * @param review Item to be updated.
     */
    public void updateReview(Review review) {
        da.updateReview(review);
    }

    /**
     * This method calls the DataAccess class to insert a new review in the
     * Database.
     *
     * @param review Item to be inserted.
     */
    public void insertReview(Review review) {
        da.insertReview(review);
    }

    /**
     * This method calls the DataAccess class to delete all the reviews for a
     * specific attempt and then, deletes the attempt afterwards.
     *
     * @param attempt Attempt to be deleted from the Database.
     * @return int with the number of rows deleted.
     */
    public int deleteAttempt(Attempt attempt) {
        da.deleteReviewsByAttempt(attempt);
        return da.deleteAttempt(attempt);
    }
}
