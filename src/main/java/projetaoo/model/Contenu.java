package projetaoo.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public abstract class Contenu {
    protected String titre;
    protected Date datePublication;
    protected Categorie categorie;
    protected Set<String> tags;

    public Contenu(String titre, Date datePublication, Categorie categorie) {
        this.titre = titre;
        this.datePublication = datePublication;
        this.categorie = categorie;
        this.tags = new HashSet<>();

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
