package projetaoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetaoo.model.HabitudeAchat;

@Repository
public interface HabitudeAchatRepository extends JpaRepository<HabitudeAchat, Long> {
    // Méthodes personnalisées pour les habitudes d'achat
}
