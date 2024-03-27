package projetaoo.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Article extends Contenu {
    private String auteur;
    private String texte;
    private List<String> commentaires;
    private int nombreDeLikes;
    private int nombreDeVues;

    public Article(String titre, Date datePublication, Categorie categorie, String auteur, String texte) {
        super(titre, datePublication, categorie);
        this.auteur = auteur;
        this.texte = texte;
        this.commentaires = new ArrayList<>();
    }


    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void ajouterCommentaire(String commentaire) {
        this.commentaires.add(commentaire);
    }
    
    public List<String> getCommentaires() {
        return new ArrayList<>(commentaires); // Retourne une copie pour éviter la modification externe
    }

    public void ajouterLike() {
        this.nombreDeLikes++;
    }

    public int getNombreDeLikes() {
        return nombreDeLikes;
    }

    public void incrementerVues() {
        this.nombreDeVues++;
    }
    
    public int getNombreDeVues() {
        return nombreDeVues;
    }

}
