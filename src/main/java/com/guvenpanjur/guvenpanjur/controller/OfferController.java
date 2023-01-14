package com.guvenpanjur.guvenpanjur.controller;


import com.guvenpanjur.guvenpanjur.controller.util.OfferDataUtil;
import com.guvenpanjur.guvenpanjur.model.dto.request.RequestCreateOffer;
import com.guvenpanjur.guvenpanjur.model.dto.request.RequestUpdateCustomer;
import com.guvenpanjur.guvenpanjur.model.dto.request.RequestUpdateOffer;
import com.guvenpanjur.guvenpanjur.model.entity.Customer;
import com.guvenpanjur.guvenpanjur.model.entity.Offer;
import com.guvenpanjur.guvenpanjur.model.viewmodel.CreateOfferViewModel;
import com.guvenpanjur.guvenpanjur.service.CustomerService;
import com.guvenpanjur.guvenpanjur.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class OfferController {
    private final OfferService offerService;
    private final CustomerService customerService;
    //dropdown list

    @GetMapping("/offers")
    public String listOffers(Model model){
        model.addAttribute("offers", offerService.findOffers());
        model.addAttribute("customers", customerService.findCustomers());
        return "offers";
    }
    @GetMapping("/zipperde")
    public String listZipPerde(Model model){
        model.addAttribute("offers", offerService.findOffers());
        model.addAttribute("customers",customerService.findCustomers());
        return "zip_perde_list";
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
        model.addAttribute("offerstatus", OfferDataUtil.offerstatus);
        model.addAttribute("productTypeOffer",OfferDataUtil.productTypeOffer);
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
        createOffer.setOfferstatus(offer.getOfferstatus());
        createOffer.setProductTypeOffer(offer.getProductTypeOffer());
        createOffer.setEngineControl(offer.getEngineControl());
        createOffer.setCustomerId(offer.getCustomerId());
        createOffer.setKumasBoyKesimOlcusu(offer.getWidth() - 63);
        createOffer.setKumasEnKesimOlcusu(offer.getHeight() + 100);
        createOffer.setKumasSonFiyat(createOffer.getKumasEnKesimOlcusu()*createOffer.getKumasBoyKesimOlcusu()* createOffer.getKumasBirimFiyat());
        offerService.saveOffer(createOffer);
        return "redirect:/offers";
    }

    @GetMapping("/selectcustomers")
    public String selectCustomer(ModelMap model){
        model.addAttribute("customers", customerService.findCustomers());
        return "select_customer";
    }

}
