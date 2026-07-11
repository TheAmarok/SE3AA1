package com.Kontakt_Kartei.demo.controller;

import com.Kontakt_Kartei.demo.entity.PersonEntity;
import com.Kontakt_Kartei.demo.record.PersonRecord;
import com.Kontakt_Kartei.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
                new PersonRecord(null, "","","",""));

        return "person-input";
    }

    @PostMapping("/speichern")
    public String save(@ModelAttribute PersonRecord person) {

        _serviceP.save(person);

        return "redirect:/personen";
    }

    @GetMapping("/bearbeiten/{id}")
    public String edit(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "person",
                _serviceP.findById(id).get());

        return "person-input";
    }

    @GetMapping("/loeschen/{id}")
    public String delete(
            @PathVariable Long id) {

        _serviceP.delete(id);

        return "redirect:/personen";
    }

}
