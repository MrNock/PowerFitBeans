package mrnock.powerfitbeans.dataacccess;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.util.ArrayList;
import mrnock.powerfitbeans.MainForm;
import mrnock.powerfitbeans.dto.Intent;
import mrnock.powerfitbeans.dto.Review;
import mrnock.powerfitbeans.dto.Usuari;

/**
 *
 * @author SilviaRichard
 */
public class Controller {

    MainForm main = null;
    DataAccess da = null;

    public Controller(MainForm main) {
        this.main = main;
        da = new DataAccess();

    }

    public Usuari validateLogin(String email, char[] password) {
        Usuari user = da.getUser(email);

        if (user != null) {

            String userPasswordHashInDatabase = user.getPasswordHash();
            BCrypt.Result result = BCrypt.verifyer().verify(password, userPasswordHashInDatabase);
            if (result.verified) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<Intent> getAttemptsPendingReview() {

        return da.getAttemptsPendingReview();
    }

    public ArrayList<Usuari> getAllUsers() {
        return da.getAllUsers();
    }

    public ArrayList<Intent> getAttemptsPerUser(Usuari user) {
        return da.getAttemptsPerUser(user);
    }

    public Review getAttemptReview(int idIntent) {
        return da.getAttemptReview(idIntent);
    }

    public void updateReview(Review review) {
        da.updateReview(review);
    }

    public void insertReview(Review review) {
        da.insertReview(review);
    }

    public int deleteAttempts(Intent attempt) {
        
        da.deleteReviewsByAttempt(attempt);
        return da.deleteAttempts(attempt);
    }

}
