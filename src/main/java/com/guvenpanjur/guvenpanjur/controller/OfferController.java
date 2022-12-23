package com.guvenpanjur.guvenpanjur.controller;


import com.guvenpanjur.guvenpanjur.model.entity.Customer;
import com.guvenpanjur.guvenpanjur.model.entity.Offer;
import com.guvenpanjur.guvenpanjur.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class OfferController {
    private final OfferService offerService;

    @GetMapping("/offers")
    public String listOffers(Model model){
        model.addAttribute("offers", offerService.findOffers());
        return "offers";
    }
    @GetMapping("/offers/new")
    public String createOffer(Model model){
        Offer offer = new Offer();
        model.addAttribute("offer",offer);
        return "create_offer";
    }
    @PostMapping("/offers")
    public String saveOffer(@ModelAttribute("offer") Offer offer){
        offerService.saveOffer(offer);
        return "redirect:/offers";
    }
}
