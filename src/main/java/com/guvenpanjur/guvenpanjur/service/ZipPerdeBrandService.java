package com.guvenpanjur.guvenpanjur.service;

import com.guvenpanjur.guvenpanjur.model.dto.request.RequestFabricSave;
import com.guvenpanjur.guvenpanjur.model.dto.request.RequestMotorSave;
import com.guvenpanjur.guvenpanjur.model.dto.response.ResponseFabric;
import com.guvenpanjur.guvenpanjur.model.dto.response.ResponseFabricType;
import com.guvenpanjur.guvenpanjur.model.dto.response.ResponseMotor;
import com.guvenpanjur.guvenpanjur.model.dto.response.ResponseMotorType;

import java.math.BigDecimal;
import java.util.List;

public interface ZipPerdeBrandService {
    void saveMotor(RequestMotorSave requestMotorSave);
    void saveFabric(RequestFabricSave requestFabricSave);
    void updateMotorTypeCost(Long typeId, BigDecimal newCost);
    void updateFabricTypeCost(Long typeId, BigDecimal newCost);
    void addMotorType(Long motorId,String model,BigDecimal unitCost);
    void addFabricType(Long fabricId,String model,BigDecimal unitCost);
    List<ResponseMotor> getAllMotor();
    List<ResponseFabric> getAllFabric();

    ResponseMotorType getMotorById(Long id);

    ResponseFabricType getFabricById(Long id);
}
