package projetaoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetaoo.model.Contenu;

@Repository
public interface ContenuRepository extends JpaRepository<Contenu, Long> {
    // Méthodes personnalisées pour les contenus
}
