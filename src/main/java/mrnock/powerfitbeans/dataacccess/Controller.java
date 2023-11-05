package mrnock.powerfitbeans.dataacccess;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.util.ArrayList;
import mrnock.powerfitbeans.MainForm;
import mrnock.powerfitbeans.dto.Intent;
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

    public boolean validateLogin(String email, char[] password) {
        Usuari user = da.getUser(email);

        if (user != null) {

            String userPasswordHashInDatabase = user.getPasswordHash();
            BCrypt.Result result = BCrypt.verifyer().verify(password, userPasswordHashInDatabase);

            return result.verified;
        }

        return false;
    }

    public ArrayList<Intent> getAttemptsPendingReview() {

        return da.getAttemptsPendingReview();
    }

}
