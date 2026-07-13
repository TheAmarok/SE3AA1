package com.Kontakt_Kartei.demo.controller;

import com.Kontakt_Kartei.demo.entity.BereichEntity;
import com.Kontakt_Kartei.demo.service.BereichService;
import com.Kontakt_Kartei.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final BereichService _serviceB;
    private final PersonService _serviceP;

    @Autowired
    public HomeController(BereichService serviceB, PersonService serviceP) {
        this._serviceB = serviceB;
        this._serviceP = serviceP;
    }


    @GetMapping("/")
    public String startseite(Model model) {

        model.addAttribute(
                "bereiche",
                _serviceB.findAll()
        );

        return "home";
    }

    @GetMapping("/neuer-bereich")
    public String showForm(Model model) {

        model.addAttribute("bereich",
                new BereichEntity());

        return "bereich-input";
    }

    @GetMapping("/bereich-bearbeiten/{id}")
    public String editBereich(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "bereich",
                _serviceB.findById(id).get());

        return "bereich-input";
    }

    @GetMapping("/bereich-loeschen/{id}")
    public String deleteBereich(
            @PathVariable Long id) {

        _serviceB.delete(id);

        return "redirect:/";
    }

    @GetMapping("/person-bearbeiten/{id}")
    public String editPerson(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "person",
                _serviceP.findById(id).get());
        model.addAttribute(
                "bereiche",
                _serviceB.findAll());

        return "person-input";
    }

    @GetMapping("/person-loeschen/{id}")
    public String deletePerson(
            @PathVariable Long id) {

        _serviceP.delete(id);

        return "redirect:/personen";
    }

    @PostMapping("/bereich-speichern")
    public String save(@ModelAttribute BereichEntity bereich) {

        _serviceB.save(bereich);

        return "redirect:/";
    }
}
