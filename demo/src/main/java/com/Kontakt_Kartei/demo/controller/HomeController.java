package com.Kontakt_Kartei.demo.controller;

import com.Kontakt_Kartei.demo.entity.BereichEntity;
import com.Kontakt_Kartei.demo.entity.PersonEntity;
import com.Kontakt_Kartei.demo.exception.BereichMissingException;
import com.Kontakt_Kartei.demo.exception.PersonMissingException;
import com.Kontakt_Kartei.demo.service.BereichService;
import com.Kontakt_Kartei.demo.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    private final BereichService _serviceB;
    private final PersonService _serviceP;
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

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
    public String editBereich( @PathVariable Long id, Model model) {

        BereichEntity bereich = _serviceB.findById(id)
                .orElseThrow(() -> new BereichMissingException("Bereich " + id + " fehlt."));

        model.addAttribute(
                "bereich", bereich);

        return "bereich-input";
    }

    @PostMapping("/bereich-speichern")
    public String saveBereich(@ModelAttribute BereichEntity bereich) {

        _serviceB.save(bereich);

        return "redirect:/";
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

        PersonEntity person = _serviceP.findById(id)
                .orElseThrow(() -> new PersonMissingException("Person " + id + " fehlt."));

        model.addAttribute(
                "person",
                person);
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

    @ExceptionHandler(BereichMissingException.class)
    public String handleBereichMissing(BereichMissingException e, RedirectAttributes redirectAttributes) {
        log.warn("Fehler aufgerufen: {}", e.getMessage(), e);
        redirectAttributes.addFlashAttribute("error", "Bereich existiert nicht.");
        return "redirect:/fehler";
    }

    @ExceptionHandler(PersonMissingException.class)
    public String handlePersonMissing(PersonMissingException e, RedirectAttributes redirectAttributes) {
        log.warn("Fehler aufgerufen: {}", e.getMessage(), e);
        redirectAttributes.addFlashAttribute("error", "Person existiert nicht.");
        return "redirect:/fehler";
    }

    @GetMapping("/fehler")
    public String fehlerseite() {
        return "fehler";
    }
}
