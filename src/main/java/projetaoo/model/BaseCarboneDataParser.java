package projetaoo.model;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class BaseCarboneDataParser {

    public List<ProduitCarbone> parseBaseCarboneData(String jsonResponse) {
        /*
         * List<ProduitCarbone> produits = new ArrayList<>();
         * JSONObject obj = new JSONObject(jsonResponse);
         * JSONArray records = obj.getJSONArray("records");
         * for (int i = 0; i < records.length(); i++) {
         * JSONObject record = records.getJSONObject(i).getJSONObject("fields");
         * String productName = record.getString("nom_du_produit");
         * double carbonFootprint = record.getDouble("empreinte_carbone");
         * produits.add(new ProduitCarbone(productName, carbonFootprint));
         * }
         */
        List<ProduitCarbone> produits = new ArrayList<>();
        JSONObject obj = new JSONObject(jsonResponse);
        JSONArray results = obj.getJSONArray("results");
        for (int i = 0; i < results.length(); i++) {
            JSONObject result = results.getJSONObject(i);
            String nom = result.getString("categorie"); // Assurez-vous que c'est le champ souhaité pour le nom.
            
            // Utilisation de 'total_poste_non_decompose' comme exemple pour l'empreinte carbone.
            // Ajout d'une vérification pour s'assurer que le champ existe et est un double.
            double empreinteCarbone = 0;
            if (result.has("total_poste_non_decompose") && !result.isNull("total_poste_non_decompose")) {
                empreinteCarbone = result.getDouble("total_poste_non_decompose");
            }
            produits.add(new ProduitCarbone(nom, empreinteCarbone));
        }
        return produits;

    }
}
