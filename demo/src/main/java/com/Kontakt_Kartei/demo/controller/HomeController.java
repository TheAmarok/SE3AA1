package com.Kontakt_Kartei.demo.controller;

import com.Kontakt_Kartei.demo.service.BereichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    private final BereichService _serviceB;

    @Autowired
    public HomeController(BereichService serviceB) {
        this._serviceB = serviceB;
    }


    @GetMapping("/")
    public String startseite(Model model) {

        model.addAttribute(
                "bereiche",
                _serviceB.findAll()
        );

        return "home";
    }
}
