package projetaoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetaoo.model.Contenu;
import projetaoo.repository.ContenuRepository;

import java.util.List;

@Service
public class ContenuService {

    @Autowired
    private ContenuRepository contenuRepository;

    public List<Contenu> findAll() {
        // Cette méthode suppose que vous avez une entité et un repository génériques pour tous les contenus.
        // Adaptez la logique selon la structure exacte de votre modèle.
        return contenuRepository.findAll();
    }
    
    // Méthodes supplémentaires pour gérer les contenus
}
