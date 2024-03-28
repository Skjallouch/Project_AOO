//pour stocker les informations d'un produit et de son empreinte carbone

package projetaoo.model;

public class ProduitCarbone {
    private String nom;
    private double empreinteCarbone;

    // Constructeur
    public ProduitCarbone(String nom, double empreinteCarbone) {
        this.nom = nom;
        this.empreinteCarbone = empreinteCarbone;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public double getEmpreinteCarbone() {
        return empreinteCarbone;
    }
}