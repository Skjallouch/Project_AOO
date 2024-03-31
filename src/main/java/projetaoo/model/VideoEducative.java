package projetaoo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "video_educative") // Nom de la table dans la base de données
public class VideoEducative extends Contenu {
    private String url;
    private int duree; // Durée en minutes

    // Constructeur par défaut nécessaire pour JPA
    public VideoEducative() {
        super();
    }

    public VideoEducative(String titre, Date datePublication, Categorie categorie, String url, int duree) {
        super(titre, datePublication, categorie);
        this.url = url;
        this.duree = duree;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

}
