package com.Kontakt_Kartei.demo.controller;

import com.Kontakt_Kartei.demo.entity.PersonEntity;
import com.Kontakt_Kartei.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/neue-person")
    public String showForm(Model model) {

        model.addAttribute("person",
                new PersonEntity());

        return "person-input";
    }

    @PostMapping("/speichern")
    public String save(
            @ModelAttribute PersonEntity person) {

        _serviceP.save(person);

        return "redirect:/personen";
    }

}
