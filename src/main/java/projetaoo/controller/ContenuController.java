package projetaoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import projetaoo.service.ContenuService;

@Controller
public class ContenuController {

    @Autowired
    private ContenuService contenuService;

    @GetMapping("/contenus")
    public String getContenus(Model model) {
        model.addAttribute("contenus", contenuService.findAll());
        return "contenus"; // Nom du template Thymeleaf
    }
}
