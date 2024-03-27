package projetaoo.model;


import java.time.Month;
import java.util.HashMap;
import java.util.Map;


public class CalculateurEmpreinte {

    private static final float FACTEUR_EMISSION_ELECTRICITE = 0.233f; // kg CO2 par kWh
    private static final float FACTEUR_EMISSION_VETEMENTS_SM = 2.0f; // kg CO2 par vêtement seconde main
    private static final float FACTEUR_EMISSION_VETEMENTS_PM = 5.0f; // kg CO2 par vêtement produit $
    private static final float FACTEUR_EMISSION_PRODUITS_LOCAUX = 0.1f; // kg CO2 par kilo

    private CalculateurEmpreinte() {
        // Constructeur privé pour empêcher l'instanciation de la classe
    }

    public static float calculerEmpreinteEnergie(HashMap<Month, Float> consoEnergie) {
        float empreinteTotale = 0;
        for (Float conso : consoEnergie.values()) {
            empreinteTotale += conso * FACTEUR_EMISSION_ELECTRICITE;
        }
        return empreinteTotale; // return en kg CO2
    }

    public static float calculerEmpreinteTransport(HashMap<MoyenTransport.nomMoyenTransport, Integer> minutesMoyenTransport) {
        float empreinteTransport = 0;
        Map<MoyenTransport.nomMoyenTransport, Float> facteursEmission = new HashMap<>();
    
        // facteurs d'émission pour chq moyen de transport
        facteursEmission.put(MoyenTransport.nomMoyenTransport.VELO, 0.05f); 
        facteursEmission.put(MoyenTransport.nomMoyenTransport.TRANSPORTCOMMUN, 0.06f); 
        facteursEmission.put(MoyenTransport.nomMoyenTransport.AVION, 0.25f); 
        facteursEmission.put(MoyenTransport.nomMoyenTransport.TRAIN, 0.07f); 
        facteursEmission.put(MoyenTransport.nomMoyenTransport.BATEAU, 0.18f);
        facteursEmission.put(MoyenTransport.nomMoyenTransport.COVOITURAGE, 0.08f); 
        facteursEmission.put(MoyenTransport.nomMoyenTransport.VOITURE, 0.21f); 
        facteursEmission.put(MoyenTransport.nomMoyenTransport.MOTO, 0.15f); 
        facteursEmission.put(MoyenTransport.nomMoyenTransport.TROTINETTE, 0.04f); 
    
        // calcul de l'empreinte transport pour chq moyen de transport
        for (Map.Entry<MoyenTransport.nomMoyenTransport, Integer> entry : minutesMoyenTransport.entrySet()) {
            Float facteur = facteursEmission.get(entry.getKey());
            if (facteur != null) {
                empreinteTransport += entry.getValue() * facteur;
            }
        }
        return empreinteTransport;
    }
    
    public static float calculerEmpreinteProduitsLocaux(HashMap<Month, Float> quantiteProduitsLocaux) {
        float empreinte = 0;
        for (Float quantite : quantiteProduitsLocaux.values()) {
            empreinte += quantite * FACTEUR_EMISSION_PRODUITS_LOCAUX;
        }
        return empreinte; // pour retouner l'empreinte carbone totale en kg CO2 pour les produits locaux
    }

    public static float calculerEmpreinteAchats(HabitudeAchat habitudeAchat) {
    float empreinteVetements = calculerEmpreinteVetements(habitudeAchat.getQuantiteVetementsSM(), habitudeAchat.getQuantiteVetementsPM());
    float empreinteProduitsLocaux = calculerEmpreinteProduitsLocaux(habitudeAchat.getQuantiteProduitsLocaux());
    return empreinteVetements + empreinteProduitsLocaux;
}

    public static float calculerEmpreinteTotale(Utilisateur utilisateur) {
        float empreinteEnergie = calculerEmpreinteEnergie(utilisateur.getConsoEnergie());
        float empreinteAchats = calculerEmpreinteAchats(utilisateur.getHabitudeAchat());
        float empreinteTransport = calculerEmpreinteTransport(utilisateur.getMinutesMoyenTransport());
        return empreinteEnergie + empreinteAchats + empreinteTransport;
    }

    public static String suggererReductions(float empreinteTotale) {
        return "Suggestions pour réduire votre empreinte carbone...";
    }

    public static float calculerEmpreinteVetements(HashMap<Month, Integer> quantiteVetementsSM, HashMap<Month, Integer> quantiteVetementsPM) {
        float empreinte = 0;
        for (Integer quantite : quantiteVetementsSM.values()) {
            empreinte += quantite * FACTEUR_EMISSION_VETEMENTS_SM;
        }
        for (Integer quantite : quantiteVetementsPM.values()) {
            empreinte += quantite * FACTEUR_EMISSION_VETEMENTS_PM;
        }
        return empreinte; // pour retourner l'empreinte carbone totale en kg CO2 pour les vêtements
    }

}



