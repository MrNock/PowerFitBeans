/*
 */
package mrnock.powerfitbeans.dto;

/**
 *
 * @author SilviaRichard
 */
public class Review {

    private int id;
    private int valoracio;
    private int idIntent;
    private int idReviewer;
    private String comentari;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValoracio() {
        return valoracio;
    }

    public void setValoracio(int valoracio) {
        this.valoracio = valoracio;
    }

    public String getComentari() {
        return comentari;
    }

    public void setComentari(String comentari) {
        this.comentari = comentari;
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
