package projetaoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetaoo.model.Utilisateur;
import projetaoo.service.UtilisateurService;
import org.springframework.ui.Model;


import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.findAll();
    }

    public String showForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur()); // ajoutez un utilisateur vide au modèle
        return "utilisateur-form"; // Retourne le nom de la vue utilisateur-form.html
    }


    @PostMapping("/processForm")
    public String processForm(Utilisateur utilisateur) {
        utilisateurService.save(utilisateur); // Enregistre l'utilisateur dans la base de données
        return "redirect:/api/utilisateurs/showSuccess"; // Redirige vers la route qui montre la vue de succès
    }

    @GetMapping("/showSuccess")
    public String showSuccess() {
        return "utilisateur-success"; // Retourne le nom de la vue utilisateur-success.html
    }
}
