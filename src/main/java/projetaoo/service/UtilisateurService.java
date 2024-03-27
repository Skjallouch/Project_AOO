package projetaoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetaoo.model.Utilisateur;
import projetaoo.repository.UtilisateurRepository;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }
    
    // Ajoutez d'autres méthodes selon vos besoins, par exemple pour ajouter, supprimer ou mettre à jour des utilisateurs
}
