package com.bytetechsolutions.adventurepos.controller;

import org.jmorla.viewdescriptor.View;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

import java.util.*;

@View(
    title = "Acceder | Adventure POS",
    entryPoint = "login.jsx",
    scripts = "/login.js",
    stylesheets = {"/login.css", "/style.css"}
)
@Controller
@RequestMapping("/signIn")
public class LoginController extends AbstractPage {

    @GetMapping
    public ModelAndView handleGet(ModelAndView model) {
        return model;
    }

    @Override
    public String getDescriptorName() {
        return getClass().getCanonicalName();
    }

    @ModelAttribute("attributes")
    public List<Attribute> csrfToken(HttpServletRequest request) {
        HttpSessionCsrfTokenRepository csrfTokenRepository = new HttpSessionCsrfTokenRepository();
        CsrfToken csrfToken = csrfTokenRepository.loadToken(request);
        if(csrfToken != null) {
            return List.of(new Attribute(csrfToken.getParameterName(), csrfToken.getToken()));
        }
        return List.of();
    }

    record Attribute(String name, String value) {}

    
}
