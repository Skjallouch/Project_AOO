package projetaoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetaoo.model.HabitudeAchat;
import projetaoo.repository.HabitudeAchatRepository;

import java.util.List;

@Service
public class HabitudeAchatService {

    @Autowired
    private HabitudeAchatRepository habitudeAchatRepository;

    public List<HabitudeAchat> findAll() {
        return habitudeAchatRepository.findAll();
    }
    
    // Ajoutez d'autres méthodes pour gérer les habitudes d'achat
}
