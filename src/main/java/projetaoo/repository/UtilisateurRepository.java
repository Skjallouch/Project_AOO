package projetaoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetaoo.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Ici, vous pouvez ajouter des méthodes personnalisées en plus de celles fournies par JpaRepository
}
