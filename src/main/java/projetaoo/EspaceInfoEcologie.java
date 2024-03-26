package projetaoo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EspaceInfoEcologie {
    private List<Contenu> contenus;

    public EspaceInfoEcologie() {
        this.contenus = new ArrayList<>();
    }

    public void ajouterContenu(Contenu contenu) {
        this.contenus.add(contenu);
    }

    public void listerTousLesContenus() {
        System.out.println("Liste de tous les contenus :");
        for (Contenu contenu : this.contenus) {
            System.out.println("- Titre: " + contenu.titre + ", Date: " + contenu.datePublication + ", Catégorie: " + contenu.categorie);
        }
    }

    public void listerContenusParCategorie(Categorie categorie) {
        System.out.println("Liste des contenus pour la catégorie " + categorie + " :");
        List<Contenu> contenusFiltres = this.contenus.stream()
                                                      .filter(contenu -> contenu.categorie == categorie)
                                                      .collect(Collectors.toList());
        
        for (Contenu contenu : contenusFiltres) {
            System.out.println("- Titre: " + contenu.titre + ", Date: " + contenu.datePublication);
        }
    }

    public void rechercherParMotCle(String motCle) {
        System.out.println("Résultats de la recherche pour : " + motCle);
        this.contenus.stream()
            .filter(contenu -> contenu.getTitre().contains(motCle) ||
                               (contenu instanceof Article && ((Article)contenu).getTexte().contains(motCle)))
            .forEach(contenu -> System.out.println("- Titre: " + contenu.getTitre() + ", Catégorie: " + contenu.getCategorie()));
    }
    
    public void listerContenusRecent() {
        System.out.println("Contenus les plus récents :");
        this.contenus.stream()
            .sorted((contenu1, contenu2) -> contenu2.getDatePublication().compareTo(contenu1.getDatePublication()))
            .forEach(contenu -> System.out.println("- Titre: " + contenu.getTitre() + ", Date: " + contenu.getDatePublication()));
    }
    
}
