package com.guvenpanjur.guvenpanjur.controller;


import com.guvenpanjur.guvenpanjur.controller.util.OfferDataUtil;
import com.guvenpanjur.guvenpanjur.model.dto.request.RequestCreateOffer;
import com.guvenpanjur.guvenpanjur.model.entity.Customer;
import com.guvenpanjur.guvenpanjur.model.entity.Offer;
import com.guvenpanjur.guvenpanjur.model.viewmodel.CreateOfferViewModel;
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
        model.addAttribute("customers", customerService.findCustomers());
        return "offers";
    }

    @GetMapping("/offers/new")
    public String createOffer(Model model,@RequestParam(value = "customerId",required = false)Long customerId){
        CreateOfferViewModel offerViewModel=new CreateOfferViewModel();
        if (customerId!=null){
            try {
                customerService.getById(customerId);
                offerViewModel.setCustomerId(customerId);
            }catch (Exception e){
                //Yanlış req
            }
        }
        model.addAttribute("motordirections", OfferDataUtil.motordirectionList);
        model.addAttribute("offerViewModel",offerViewModel);
        return "create_offer";
    }
    @PostMapping("/offers")
    public String saveOffer(@ModelAttribute("offerViewModel") CreateOfferViewModel offer){
        RequestCreateOffer createOffer=new RequestCreateOffer();
        createOffer.setUnit(offer.getUnit());
        createOffer.setHeight(offer.getHeight());
        createOffer.setWidth(offer.getWidth());
        createOffer.setMotordirection(offer.getMotordirection());
        createOffer.setCustomerId(offer.getCustomerId());
        offerService.saveOffer(createOffer);
        return "redirect:/offers";
    }
}
