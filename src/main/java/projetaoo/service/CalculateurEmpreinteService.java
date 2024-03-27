package projetaoo.service;

import org.springframework.beans.factory.annotation.Autowired;

import projetaoo.model.CalculateurEmpreinte;
import projetaoo.model.Utilisateur;
import projetaoo.repository.UtilisateurRepository;

public class CalculateurEmpreinteService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public float calculerEmpreinteTotalePourUtilisateur(Long utilisateurId) {
        @SuppressWarnings("null")
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        float empreinteEnergie = CalculateurEmpreinte.calculerEmpreinteEnergie(utilisateur.getConsoEnergie());
        float empreinteTransport = CalculateurEmpreinte
                .calculerEmpreinteTransport(utilisateur.getMinutesMoyenTransport());
        float empreinteAchats = CalculateurEmpreinte.calculerEmpreinteAchats(utilisateur.getHabitudeAchat());

        return empreinteEnergie + empreinteTransport + empreinteAchats; // Total empreinte écologique
    }

    public String suggererReductionsPourUtilisateur(Long utilisateurId) {
        float empreinteTotale = calculerEmpreinteTotalePourUtilisateur(utilisateurId);
        return CalculateurEmpreinte.suggererReductions(empreinteTotale);
    }
}
