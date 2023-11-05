/*
 */
package mrnock.powerfitbeans.dto;

/**
 *
 * @author SilviaRichard
 */
public class Review {
    private int Id;
    private int Valoracio;
    private int idIntent;
    private int idReviewer;
    private String Comentari;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getValoracio() {
        return Valoracio;
    }

    public void setValoracio(int Valoracio) {
        this.Valoracio = Valoracio;
    }

    public String getComentari() {
        return Comentari;
    }

    public void setComentari(String Comentari) {
        this.Comentari = Comentari;
    }

    public int getIdIntent() {
        return idIntent;
    }

    public void setIdIntent(int idIntent) {
        this.idIntent = idIntent;
    }

    public int getIdReviewer() {
        return idReviewer;
    }

    public void setIdReviewer(int idReviewer) {
        this.idReviewer = idReviewer;
    }
    
    
}
