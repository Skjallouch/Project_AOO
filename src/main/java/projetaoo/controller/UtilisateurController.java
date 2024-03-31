package projetaoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import projetaoo.model.Utilisateur;
import projetaoo.repository.UtilisateurRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/utilisateur")

public class UtilisateurController {

    private static final Logger logger = LoggerFactory.getLogger(UtilisateurController.class);

    @Autowired
    // private UtilisateurService utilisateurService;
    private UtilisateurRepository utilisateurRepository; // Utiliser le repository directement

    /*
     * @GetMapping
     * public List<Utilisateur> getAllUtilisateurs() {
     * return utilisateurService.findAll();
     * }
     */

    // Mappage pour afficher le formulaire
    @GetMapping("/form")
    public String showForm(Model model) {
        logger.info("Affichage du formulaire utilisateur");

        model.addAttribute("utilisateur", new Utilisateur());
        return "utilisateur-form"; // Retourne le nom de la vue utilisateur-form.html
    }

    // Mappage pour traiter le formulaire
    // @ModelAttribute("utilisateur")
    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("utilisateur") Utilisateur utilisateur,
            BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (utilisateur == null) {
            // Gérer le cas où utilisateur est null
            return "redirect:/utilisateur/form";
        }
        logger.info("Traitement du formulaire utilisateur: {}", utilisateur);

        if (bindingResult.hasErrors()) {
            return "utilisateur-form";
        }

        // utilisateurService.save(utilisateur); // Enregistre l'utilisateur dans la
        // base de données
        utilisateurRepository.save(utilisateur); // Enregistrement dans la base de données
        redirectAttributes.addFlashAttribute("message", "Utilisateur enregistré avec succès !");
        return "redirect:/utilisateur/formSuccess"; // Redirige vers un endpoint qui montre une page de succès
    }

    // Mappage pour afficher la page de succès
    @GetMapping("/formSuccess")
    public String showFormSuccess() {
        return "utilisateur-success"; // Retourne le nom de la vue utilisateur-success.html
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidationExceptions(MethodArgumentNotValidException ex, Model model) {
        model.addAttribute("errors", ex.getBindingResult().getAllErrors());
        model.addAttribute("utilisateur", new Utilisateur());
        return "utilisateur-form";
    }

}
