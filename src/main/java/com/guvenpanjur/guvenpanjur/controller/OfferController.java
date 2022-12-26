package com.guvenpanjur.guvenpanjur.controller;


import com.guvenpanjur.guvenpanjur.model.dto.request.RequestCreateOffer;
import com.guvenpanjur.guvenpanjur.model.entity.Customer;
import com.guvenpanjur.guvenpanjur.model.entity.Offer;
import com.guvenpanjur.guvenpanjur.repository.CustomerRepository;
import com.guvenpanjur.guvenpanjur.service.CustomerService;
import com.guvenpanjur.guvenpanjur.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OfferController {
    private final OfferService offerService;
    private final CustomerService customerService;
    //dropdown list
    static List<String> motordirectionList = null;
    static List<String> orderStatus = null;
    static {
        motordirectionList = new ArrayList<>();
        motordirectionList.add("Sağ");
        motordirectionList.add("Sol");
    }

    static {
        orderStatus = new ArrayList<>();
        orderStatus.add("Fabrikada");
        orderStatus.add("Teslim Edildi");
    }
    @GetMapping("/offers")
    public String listOffers(Model model){
        model.addAttribute("offers", offerService.findOffers());
        return "offers";
    }
    @GetMapping("/offers/new")
    public String createOffer(Model model,@RequestParam(value = "customerId",required = false)Long customerId){
        Offer offer = new Offer();
        RequestCreateOffer createOffer=new RequestCreateOffer();
        if (customerId!=null){
            try {
                var customer=customerService.getById(customerId);
                offer.setCustomers(customer);
                createOffer.setCustomerId(customerId);
            }catch (Exception e){
                ///Customer ıd yanlış
                System.out.println("asd");
            }
        }
        model.addAttribute("motordirectionList", motordirectionList);
       // model.addAttribute("offer",offer);
        model.addAttribute("createOffer",createOffer);
       // model.addAttribute("customer",customerId);
        return "create_offer";
    }
    @PostMapping("/offers")
    public String saveOffer(@ModelAttribute("offer") RequestCreateOffer offer){
        var newOffer=new Offer();
        newOffer.setCustomers(Customer.builder().customerId(offer.getCustomerId()).build());
        offerService.saveOffer(newOffer);
        return "redirect:/offers";
    }

    @GetMapping("/test2")
    public String test(@RequestParam(value = "id",required = false,defaultValue = "asd")String id){
        System.out.println("#############################"+id);
        return "test2";
    }
}
