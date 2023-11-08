package mrnock.powerfitbeans.dataacccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mrnock.powerfitbeans.dto.Usuari;
import mrnock.powerfitbeans.dto.Intent;
import mrnock.powerfitbeans.dto.Review;

/**
 *
 * @author Richard
 */
public class DataAccess {

    private Connection getConnection() {
        Connection connection = null;

        String connectionUrl = "jdbc:sqlserver://localhost;database=simulapdb;"
                + "user=sa;password=/Welcome02;encrypt=false;";

        try {
            connection = DriverManager.getConnection(connectionUrl);
        } catch (SQLException ex) {
            System.err.println("Error de conexión: " + ex.getMessage());
        }
        return connection;
    }

    public Usuari getUser(String email) {
        Usuari user = null;
        String sql = "SELECT * FROM Usuaris WHERE Email = ?";
        try (Connection con = getConnection(); PreparedStatement selectStatement = con.prepareStatement(sql);) {
            selectStatement.setString(1, email);
            ResultSet resultSet = selectStatement.executeQuery();
            
            if (resultSet.next()) {
                user = new Usuari(); // Cuando la consulta devuelve al menos un registro, se crea un usuario
                user.setId(resultSet.getInt("Id"));
                user.setNomUsuari(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getBoolean("Instructor"));
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        return user;
    }

    public ArrayList<Usuari> getAllUsers() {
        ArrayList<Usuari> usuaris = new ArrayList<>();
        String sql = "SELECT * FROM Usuaris WHERE Instructor=0";
        try (Connection con = getConnection(); PreparedStatement selectStatement = con.prepareStatement(sql);) {

            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Usuari user = new Usuari();
                user.setId(resultSet.getInt("Id"));
                user.setNomUsuari(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getBoolean("Instructor"));
                usuaris.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        return usuaris;
    }

    public int registerUser(Usuari u) {
        String sql = "INSERT INTO dbo.Usuaris (Nom, Email, PasswordHash, Instructor)"
                + " VALUES (?,?,?,?)"
                + " SELECT CAST(SCOPE_IDENTITY() as int)";
        try (Connection connection = getConnection(); PreparedStatement insertStatement = connection.prepareStatement(sql)) {
            insertStatement.setString(1, u.getNomUsuari());
            insertStatement.setString(2, u.getEmail());
            insertStatement.setString(3, u.getPasswordHash());
            insertStatement.setBoolean(4, u.getInstructor());

            int newUserId = insertStatement.executeUpdate();
            return newUserId;
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        return 0;
    }

    public ArrayList<Intent> getAttemptsPendingReview() {
        ArrayList<Intent> intents = new ArrayList<>();
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
                Intent attempt = new Intent();
                attempt.setId(resultSet.getInt("Id"));
                attempt.setIdUsuari(resultSet.getInt("IdUsuari"));
                attempt.setNomUsuari(resultSet.getString("Nom"));
                attempt.setIdExercici(resultSet.getInt("IdExercici"));
                attempt.setNomExercici(resultSet.getString("NomExercici"));
                attempt.setTimestamp_Inici(resultSet.getString("Timestamp_Inici"));
                attempt.setTimestamp_Fi(resultSet.getString("Timestamp_Fi"));
                attempt.setVideoFile(resultSet.getString("VideoFile"));
                intents.add(attempt);
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        return intents;
    }

    public int insertReview(Review r) {
        int result = 0;
        String sql = "INSERT INTO dbo.Review (IdIntent, IdReviewer, Valoracio, Comentari)"
                + " VALUES (?,?,?,?)";
        try (Connection connection = getConnection(); PreparedStatement insertStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            insertStatement.setInt(1, r.getIdIntent());
            insertStatement.setInt(2, r.getIdReviewer());
            insertStatement.setInt(3, r.getValoracio());
            insertStatement.setString(4, r.getComentari());

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
            System.err.println("Error de conexión: " + e.getMessage());
        }
        return result;
    }

    /**
     * Mètode per comprovar si un intent es la repetició de un exercici
     * 'failed'. Comprova si ja existeix un intent amb el mateix IdUsuari i
     * IdExercici i la \n data es anterior a la de intent.
     *
     * @param intent El intent a comprovar
     * @return el id del intent anterior o 0 si no existeix un intent anterior.
     */
    public int getPreviousFailedAttempt(Intent intent) {
        return 0;
    }

    public ArrayList<Intent> getAttemptsPerUser(Usuari user) {
        ArrayList<Intent> intents = new ArrayList<>();
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
                Intent attempt = new Intent();
                attempt.setId(resultSet.getInt("Id"));
                attempt.setIdUsuari(resultSet.getInt("IdUsuari"));
                attempt.setNomUsuari(resultSet.getString("Nom"));
                attempt.setIdExercici(resultSet.getInt("IdExercici"));
                attempt.setNomExercici(resultSet.getString("NomExercici"));
                attempt.setTimestamp_Inici(resultSet.getString("Timestamp_Inici"));
                attempt.setTimestamp_Fi(resultSet.getString("Timestamp_Fi"));
                attempt.setVideoFile(resultSet.getString("VideoFile"));
                intents.add(attempt);
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        return intents;

    }

    public Review getAttemptReview(int idIntent) {
        Review review = null;
        String sql = "SELECT * FROM Review WHERE IdIntent = ?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, idIntent);
            ResultSet resultSet = selectStatement.executeQuery();
            review = new Review();
            while (resultSet.next()) {
                review.setId(resultSet.getInt("Id"));
                review.setIdIntent(resultSet.getInt("IdIntent"));
                review.setIdReviewer(resultSet.getInt("IdReviewer"));
                review.setValoracio(resultSet.getInt("Valoracio"));
                review.setComentari(resultSet.getString("Comentari"));
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        return review;
    }

    public int updateReview(Review r) {
        int result = 0;
        String sql = "UPDATE Review SET Valoracio=?, Comentari=? WHERE Id=?";
        try (Connection conn = getConnection(); PreparedStatement updateStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            updateStatement.setInt(3, r.getId());
            updateStatement.setInt(1, r.getValoracio());
            updateStatement.setString(2, r.getComentari());

            result = updateStatement.executeUpdate();
            if (result == 0) {
                throw new SQLException("Updating review failed, no rows affected.");
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        return result;
    }
    
}
