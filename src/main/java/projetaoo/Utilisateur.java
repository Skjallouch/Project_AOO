package projetaoo;

import java.time.Month;
import java.util.Date;
import java.util.HashMap;

import projetaoo.MoyenTransport.nomMoyenTransport;

public class Utilisateur {
    private String nom;
    private HashMap<Date, Integer> nombrePas;
    private String typeAlimentation;
    private int age;
    private String paysResidence;
    private HashMap<Month, Float> consoEnergie; // par exemple il va dire qu'il a consommé ... kw en janvier 2021, etc.
    private HashMap<Month, Float> consoEau;
    // private HashMap<MoyenTransport, Integer> minutesMoyenTransport; 
    private HashMap<MoyenTransport.nomMoyenTransport, Integer> minutesMoyenTransport; // par mois, il faut qu'on sauvegarde les données dès le début
    private HashMap<Month, Float> quantiteDechets; // en kilos, par mois, le compteur va se reinitialiser au début de chaque mois
    private HabitudeAchat habitudeAchat;
    // HabitudeAchat nécéssaire pour la méthode calculerEmpreinteAchats de la classe CalculateurEmpreinte

    public HabitudeAchat getHabitudeAchat() {
        return habitudeAchat;
    }

    public void setHabitudeAchat(HabitudeAchat habitudeAchat) {
        this.habitudeAchat = habitudeAchat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public HashMap<Date, Integer> getNombrePas() {
        return nombrePas;
    }

    public void setNombrePas(HashMap<Date, Integer> nombrePas) {
        this.nombrePas = nombrePas;
    }

    public String getTypeAlimentation() {
        return typeAlimentation;
    }

    public void setTypeAlimentation(String typeAlimentation) {
        this.typeAlimentation = typeAlimentation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPaysResidence() {
        return paysResidence;
    }

    public void setPaysResidence(String paysResidence) {
        this.paysResidence = paysResidence;
    }

    public HashMap<Month, Float> getConsoEnergie() {
        return consoEnergie;
    }

    public void initConsoEnergie (Month mois) {
        this.consoEnergie.put(mois, Float.valueOf(0));
    }

    public void addConsoEnergie(Month mois, Float quantite) {
        if (this.consoEnergie.containsKey(mois)) {
            this.consoEnergie.put(mois, this.consoEnergie.get(mois) + quantite);
        } else {
            this.consoEnergie.put(mois, quantite);
        }
    }

    public HashMap<Month, Float> getConsoEau() {
        return consoEau;
    }

    public void initConsoEau (Month mois) {
        this.consoEau.put(mois, Float.valueOf(0));
    }

    public void addConsoEau(Month mois, Float quantite) {
        if (this.consoEau.containsKey(mois)) {
            this.consoEau.put(mois, this.consoEau.get(mois) + quantite);
        } else {
            this.consoEau.put(mois, quantite);
        }
    }

    public HashMap<MoyenTransport.nomMoyenTransport, Integer> getMinutesMoyenTransport() {
        return minutesMoyenTransport;
    }
    
    public void initMinutesTransport (MoyenTransport.nomMoyenTransport moyen) {
        this.minutesMoyenTransport.put(moyen, Integer.valueOf(0));
    }

    public void addConsoEau(nomMoyenTransport moyen, Integer nbMinutes) {
        if (this.minutesMoyenTransport.containsKey(moyen)) {
            this.minutesMoyenTransport.put(moyen, this.minutesMoyenTransport.get(moyen) + nbMinutes);
        } else {
            this.minutesMoyenTransport.put(moyen, nbMinutes);
        }
    }

    public HashMap<Month, Float> getQuantiteDechets() {
        return quantiteDechets;
    }

    public void initQuantiteDechets (Month mois) {
        this.quantiteDechets.put(mois, Float.valueOf(0));
    }

    public void addQuantiteDechets(Month mois, Float quantite) {
        if (this.quantiteDechets.containsKey(mois)) {
            this.quantiteDechets.put(mois, this.quantiteDechets.get(mois) + quantite);
        } else {
            this.quantiteDechets.put(mois, quantite);
        }
    }

}
