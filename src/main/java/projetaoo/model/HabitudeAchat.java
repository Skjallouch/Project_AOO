package projetaoo.model;

import java.time.Month;
import java.util.HashMap;

public class HabitudeAchat {
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