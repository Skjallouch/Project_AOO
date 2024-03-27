package projetaoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetaoo.model.VideoEducative;

@Repository
public interface VideoEducativeRepository extends JpaRepository<VideoEducative, Long> {
    // Méthodes spécifiques aux vidéos éducatives
}
