/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ks.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author coolyeekk
 */
@Controller
@RequestMapping("/api_path/signin")
public class SigninController {
    
    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;
    
    @GetMapping
    public ModelAndView index(@RequestParam(name = "error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView("signin");
        modelAndView.addObject("error", error);
        modelAndView.addObject("clientRegistrations", clientRegistrationRepository);
        return modelAndView;
    }
    
    @GetMapping("/api_path/login")
    public String login(OAuth2AuthenticationToken authenticationToken) {
        return "redirect:/";
    }
    
}

