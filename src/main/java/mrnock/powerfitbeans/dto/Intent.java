/*
 */
package mrnock.powerfitbeans.dto;

/**
 *
 * @author SilviaRichard
 */
public class Intent {

    private int id;
    private int idUsuari;
    private int idExercici;
    private String nomUsuari;
    private String nomExercici;
    private String timestamp_Inici;
    private String timestamp_Fi;
    private String videoFile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }

    public int getIdExercici() {
        return idExercici;
    }

    public void setIdExercici(int idExercici) {
        this.idExercici = idExercici;
    }

    public String getTimestamp_Inici() {
        return timestamp_Inici;
    }

    public void setTimestamp_Inici(String timestamp_Inici) {
        this.timestamp_Inici = timestamp_Inici;
    }

    public String getTimestamp_Fi() {
        return timestamp_Fi;
    }

    public void setTimestamp_Fi(String timestamp_Fi) {
        this.timestamp_Fi = timestamp_Fi;
    }

    public String getVideoFile() {
        return videoFile;
    }

    public void setVideoFile(String videoFile) {
        this.videoFile = videoFile;
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
