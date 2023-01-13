package com.guvenpanjur.guvenpanjur.controller;


import com.guvenpanjur.guvenpanjur.service.CustomerService;
import com.guvenpanjur.guvenpanjur.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//EHG1VJRC3PHTNOEG

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final CustomerService customerService;
    private final OfferService offerService;

    @GetMapping("/")
    public String listOffers(Model model){
        model.addAttribute("offers", offerService.findOffers());
        model.addAttribute("customers", customerService.findCustomers());
        return "index";
    }
    @GetMapping("/sineklik")
    public String sineklikSayfasi(){
        return "sineklik";
    }
    /**
     @GetMapping("/")
     public String listCustomers(Model model){
     model.addAttribute("customers", customerService.findCustomers());
     return "index";
     }
    */

}
