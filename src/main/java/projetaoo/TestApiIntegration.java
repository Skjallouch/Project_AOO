package projetaoo;

import projetaoo.model.ApiDataManager;
import projetaoo.model.BaseCarboneDataParser;
import projetaoo.model.ProduitCarbone;

import java.io.IOException;
import java.util.List;

public class TestApiIntegration {

    public static void main(String[] args) throws IOException, InterruptedException {
        ApiDataManager manager = new ApiDataManager("https://public.opendatasoft.com/api/");
        String jsonResponse = manager.getBaseCarboneData();

        // Affichage de la réponse pour le débogage
        System.out.println("Réponse JSON reçue: " + jsonResponse);

        // Vérification que la réponse n'est pas nulle et qu'elle est bien formée
        if (jsonResponse != null && !jsonResponse.trim().isEmpty() && jsonResponse.trim().startsWith("{")) {
            BaseCarboneDataParser parser = new BaseCarboneDataParser();
            try {
                List<ProduitCarbone> produits = parser.parseBaseCarboneData(jsonResponse);
                produits.forEach(produit -> System.out.println(produit.getNom() + " : " + produit.getEmpreinteCarbone()));
            } catch (Exception e) {
                // Gestion des exceptions lors du parsing JSON
                System.err.println("Erreur lors du parsing des données JSON : " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("La réponse de l'API n'est pas un JSON valide ou est vide.");
        }
    }
}