package com.Kontakt_Kartei.demo.controller;

import com.Kontakt_Kartei.demo.entity.PersonEntity;
import com.Kontakt_Kartei.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/personen")
public class PersonController {

    private final PersonService _serviceP;

    @Autowired
    public PersonController(PersonService service) {
        this._serviceP = service;
    }

    @GetMapping
    public String showAll(Model model) {

        model.addAttribute("personen",
                _serviceP.findAll());

        return "personen";
    }

}
