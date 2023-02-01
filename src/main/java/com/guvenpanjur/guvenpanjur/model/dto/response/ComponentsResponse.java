package com.guvenpanjur.guvenpanjur.model.dto.response;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ComponentsResponse {
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
