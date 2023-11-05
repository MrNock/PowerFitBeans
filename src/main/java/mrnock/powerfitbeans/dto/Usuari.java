package mrnock.powerfitbeans.dto;

/**
 *
 * @author Richard
 */
public class Usuari {
    private int Id;
    private String NomUsuari;
    private String Email;
    private String PasswordHash;
    private byte[] Foto;
    private boolean Instructor;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNomUsuari() {
        return NomUsuari;
    }

    public void setNomUsuari(String NomUsuari) {
        this.NomUsuari = NomUsuari;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(String PasswordHash) {
        this.PasswordHash = PasswordHash;
    }

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] Foto) {
        this.Foto = Foto;
    }

    public boolean getInstructor() {
        return Instructor;
    }

    public void setInstructor(boolean Instructor) {
        this.Instructor = Instructor;
    }

    @Override
    public String toString() {
        return "Id: " + Id + " | Nombre: " + NomUsuari + " | Email: " + Email + " | PasswordHash: "
                + PasswordHash.substring(0, 5) + " | Instructor: " + Instructor +"\n";
    }
    
    
    
}
