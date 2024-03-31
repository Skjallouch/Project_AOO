package projetaoo.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "articles")
public class Article extends Contenu {
    private String auteur;
    private String texte;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "article", orphanRemoval = true)
    private Set<Commentaire> commentaires;

    private int nombreDeLikes;
    private int nombreDeVues;

    public Article(String titre, Date datePublication, Categorie categorie, String auteur, String texte) {
        super(titre, datePublication, categorie);
        this.auteur = auteur;
        this.texte = texte;
    }

    // Constructeur par défaut nécessaire pour JPA
    public Article() {
        super();
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

    public void ajouterCommentaire(Commentaire commentaire) {
        this.commentaires.add(commentaire);
        commentaire.setArticle(this);
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
