/*package projetaoo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "moyens_transport")

public class MoyenTransport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private NomMoyenTransport nom;

    @Column(name = "empreinte_carbone_par_km", nullable = false)
    private Double empreinteCarboneParKm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NomMoyenTransport getNom() {
        return nom;
    }

    public void setNom(NomMoyenTransport nom) {
        this.nom = nom;
    }

    public double getEmpreinteCarboneParKm() {
        return empreinteCarboneParKm;
    }

    public void setEmpreinteCarboneParKm(double empreinteCarboneParKm) {
        this.empreinteCarboneParKm = empreinteCarboneParKm;
    }

    // Constructeur par défaut
    public MoyenTransport() {
    }

    // Constructeur avec tous les paramètres
    public MoyenTransport(NomMoyenTransport nom, double empreinteCarboneParKm) {
        this.nom = nom;
        this.empreinteCarboneParKm = empreinteCarboneParKm;
    }

    public static enum NomMoyenTransport {
        VELO, TRANSPORTCOMMUN, AVION, TRAIN, BATEAU, COVOITURAGE, VOITURE, MOTO, TROTINETTE
    }

    public class nomMoyenTransport {
    }
}

*/

package projetaoo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "moyens_transport")
public class MoyenTransport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private NomMoyenTransport nom;

    @Column(name = "empreinte_carbone_par_km", nullable = false)
    private Double empreinteCarboneParKm; // Utilisez Double pour permettre null

    // Constructeur par défaut
    public MoyenTransport() {
    }

    // Constructeur avec tous les paramètres
    public MoyenTransport(NomMoyenTransport nom, Double empreinteCarboneParKm) {
        this.nom = nom;
        this.empreinteCarboneParKm = empreinteCarboneParKm;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NomMoyenTransport getNom() {
        return nom;
    }

    public void setNom(NomMoyenTransport nom) {
        this.nom = nom;
    }

    public Double getEmpreinteCarboneParKm() {
        return empreinteCarboneParKm;
    }

    public void setEmpreinteCarboneParKm(Double empreinteCarboneParKm) {
        this.empreinteCarboneParKm = empreinteCarboneParKm;
    }

    // Énumération pour les noms des moyens de transport
    public enum NomMoyenTransport {
        VELO, TRANSPORT_COMMUN, AVION, TRAIN, BATEAU, COVOITURAGE, VOITURE, MOTO, TROTINETTE
    }
}
