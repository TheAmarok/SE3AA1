package com.Kontakt_Kartei.demo.controller;

import com.Kontakt_Kartei.demo.record.BereichRecord;
import com.Kontakt_Kartei.demo.service.BereichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bereiche")
public class BereichController {

    private final BereichService _serviceB;

    @Autowired
    public BereichController(BereichService service) {
        this._serviceB = service;
    }

    @GetMapping
    public String showAll(Model model) {

        model.addAttribute("bereiche",
                _serviceB.findAll());

        return "bereiche";
    }

    @GetMapping("/neuer-bereich")
    public String showForm(Model model) {

        model.addAttribute("bereich",
                new BereichRecord(null, "","",""));

        return "bereich-input";
    }

    @PostMapping("/speichern")
    public String save(@ModelAttribute BereichRecord bereich) {

        _serviceB.save(bereich);

        return "redirect:/bereiche";
    }

    @GetMapping("/bearbeiten/{id}")
    public String edit(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "bereich",
                _serviceB.findById(id).get());

        return "bereich-input";
    }

    @GetMapping("/loeschen/{id}")
    public String delete(
            @PathVariable Long id) {

        _serviceB.delete(id);

        return "redirect:/bereiche";
    }

}
