package projetaoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projetaoo.model.Utilisateur;
import projetaoo.service.UtilisateurService;
import org.springframework.ui.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@Controller
@RequestMapping("/utilisateur")

public class UtilisateurController {

    private static final Logger logger = LoggerFactory.getLogger(UtilisateurController.class);

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.findAll();
    }

    // Mappage pour afficher le formulaire
    @GetMapping("/form")
    public String showForm(Model model) {
        logger.info("Affichage du formulaire utilisateur");

        model.addAttribute("utilisateur", new Utilisateur());
        return "utilisateur-form"; // Retourne le nom de la vue utilisateur-form.html
    }

    // Mappage pour traiter le formulaire
    @ModelAttribute("utilisateur")
    @PostMapping("/processForm")
    public String processForm(Utilisateur utilisateur) {

        logger.info("Traitement du formulaire utilisateur: {}", utilisateur);

        utilisateurService.save(utilisateur); // Enregistre l'utilisateur dans la base de données
        return "utilisateur-success"; // Redirige vers la route qui montre la vue de succès
    }

    // Mappage pour afficher la page de succès
    @GetMapping("/showSuccess")
    public String showSuccess() {
        return "utilisateur-success"; // Retourne le nom de la vue utilisateur-success.html
    }

}
