package projetaoo;

import java.time.Month;
import java.util.Date;
import java.util.HashMap;

public class Utilisateur {
    String nom;
    HashMap <Date, Integer> nombrePas;
    String typeAlimentation;
    int age;
    String paysResidence;
    HashMap <Month, Float> consoEnergie; // par exemple il va dire qu'il a consommé ... kw en janvier 2021, etc.
    HashMap <Month, Float> consoEau;
    HashMap <MoyenTransport, Integer> minutesMoyenTransport; // par mois, il faut qu'on sauvegarde les données dès le début
    HashMap <Month, Float> quantiteDechets; // en kilos, par mois, le compteur va se reinitialiser au début de chaque mois
    HashMap <Month, Float> quantiteVetementsSM;
    HashMap <Month, Float> quantiteVetementsPM;
    HashMap <Month, Float> quantiteProduitsLocaux; // juste pour ne pas oublier l'idée

    // créer une classe HabitudeAchat avec un attribut personne de type Utilisateur et y mettre tout ce qui concerne l'achat
}


// test git