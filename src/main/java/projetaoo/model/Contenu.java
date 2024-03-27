package projetaoo.model;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
public abstract class Contenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id; // Ajout d'un identifiant

    protected String titre;
    protected Date datePublication;

    @Enumerated(EnumType.STRING)
    protected Categorie categorie;

    @ElementCollection
    protected Set<String> tags;

    public Contenu(String titre, Date datePublication, Categorie categorie) {
        this.titre = titre;
        this.datePublication = datePublication;
        this.categorie = categorie;
        this.tags = new HashSet<>();

    }

    public Contenu() {
        // Constructeur sans argument requis par Hibernate
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void ajouterTag(String tag) {
        this.tags.add(tag);
    }

    public void retirerTag(String tag) {
        this.tags.remove(tag);
    }

    public Set<String> getTags() {
        return tags;
    }

}
