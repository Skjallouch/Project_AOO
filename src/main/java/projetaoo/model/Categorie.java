package projetaoo.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum Categorie {
    
    @Enumerated(EnumType.STRING)
    CHANGEMENTS_CLIMATIQUES,

    @Enumerated(EnumType.STRING)
    CONSERVATION,

    @Enumerated(EnumType.STRING)
    ENERGIE_RENOUVELABLE;
}
