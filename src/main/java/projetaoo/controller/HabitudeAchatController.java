package projetaoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projetaoo.model.HabitudeAchat;
import projetaoo.service.HabitudeAchatService;

import java.util.List;

@Controller
@RequestMapping("/habitudes-achat")
public class HabitudeAchatController {

    @Autowired
    private HabitudeAchatService habitudeAchatService;

    @GetMapping
    public List<HabitudeAchat> getAllHabitudesAchat() {
        return habitudeAchatService.findAll();
    }
}
