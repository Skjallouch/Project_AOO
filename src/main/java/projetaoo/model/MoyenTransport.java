package projetaoo.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class MoyenTransport {
    public enum nomMoyenTransport {

        @Enumerated(EnumType.STRING)
        VELO,

        @Enumerated(EnumType.STRING)
        TRANSPORTCOMMUN,

        @Enumerated(EnumType.STRING)
        AVION,

        @Enumerated(EnumType.STRING)
        TRAIN,

        @Enumerated(EnumType.STRING)
        BATEAU,

        @Enumerated(EnumType.STRING)
        COVOITURAGE,

        @Enumerated(EnumType.STRING)
        VOITURE,

        @Enumerated(EnumType.STRING)
        MOTO,

        @Enumerated(EnumType.STRING)
        TROTINETTE;
    }
}
