package com.guvenpanjur.guvenpanjur.service.Impl;

import com.guvenpanjur.guvenpanjur.model.dto.request.RequestProposalSave;
import com.guvenpanjur.guvenpanjur.model.dto.response.ComponentsResponse;
import com.guvenpanjur.guvenpanjur.model.enums.MotorYon;
import com.guvenpanjur.guvenpanjur.service.ProposalService;
import com.guvenpanjur.guvenpanjur.service.ZipPerdeBrandService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProposalServiceImpl implements ProposalService {

    //Ajax thymeleaf dinamik satır https://www.tutussfunny.com/spring-boot-ajax-crud/
    private final ZipPerdeBrandService zipPerdeBrandService;
    @Override
    public BigDecimal saveProposal(RequestProposalSave requestProposalSave) {
        var fabricType=zipPerdeBrandService.getFabricById(requestProposalSave.getFabricTypeId());
        var motorType=zipPerdeBrandService.getMotorById(requestProposalSave.getMotorTypeId());
        ComponentsResponse componentsResponse = new ComponentsResponse();
        //CurrencyZipPerdeDTO crnZp=currencyService.getCurrency();
        List<BigDecimal> maliyet = new ArrayList<>();
        for (int i = 0; i <requestProposalSave.getPozs().size() ; i++) {
            CalculateProposal calculateProposal=new CalculateProposal();
            var poz=requestProposalSave.getPozs().get(i);
            for(int j = 0; j<requestProposalSave.getPiece();j++){
                maliyet.add(componentsResponse.getAltparcaAgirligiBirimMaliyet());
                maliyet.add(componentsResponse.getAltparcaHortumBirimMaliyet());
                maliyet.add(componentsResponse.getAltparcaAksesuariBiremMaliyet());
                maliyet.add(componentsResponse.getYanKapakBirimMaliyet());
                maliyet.add(componentsResponse.getRulmanBirimMaliyet());
                maliyet.add(componentsResponse.getPimliPlakeBM());
                maliyet.add(componentsResponse.getPerderBoruBM());
                maliyet.add(componentsResponse.getFermuarBM());
                maliyet.add(componentsResponse.getBoruBasiBm());
                maliyet.add(componentsResponse.getFitilBM());
                maliyet.add(componentsResponse.getPerdeAksesuarBM());
                maliyet.add(componentsResponse.getPaketlemeBM());
                maliyet.add(componentsResponse.getBaskiBM());
                maliyet.add(componentsResponse.getKutuBoyamaBm());
                maliyet.add(componentsResponse.getYanRayBoyamaBm());
                maliyet.add(componentsResponse.getAltParcaBoyamaBm());
            }
            //map calculateProposal
            maliyet.add(calculateZipPerdeM(calculateProposal));
        }
       return (BigDecimal) maliyet;
    }
    BigDecimal calculateZipPerdeM(CalculateProposal calculateProposal){

        return new BigDecimal(100);
    }

    /*
    class Maliyet{
        renk,motorType, packageType,
        List<PozMaliyet> pozs,
    }

   class PozMaliyet{
        unit,yukseklık,genişlik,
       BigDecimal pozMaliyet;
   }
    *
    * */

    @Data
    private class CalculateProposal{
        private BigDecimal fabricCost;
        private BigDecimal motorCost;
        private int unit;
        private double width;
        private double height;
        private MotorYon motorYon;
        private BigDecimal LME;
        private BigDecimal USD;
        private double fire;
        private BigDecimal altparcaAgirligiBirimMaliyet;
        private BigDecimal altparcaHortumBirimMaliyet;
        private BigDecimal altparcaAksesuariBiremMaliyet;
        private BigDecimal yanKapakBirimMaliyet;
        private BigDecimal rulmanBirimMaliyet;
        private BigDecimal pimliPlakeBM;
        private BigDecimal perderBoruBM;
        private BigDecimal fermuarBM;
        private BigDecimal boruBasiBm;
        private BigDecimal fitilBM;
        private BigDecimal perdeAksesuarBM;
        private BigDecimal paketlemeBM;
        private BigDecimal baskiBM;
        private BigDecimal kutuBoyamaBm;
        private BigDecimal yanRayBoyamaBm;
        private BigDecimal altParcaBoyamaBm;
    }
}
