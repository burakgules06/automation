package com.guvenpanjur.guvenpanjur.service.Impl;

import com.guvenpanjur.guvenpanjur.model.dto.request.RequestFabricSave;
import com.guvenpanjur.guvenpanjur.model.dto.request.RequestFabricTypeSave;
import com.guvenpanjur.guvenpanjur.model.dto.request.RequestMotorSave;
import com.guvenpanjur.guvenpanjur.model.dto.request.RequestMotorTypeSave;
import com.guvenpanjur.guvenpanjur.model.dto.response.ResponseFabric;
import com.guvenpanjur.guvenpanjur.model.dto.response.ResponseFabricType;
import com.guvenpanjur.guvenpanjur.model.dto.response.ResponseMotor;
import com.guvenpanjur.guvenpanjur.model.dto.response.ResponseMotorType;
import com.guvenpanjur.guvenpanjur.model.entity.Fabric;
import com.guvenpanjur.guvenpanjur.model.entity.FabricType;
import com.guvenpanjur.guvenpanjur.model.entity.Motor;
import com.guvenpanjur.guvenpanjur.model.entity.MotorType;
import com.guvenpanjur.guvenpanjur.repository.*;
import com.guvenpanjur.guvenpanjur.service.ZipPerdeBrandService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ZipPerdeBrandServiceImpl implements ZipPerdeBrandService {

    //--Repository
    private final MotorTypeRepository motorTypeRepository;
    private final MotorRepository motorRepository;
    private final FabricRepository fabricRepository;
    private final FabricTypeRepository fabricTypeRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;



    @Override
    public void saveMotor(RequestMotorSave requestMotorSave) {
        motorRepository.findByName(requestMotorSave.getName()).ifPresent(customerRepository->{
            throw new RuntimeException("Motor Markası Var");
        });
        if (requestMotorSave.getMotorType()==null || requestMotorSave.getMotorType().size()<1)
            throw new RuntimeException("Model Yok");

        Motor motor=new Motor();
        motor.setName(requestMotorSave.getName());
        motor=motorRepository.save(motor);
        motor.setMotorTypes(new ArrayList<>());
        for (RequestMotorTypeSave motorTypeSave:requestMotorSave.getMotorType()) {
            MotorType motorType=new MotorType();
            motorType.setModel(motorTypeSave.getModel());
            motorType.setUnitCost(motorTypeSave.getUnitCost());
            motorType.setMotor(motor);
            motorType=motorTypeRepository.save(motorType);
            motor.getMotorTypes().add(motorType);
        }
        motorRepository.save(motor);
    }

    @Override
    public void saveFabric(RequestFabricSave requestFabricSave) {
        fabricRepository.findByName(requestFabricSave.getName()).ifPresent(customerRepository->{ //neden customer?
            throw new RuntimeException("Kumaş Markası Var");
        });
        if (requestFabricSave.getFabricType()==null || requestFabricSave.getFabricType().size()<1)
            throw new RuntimeException("Model yok");

        Fabric fabric = new Fabric();
        fabric.setName(requestFabricSave.getName());
        fabric = fabricRepository.save(fabric);
        fabric.setFabricTypes(new ArrayList<>());
        for (RequestFabricTypeSave fabricTypeSave:requestFabricSave.getFabricType() ){
            FabricType fabricType = new FabricType();
            fabricType.setModel(fabricTypeSave.getModel());
            fabricType.setUnitCost(fabricTypeSave.getUnitCost());
            fabricType.setFabric(fabric);
            fabricType=fabricTypeRepository.save(fabricType);
            fabric.getFabricTypes().add(fabricType);
        }
        fabricRepository.save(fabric);
    }


    @Override
    public void updateMotorTypeCost(Long typeId, BigDecimal newCost) {
        MotorType motorType=motorTypeRepository.findById(typeId).orElseThrow(() -> new RuntimeException("Motor Type Yok"));
        motorType.setUnitCost(newCost);
        motorTypeRepository.save(motorType);
    }

    @Override
    public void updateFabricTypeCost(Long typeId, BigDecimal newCost) {
        FabricType fabricType = fabricTypeRepository.findById(typeId).orElseThrow(()-> new RuntimeException("Kumaş Tipi Yok"));
        fabricType.setUnitCost(newCost);
        fabricTypeRepository.save(fabricType);
    }

    @Override
    public void addMotorType(Long motorId, String model, BigDecimal unitCost) {
        Motor motor=motorRepository.findById(motorId).orElseThrow(() -> new RuntimeException("Motor Id yanlıs"));
        MotorType motorType=new MotorType();
        motorType.setMotor(motor);
        motorType.setModel(model);
        motorType.setUnitCost(unitCost);
        motorType=motorTypeRepository.save(motorType);
        motor.getMotorTypes().add(motorType);
        motorRepository.save(motor);
    }

    @Override
    public void addFabricType(Long fabricId, String model, BigDecimal unitCost) {
        Fabric fabric = fabricRepository.findById(fabricId).orElseThrow(()->new RuntimeException("Kumaş Id Yanlış"));
        FabricType fabricType = new FabricType();
        fabricType.setFabric(fabric);
        fabricType.setModel(model);
        fabricType.setUnitCost(unitCost);
        fabricType = fabricTypeRepository.save(fabricType);
        fabric.getFabricTypes().add(fabricType);
        fabricRepository.save(fabric);
    }

    @Override
    public List<ResponseMotor> getAllMotor() {
        return motorRepository.findAll().stream().map(motor -> {
            ResponseMotor responseMotor=new ResponseMotor();
            responseMotor.setName(motor.getName());
            responseMotor.setId(motor.getId());
            responseMotor.setMotorTypes(new ArrayList<>());
            motor.getMotorTypes().forEach(motorType -> {
                ResponseMotorType responseMotorType=new ResponseMotorType();
                responseMotorType.setId(motorType.getId());
                responseMotorType.setModel(motorType.getModel());
                responseMotorType.setUnitCost(motorType.getUnitCost());
                responseMotor.getMotorTypes().add(responseMotorType);
            });
            return  responseMotor;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ResponseFabric> getAllFabric() {
        List<Fabric> fabrics = fabricRepository.findAll();
        List<ResponseFabric> responseFabrics = fabrics.stream().map(fabric -> modelMapper.map(fabric,ResponseFabric.class))
                .collect(Collectors.toList());
        return responseFabrics;
    }

    @Override
    public ResponseMotorType getMotorById(Long id) {
        MotorType motorType = motorTypeRepository.findById(id).orElseThrow(()->new RuntimeException("Motor Tipi Yok"));
        return modelMapper.map(motorType.getClass(),ResponseMotorType.class);
    }

    @Override
    public ResponseFabricType getFabricById(Long id) {
        FabricType fabricType = fabricTypeRepository.findById(id).orElseThrow(()->new RuntimeException("Kumaş Tipi yok"));
        return modelMapper.map(fabricType.getClass(),ResponseFabricType.class);
    }

}
