package mrnock.powerfitbeans.dto;

/**
 *
 * @author Richard
 */
public class Usuari {
    private int Id;
    private String Nom;
    private String Email;
    private String PasswordHash;
    private byte[] Foto;
    private boolean IsInstructor;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
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

    public boolean getIsInstructor() {
        return IsInstructor;
    }

    public void setIsInstructor(boolean IsInstructor) {
        this.IsInstructor = IsInstructor;
    }

    @Override
    public String toString() {
        return "Id: " + Id + " | Nombre: " + Nom + " | Email: " + Email + " | PasswordHash: "
                + PasswordHash.substring(0, 5) + " | IsInstructor: " + IsInstructor +"\n";
    }
    
    
    
}
