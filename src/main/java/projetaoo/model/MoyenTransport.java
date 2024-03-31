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

/*
 * public enum nomMoyenTransport {
 * 
 * @Enumerated(EnumType.STRING)
 * VELO,
 * 
 * @Enumerated(EnumType.STRING)
 * TRANSPORTCOMMUN,
 * 
 * @Enumerated(EnumType.STRING)
 * AVION,
 * 
 * @Enumerated(EnumType.STRING)
 * TRAIN,
 * 
 * @Enumerated(EnumType.STRING)
 * BATEAU,
 * 
 * @Enumerated(EnumType.STRING)
 * COVOITURAGE,
 * 
 * @Enumerated(EnumType.STRING)
 * VOITURE,
 * 
 * @Enumerated(EnumType.STRING)
 * MOTO,
 * 
 * @Enumerated(EnumType.STRING)
 * TROTINETTE;
 * }
 */
