package projetaoo.model;

import java.time.Month;
import java.util.HashMap;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitude_achat")

public class HabitudeAchat {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "id")
    private Utilisateur utilisateur;

    @Column(name = "nom_produit", nullable = false)
    private String nomProduit;

    @Column(nullable = false)
    private Integer quantite;

    HashMap<Month, Integer> quantiteVetementsSM;

    HashMap<Month, Integer> quantiteVetementsPM;

    HashMap<Month, Float> quantiteProduitsLocaux; // juste pour ne pas oublier l'idée

    public HashMap<Month, Integer> getQuantiteVetementsSM() {
        return quantiteVetementsSM;
    }

    public HashMap<Month, Integer> getQuantiteVetementsPM() {
        return quantiteVetementsPM;
    }

    public HashMap<Month, Float> getQuantiteProduitsLocaux() {
        return quantiteProduitsLocaux;
    }

    public void addProduitsLocaux(Month mois, Float kilosProduitsAchetes) {
        if (this.quantiteProduitsLocaux.containsKey(mois)) {
            this.quantiteProduitsLocaux.put(mois, this.quantiteProduitsLocaux.get(mois) + kilosProduitsAchetes);
        } else {
            this.quantiteProduitsLocaux.put(mois, kilosProduitsAchetes);
        }
    }

    public void addVetementsSM(Month mois, Integer quantite) {
        if (this.quantiteVetementsSM.containsKey(mois)) {
            this.quantiteVetementsSM.put(mois, this.quantiteVetementsSM.get(mois) + quantite);
        } else {
            this.quantiteVetementsSM.put(mois, quantite);
        }
    }

    public void addVetementsPM(Month mois, Integer quantite) {
        if (this.quantiteVetementsPM.containsKey(mois)) {
            this.quantiteVetementsPM.put(mois, this.quantiteVetementsPM.get(mois) + quantite);
        } else {
            this.quantiteVetementsPM.put(mois, quantite);
        }
    }

}