package mrnock.powerfitbeans.dto;

/**
 *
 * @author Richard
 */
public class Usuari {

    private int id;
    private String nomUsuari;
    private String email;
    private String passwordHash;
    private byte[] foto;
    private boolean instructor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public boolean getInstructor() {
        return instructor;
    }

    public void setInstructor(boolean instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Id: " + id + " | Nombre: " + nomUsuari + " | Email: " + email + " | PasswordHash: "
                + passwordHash.substring(0, 5) + " | Instructor: " + instructor + "\n";
    }

}
