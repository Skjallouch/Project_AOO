package projetaoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetaoo.model.HabitudeAchat;
import projetaoo.service.HabitudeAchatService;

import java.util.List;

@RestController
@RequestMapping("/api/habitudes-achat")
public class HabitudeAchatController {

    @Autowired
    private HabitudeAchatService habitudeAchatService;

    @GetMapping
    public List<HabitudeAchat> getAllHabitudesAchat() {
        return habitudeAchatService.findAll();
    }
}
