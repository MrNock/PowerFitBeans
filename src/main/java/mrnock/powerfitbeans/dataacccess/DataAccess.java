package mrnock.powerfitbeans.dataacccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import mrnock.powerfitbeans.dto.Activity;
import mrnock.powerfitbeans.dto.User;
import mrnock.powerfitbeans.dto.Attempt;
import mrnock.powerfitbeans.dto.Review;

/**
 * <p>
 * This DataAccess class is instantiated by the Controller and its in charge of
 * dealing with the Database. It has been encapsulated to add extra security,
 * avoiding unwanted external access.</p>
 *
 * <p>
 * It performs the connection and all CRUD methods needed in the app.</p>
 *
 * @author Richard Navarro {@literal <richardnavarro@paucasesnovescifp.cat>}
 * @version 6.0 Final version to submit for Unit 6 (Desarrollo de Interfaces)
 * @since 1.5
 */
public class DataAccess {

    /**
     * <p>
     * This method connects with the Database with the personal connection
     * URL.</p>
     *
     * @return Connection object or null on failure.
     */
    private Connection getConnection() {
        Connection connection = null;

        /*
    ****************************************************************************************************
    *********************** COMMENT / UNCOMMENT WHEN DEVELOPING (Test with localhost) ******************
    ****************************************************************************************************
    
         final String CONNECTION_URL = "jdbc:sqlserver://localhost;database=simulapdb;"
                + "user=sa;password=/Welcome02;encrypt=false;";
    
    ****************************************************************************************************
    ****************************************************************************************************
         */
        final String CONNECTION_URL = "jdbc:sqlserver://simulapsqlserver.database.windows.net:1433;"
                + "database=simulapdb;user=simulapdbadmin@simulapsqlserver;password=Pwd1234.;"
                + "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

        try {
            connection = DriverManager.getConnection(CONNECTION_URL);
        } catch (SQLException ex) {
            System.err.println("Connection error: " + ex.getMessage());
        }
        return connection;
    }

    /**
     * <p>
     * This method gets a user by its email address.</p>
     *
     * @param email String with the email to look up in the Database.
     * @return User object with the same email received by parameter.
     */
    public User getUser(String email) {
        User user = null;
        String sql = "SELECT * FROM Usuaris WHERE Email = ?";
        try (Connection con = getConnection(); PreparedStatement selectStatement = con.prepareStatement(sql);) {
            selectStatement.setString(1, email);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("Id"));
                user.setUserName(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getInt("Instructor") == 1);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return user;
    }

    /**
     * <p>
     * This method gets an ArrayList of users from the Database.</p>
     *
     * @return ArrayList of normal users (not instructors).
     */
    public ArrayList<User> getAllNormalUsers() {
        ArrayList<User> usuaris = new ArrayList<>();
        String sql = "SELECT * FROM Usuaris WHERE Instructor=0";
        try (Connection con = getConnection(); PreparedStatement selectStatement = con.prepareStatement(sql);) {

            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("Id"));
                user.setUserName(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getInt("Instructor") == 1);
                usuaris.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return usuaris;
    }

    /**
     * <p>
     * This method adds a new user in the Database.</p>
     *
     * @param user with all the details to be inserted in the Database.
     * @return int with the number of rows affected.
     */
    public int registerUser(User user) {
        String sql = "INSERT INTO dbo.Usuaris (Nom, Email, PasswordHash, Instructor)"
                + " VALUES (?,?,?,?)"
                + " SELECT CAST(SCOPE_IDENTITY() as int)";
        try (Connection connection = getConnection(); PreparedStatement insertStatement = connection.prepareStatement(sql)) {
            insertStatement.setString(1, user.getUserName());
            insertStatement.setString(2, user.getEmail());
            insertStatement.setString(3, user.getPasswordHash());
            insertStatement.setBoolean(4, user.isInstructor());

            int newUserId = insertStatement.executeUpdate();
            return newUserId;
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return 0;
    }

    /**
     * <p>
     * This method gets a list of attempts where the instructor is pending to
     * give a review.</p>
     *
     * @return ArrayList of attempts pending of review.
     */
    public ArrayList<Attempt> getAttemptsPendingReview() {
        ArrayList<Attempt> attempts = new ArrayList<>();
        String sql = "SELECT Intents.Id, Intents.IdUsuari, Usuaris.Nom,"
                + " Intents.IdExercici, Exercicis.NomExercici, Timestamp_Inici,"
                + " Timestamp_Fi, VideoFile"
                + " FROM Intents INNER JOIN Usuaris ON Intents.IdUsuari=Usuaris.Id"
                + " INNER JOIN Exercicis ON Intents.IdExercici=Exercicis.Id"
                + " WHERE Intents.Id NOT IN"
                + " (SELECT IdIntent FROM Review)"
                + " ORDER BY Timestamp_Inici";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {

            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Attempt attempt = new Attempt();
                attempt.setId(resultSet.getInt("Id"));
                attempt.setIdUser(resultSet.getInt("IdUsuari"));
                attempt.setUserName(resultSet.getString("Nom"));
                attempt.setIdExercise(resultSet.getInt("IdExercici"));
                attempt.setExerciseName(resultSet.getString("NomExercici"));
                attempt.setTimestampStart(resultSet.getString("Timestamp_Inici"));
                attempt.setTimestartEnd(resultSet.getString("Timestamp_Fi"));
                attempt.setVideoFile(resultSet.getString("VideoFile"));
                attempts.add(attempt);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return attempts;
    }

    /**
     * <p>
     * This method gets a list of activities pending filtered by user.</p>
     *
     * @param user User from whom the app needs to return his/her pending
     * activities.
     * @return ArrayList of activities for a specific user.
     */
    public ArrayList<Activity> getPendingActivitiesByUser(User user) {
        ArrayList<Activity> activities = new ArrayList<>();
        String sql = "select NomExercici from Exercicis where id not in "
                + "( select Exercicis.id from Usuaris full join Intents "
                + "on Intents.IdUsuari = Usuaris.Id full join  Exercicis "
                + "on Exercicis.id = Intents.IdExercici full join Review "
                + "on Review.IdIntent = Intents.id where Usuaris.Id = ?)";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {

            selectStatement.setInt(1, user.getId());
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Activity activity = new Activity();
                activity.setExerciseName(resultSet.getString("NomExercici"));
                activities.add(activity);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return activities;
    }

    /**
     * <p>
     * This method gets a list of activities pending to be reviewed for a
     * specific user.</p>
     *
     * @param user User from whom the app needs to return his/her pending
     * activities.
     * @return ArrayList of activities that remain pending to be reviewed for a
     * specific user.
     */
    public ArrayList<Activity> getPendingReviewByUser(User user) {

        ArrayList<Activity> activities = new ArrayList<>();
        String sql = "select NomExercici,Usuaris.Nom,Timestamp_Inici,Review.Id"
                + " as reviewId, Intents.Videofile as videofile from Usuaris"
                + " full join Intents on Intents.IdUsuari = Usuaris.Id full join"
                + " Exercicis on Exercicis.id = Intents.IdExercici full join"
                + " Review on Review.IdIntent = Intents.id where Usuaris.Id = ?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {

            selectStatement.setInt(1, user.getId());
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Activity activity = new Activity();
                activity.setExerciseName(resultSet.getString("NomExercici"));
                Timestamp fecha = resultSet.getTimestamp("Timestamp_Inici");
                if (fecha != null) {
                    Date d = new Date();
                    d.setTime(fecha.getTime());
                    activity.setTimeStamp(d);
                }

                activity.setIdReview(resultSet.getInt("reviewId"));
                activity.setVideofile(resultSet.getString("videofile"));
                activities.add(activity);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return activities;
    }

    /**
     * <p>
     * This method adds a new review in the Database.</p>
     *
     * @param review Review object to be inserted in the Database.
     * @return int number of new rows added.
     */
    public int insertReview(Review review) {
        int result = 0;
        String sql = "INSERT INTO dbo.Review (IdIntent, IdReviewer, Valoracio, Comentari)"
                + " VALUES (?,?,?,?)";
        try (Connection connection = getConnection(); PreparedStatement insertStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            insertStatement.setInt(1, review.getIdAttempt());
            insertStatement.setInt(2, review.getIdReviewer());
            insertStatement.setInt(3, review.getScore());
            insertStatement.setString(4, review.getComment());

            result = insertStatement.executeUpdate();
            if (result == 0) {
                throw new SQLException("Creating review failed, no rows affected.");
            }

            try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    Long longResult = generatedKeys.getLong(1);
                    result = longResult.intValue();
                } else {
                    throw new SQLException("Creating review failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return result;
    }

    /**
     * <p>
     * This method checks if an attempts is a repetition of a former failed
     * exercise. It validates if there is an attempt with the same idUser and
     * idAttempt where its performance date is previous from the attempt
     * date.</p>
     *
     * @param attempt Attempt to be checked.
     * @return int with the former idAttempt or 0 if no previous attempt has
     * been found.
     */
    public int getPreviousFailedAttempt(Attempt attempt) {
        return 0;
    }

    /**
     * <p>
     * This method gets all the attempts for a certain user.</p>
     *
     * @param user User to get all its attempts from the Database.
     * @return ArrayList of attempts for the specific user.
     */
    public ArrayList<Attempt> getAttemptsPerUser(User user) {
        ArrayList<Attempt> attempts = new ArrayList<>();
        String sql = "SELECT Intents.Id, Intents.IdUsuari, Usuaris.Nom,"
                + " Intents.IdExercici, Exercicis.NomExercici, Timestamp_Inici,"
                + " Timestamp_Fi, VideoFile"
                + " FROM Intents INNER JOIN Usuaris ON Intents.IdUsuari=Usuaris.Id"
                + " INNER JOIN Exercicis ON Intents.IdExercici=Exercicis.Id"
                + " WHERE Intents.IdUsuari=?"
                + " ORDER BY Intents.IdExercici";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, user.getId());
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Attempt attempt = new Attempt();
                attempt.setId(resultSet.getInt("Id"));
                attempt.setIdUser(resultSet.getInt("IdUsuari"));
                attempt.setUserName(resultSet.getString("Nom"));
                attempt.setIdExercise(resultSet.getInt("IdExercici"));
                attempt.setExerciseName(resultSet.getString("NomExercici"));
                attempt.setTimestampStart(resultSet.getString("Timestamp_Inici"));
                attempt.setTimestartEnd(resultSet.getString("Timestamp_Fi"));
                attempt.setVideoFile(resultSet.getString("VideoFile"));
                attempts.add(attempt);
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return attempts;

    }

    /**
     * <p>
     * This method gets the last review for a specific attempts.</p>
     *
     * @param idAttempt int with the identification of the attempt to look up in
     * the Database.
     * @return last Review for the queried attempt.
     */
    public Review getReviewByAttempt(int idAttempt) {
        Review review = null;
        String sql = "SELECT * FROM Review WHERE IdIntent = ? ORDER BY id";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, idAttempt);
            ResultSet resultSet = selectStatement.executeQuery();
            review = new Review();
            while (resultSet.next()) {
                review.setId(resultSet.getInt("Id"));
                review.setIdAttempt(resultSet.getInt("IdIntent"));
                review.setIdReviewer(resultSet.getInt("IdReviewer"));
                review.setScore(resultSet.getInt("Valoracio"));
                review.setComment(resultSet.getString("Comentari"));
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return review;
    }

    /**
     * <p>
     * This method updates a review received by parameter.</p>
     *
     * @param review with the new values to be updated in the Database.
     * @return int with the rows altered with the query.
     */
    public int updateReview(Review review) {
        int result = 0;
        String sql = "UPDATE Review SET Valoracio=?, Comentari=? WHERE Id=?";
        try (Connection conn = getConnection(); PreparedStatement updateStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            updateStatement.setInt(3, review.getId());
            updateStatement.setInt(1, review.getScore());
            updateStatement.setString(2, review.getComment());

            result = updateStatement.executeUpdate();
            if (result == 0) {
                throw new SQLException("Updating review failed, no rows affected.");
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return result;
    }

    /**
     * <p>
     * This method deletes all the reviews for a certain attempt.</p>
     *
     * @param attempt from which the reviews have to be deleted.
     * @return int with the number of rows affected with the action.
     */
    public int deleteReviewsByAttempt(Attempt attempt) {
        int result = 0;
        String sql = "DELETE from Review WHERE IdIntent=?";
        try (Connection conn = getConnection(); PreparedStatement updateStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            updateStatement.setInt(1, attempt.getId());

            result = updateStatement.executeUpdate();
            if (result == 0) {
                throw new SQLException("No reviews have been deleted.");
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return result;
    }

    /**
     * <p>
     * This method deletes an attempt in the Database.</p>
     *
     * @param attempt to be deleted.
     * @return int with the number of rows affected with the action.
     */
    public int deleteAttempt(Attempt attempt) {
        int result = 0;
        String sql = "DELETE from Intents WHERE Id=?";
        try (Connection conn = getConnection(); PreparedStatement updateStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            updateStatement.setInt(1, attempt.getId());

            result = updateStatement.executeUpdate();
            if (result == 0) {
                throw new SQLException("No attempts have been deleted.");
            }
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return result;
    }
}
