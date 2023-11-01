package mrnock.powerfitbeans.dataacccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mrnock.powerfitbeans.dto.Usuari;

/**
 *
 * @author Richard
 */
public class DataAccess {

    private Connection getConnection() {
        Connection connection = null;

        String connectionString = "jdbc:sqlserver://localhost;database=simulapdb;"
                + "user=sa;password=/Welcome02;encrypt=false;";

        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException ex) {
            System.err.println("Error de conexión: " + ex.getMessage());
        }
        return connection;
    }

    public ArrayList<Usuari> getUsuaris() {
        ArrayList<Usuari> usuaris = new ArrayList<>();
        String sql = "SELECT * FROM Usuaris";

        Connection connection = getConnection();
        try {
            PreparedStatement selectStatement = connection.prepareStatement(sql);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Usuari user = new Usuari();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                //user.setFoto(resultSet.getBytes("Foto"));
                user.setIsInstructor(resultSet.getBoolean("IsInstructor"));
                usuaris.add(user);
            }
            selectStatement.close();
            connection.close();

        } catch (SQLException ex) {
            System.err.println("Error de conexión: " + ex.getMessage());
        }

        return usuaris;

    }
}
