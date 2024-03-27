package projetaoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import projetaoo.model.Utilisateur;
import projetaoo.repository.UtilisateurRepository;

import java.util.List;

@Service
public class UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    @SuppressWarnings("null")
    @Transactional
    public void save(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }
    
    // Ajoutez d'autres méthodes, par exemple pour ajouter, supprimer ou mettre à jour des utilisateurs
}
