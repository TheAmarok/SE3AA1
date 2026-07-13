package com.Kontakt_Kartei.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BereichMissingException.class)
    public String handleBereichMissing(BereichMissingException e, RedirectAttributes redirectAttributes) {

        log.warn("Bereich nicht gefunden: {}", e.getMessage(), e);

        redirectAttributes.addFlashAttribute(
                "error",
                "Bereich existiert nicht."
        );

        return "redirect:/fehler";
    }

    @ExceptionHandler(PersonMissingException.class)
    public String handlePersonMissing(PersonMissingException e, RedirectAttributes redirectAttributes) {

        log.warn("Person nicht gefunden: {}", e.getMessage(), e);

        redirectAttributes.addFlashAttribute(
                "error",
                "Person existiert nicht."
        );

        return "redirect:/fehler";
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception e, RedirectAttributes redirectAttributes) {

        log.error("Unerwarteter Fehler: {}", e.getMessage(), e);

        redirectAttributes.addFlashAttribute(
                "error",
                "Ein unerwarteter Fehler ist aufgetreten."
        );

        return "redirect:/fehler";
    }
}