package com.example.demo.demo.controller;


import com.example.demo.demo.entity.Vehicle;
import com.example.demo.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;


    @GetMapping
    public ResponseEntity<List<Vehicle>> getVehicles(@RequestParam(required = false) String vehicleModel) {
        try {
            List<Vehicle> vehicleList = new ArrayList<>();
            if (null == vehicleModel) {
                vehicleRepository.findAll().forEach(vehicleList::add);
            } else {
                vehicleRepository.findByVehicleModel(vehicleModel).forEach(vehicleList::add);
            }
            return new ResponseEntity<>(vehicleList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>((List<Vehicle>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        try {
            Vehicle _vehicle = vehicleRepository.save(new Vehicle(vehicle.getVehicleType(), vehicle.getVehicleModel(), vehicle.getColour(), vehicle.getPlateNo(), vehicle.getInsuranceNo(), vehicle.getBoughtDate(), vehicle.getServiceDate(), vehicle.getVehicleLiscenceDate(), vehicle.getInsuranceExpireDate()));
            return new ResponseEntity<>(_vehicle, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>((Vehicle) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") int id, @RequestBody Vehicle vehicle) {
        try {
            Optional<Vehicle> vehicleData = vehicleRepository.findById(id);
            if (vehicleData.isPresent()) {
                Vehicle _vehicle = vehicleData.get();

                _vehicle.setVehicleType(vehicle.getVehicleType());
                _vehicle.setVehicleModel(vehicle.getVehicleModel());
                _vehicle.setColour(vehicle.getColour());
                _vehicle.setPlateNo(vehicle.getPlateNo());
                _vehicle.setInsuranceNo(vehicle.getInsuranceNo());
                _vehicle.setBoughtDate(vehicle.getBoughtDate());
                _vehicle.setServiceDate(vehicle.getServiceDate());
                _vehicle.setVehicleLiscenceDate(vehicle.getVehicleLiscenceDate());
                _vehicle.setInsuranceExpireDate(vehicle.getInsuranceExpireDate());

                return new ResponseEntity<>(vehicleRepository.save(_vehicle), HttpStatus.OK);
            } else {
                return new ResponseEntity<>((Vehicle) null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>((Vehicle) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Vehicle> deleteVehicle(@PathVariable("id") int id) {
        try {
            vehicleRepository.deleteById(id);
            return new ResponseEntity<>((Vehicle) null, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>((Vehicle) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
