package com.bytetechsolutions.adventurepos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signIn")
public class LoginController {

    @GetMapping
    public String handleGet() {
        return "login";
    }
}
