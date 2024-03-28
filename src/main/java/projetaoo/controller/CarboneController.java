package projetaoo.controller;

import projetaoo.model.ProduitCarbone;
import projetaoo.model.ApiDataManager;
import projetaoo.model.BaseCarboneDataParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class CarboneController {
    private static final Logger log = LoggerFactory.getLogger(CarboneController.class);


    @GetMapping("/empreinte-carbone")
    public String afficherEmpreinteCarbone(Model model) {
        log.info("Traitement de la requête /empreinte-carbone.");

        try {
            ApiDataManager manager = new ApiDataManager("https://public.opendatasoft.com/api/");
            String jsonResponse = manager.getBaseCarboneData();
            BaseCarboneDataParser parser = new BaseCarboneDataParser();
            List<ProduitCarbone> produits = parser.parseBaseCarboneData(jsonResponse);

            model.addAttribute("produits", produits);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            // Ici, vous pourriez renvoyer vers une page d'erreur personnalisée.
            return "erreur";
        }
        return "empreinte-carbone"; // Nom du fichier template Thymeleaf

        /*ApiDataManager manager = new ApiDataManager("https://public.opendatasoft.com/api/");
        String jsonResponse = manager.getBaseCarboneData();
        BaseCarboneDataParser parser = new BaseCarboneDataParser();
        List<ProduitCarbone> produits = parser.parseBaseCarboneData(jsonResponse);

        model.addAttribute("produits", produits);
        return "empreinte-carbone"; // Nom du fichier template Thymeleaf*/

    }
}

