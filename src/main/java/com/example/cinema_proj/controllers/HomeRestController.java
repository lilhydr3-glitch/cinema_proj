package com.example.cinema_proj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeRestController {

    @GetMapping("/")
    public RedirectView home() {
        return new RedirectView("/api/cinemas");
    }
}
