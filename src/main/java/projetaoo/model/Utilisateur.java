package projetaoo.model;

import java.time.Month;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import projetaoo.model.MoyenTransport.NomMoyenTransport;

@Entity
@Table(name = "utilisateur")

public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    /*
     * @Column(nullable = false, unique = true)
     * private String email;
     */

    @ElementCollection
    @CollectionTable(name = "nombre_pas", joinColumns = @JoinColumn(name = "utilisateur_id"))
    @MapKeyColumn(name = "date")
    @Column(name = "nombre_pas")
    private Map<LocalDate, Integer> nombrePas = new HashMap<>();

    @Column(name = "type_alimentation")
    private String typeAlimentation;
    private int age;

    @Column(name = "pays_residence")
    private String paysResidence;

    @ElementCollection
    @CollectionTable(name = "consommation_energie", joinColumns = @JoinColumn(name = "utilisateur_id"))
    @MapKeyColumn(name = "mois")
    @Column(name = "consommation")
    private Map<Month, Float> consoEnergie = new HashMap<>(); // par exemple il va dire qu'il a consommé ... kw en
                                                              // janvier 2021, etc.

    @ElementCollection
    @CollectionTable(name = "consommation_eau", joinColumns = @JoinColumn(name = "utilisateur_id"))
    @MapKeyColumn(name = "mois")
    @Column(name = "consommation")
    private Map<LocalDate, Integer> consoEau = new HashMap<>();
    // private HashMap<MoyenTransport, Integer> minutesMoyenTransport;

    @ElementCollection
    private Map<NomMoyenTransport, Integer> minutesMoyenTransport = new HashMap<>(); // par mois, il
                                                                                     // faut qu'on
    // sauvegarde les données dès le
    // début
    @ElementCollection
    private Map<Month, Float> quantiteDechets = new HashMap<>(); // en kilos, par mois, le compteur va se
                                                                 // reinitialiser au début de
    // chaque mois

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "habitude_achat_id", referencedColumnName = "id")
    private HabitudeAchat habitudeAchat;
    // HabitudeAchat nécéssaire pour la méthode calculerEmpreinteAchats de la classe
    // CalculateurEmpreinte

    public Utilisateur() {
        this.nombrePas = new HashMap<>();
        this.consoEnergie = new HashMap<>();
        this.consoEau = new HashMap<>();
        this.minutesMoyenTransport = new HashMap<>();
        this.quantiteDechets = new HashMap<>();
    }

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

    public Map<LocalDate, Integer> getNombrePas() {
        return nombrePas;
    }

    public void setNombrePas(HashMap<LocalDate, Integer> nombrePas) {
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

    public Map<Month, Float> getConsoEnergie() {
        return consoEnergie;
    }

    public void initConsoEnergie(Month mois) {
        this.consoEnergie.put(mois, Float.valueOf(0));
    }

    public void addConsoEnergie(Month mois, Float quantite) {
        if (this.consoEnergie.containsKey(mois)) {
            this.consoEnergie.put(mois, this.consoEnergie.get(mois) + quantite);
        } else {
            this.consoEnergie.put(mois, quantite);
        }
    }

    public Map<LocalDate, Integer> getConsoEau() {
        return consoEau;
    }

    public void initConsoEau(LocalDate date) {
        this.consoEau.put(date, 0); // Initialise la consommation d'eau à 0 pour la date spécifiée
    }

    public void addConsoEau(LocalDate date, Integer quantite) {
        // Vérifie si la date existe déjà dans la map
        if (this.consoEau.containsKey(date)) {
            // Si oui, ajoute la quantité spécifiée à la valeur existante
            this.consoEau.put(date, this.consoEau.get(date) + quantite);
        } else {
            // Sinon, ajoute une nouvelle entrée avec la date et la quantité spécifiée
            this.consoEau.put(date, quantite);
        }
    }

    public Map<NomMoyenTransport, Integer> getMinutesMoyenTransport() {
        return minutesMoyenTransport;
    }

    public void initMinutesTransport(NomMoyenTransport moyen) {
        this.minutesMoyenTransport.put(moyen, Integer.valueOf(0));
    }

    public void addMinutesTransport(NomMoyenTransport moyen, Integer nbMinutes) {
        if (this.minutesMoyenTransport.containsKey(moyen)) {
            this.minutesMoyenTransport.put(moyen, this.minutesMoyenTransport.get(moyen) + nbMinutes);
        } else {
            this.minutesMoyenTransport.put(moyen, nbMinutes);
        }
    }

    public Map<Month, Float> getQuantiteDechets() {
        return quantiteDechets;
    }

    public void initQuantiteDechets(Month mois) {
        this.quantiteDechets.put(mois, Float.valueOf(0));
    }

    public void addQuantiteDechets(Month mois, Float quantite) {
        if (this.quantiteDechets.containsKey(mois)) {
            this.quantiteDechets.put(mois, this.quantiteDechets.get(mois) + quantite);
        } else {
            this.quantiteDechets.put(mois, quantite);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
