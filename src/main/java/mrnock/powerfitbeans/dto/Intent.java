/*
 */
package mrnock.powerfitbeans.dto;

/**
 *
 * @author SilviaRichard
 */
public class Intent {
    private int Id;
    private int IdUsuari;
    private int IdExercici;
    private String nomUsuari;
    private String nomExercici;
    private String Timestamp_Inici;
    private String Timestamp_Fi;
    private String Videofile;
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdUsuari() {
        return IdUsuari;
    }

    public void setIdUsuari(int IdUsuari) {
        this.IdUsuari = IdUsuari;
    }

    public int getIdExercici() {
        return IdExercici;
    }

    public void setIdExercici(int IdExercici) {
        this.IdExercici = IdExercici;
    }

    public String getTimestamp_Inici() {
        return Timestamp_Inici;
    }

    public void setTimestamp_Inici(String Timestamp_Inici) {
        this.Timestamp_Inici = Timestamp_Inici;
    }

    public String getTimestamp_Fi() {
        return Timestamp_Fi;
    }

    public void setTimestamp_Fi(String Timestamp_Fi) {
        this.Timestamp_Fi = Timestamp_Fi;
    }

    public String getVideofile() {
        return Videofile;
    }

    public void setVideofile(String Videofile) {
        this.Videofile = Videofile;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getNomExercici() {
        return nomExercici;
    }

    public void setNomExercici(String nomExercici) {
        this.nomExercici = nomExercici;
    }

    
}
