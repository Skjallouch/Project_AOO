package projetaoo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenu;

    @ManyToOne
    private Article article;

    

    // Constructeur par défaut requis par JPA
    public Commentaire() {
    }

    // Constructeur avec paramètres
    public Commentaire(String contenu, Article article) {
        this.contenu = contenu;
        this.article = article;
    }

    // Getter et Setter pour l'ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter et Setter pour le texte du commentaire
    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    // Méthode toString pour afficher les informations du commentaire
    @Override
    public String toString() {
        return "Commentaire{" +
                "id=" + id +
                ", texte='" + contenu + '\'' +
                '}';
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
