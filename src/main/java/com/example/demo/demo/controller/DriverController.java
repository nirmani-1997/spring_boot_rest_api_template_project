package com.example.demo.demo.controller;


import com.example.demo.demo.entity.Driver;
//import com.example.demo.demo.entity.User;
import com.example.demo.demo.entity.User;
import com.example.demo.demo.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    DriverRepository driverRepository;


    @GetMapping
    public ResponseEntity<List<Driver>> getDrivers(@RequestParam(required = false) String driverName) {
        try {
            List<Driver> driverList = new ArrayList<>();
            if (null == driverName) {
                driverRepository.findAll().forEach(driverList::add);
//                driverList.addAll(driverRepository.findAll())
            } else {
                driverRepository.findByName(driverName).forEach(driverList::add);
            }
            return new ResponseEntity<>(driverList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>((List<Driver>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        try {
            Driver _driver = driverRepository.save(new Driver(driver.getName(), driver.getAddress(), driver.getContactNo(), driver.getEmail(), driver.getNic(), driver.getDateOfBirth(), driver.getJoinedDate(), driver.getUserRoll(), driver.getPassword(), driver.getLiscenceNo(), driver.getLiscenceExpireDate()));
            return new ResponseEntity<>(_driver, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>((Driver) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable("id") int id, @RequestBody Driver driver) {
        try {
            Optional<Driver> driverData = driverRepository.findById(id);
            if (driverData.isPresent()) {
                Driver _driver = (Driver) driverData.get();

                _driver.setName(driver.getName());
                _driver.setAddress(driver.getAddress());
                _driver.setContactNo(driver.getContactNo());
                _driver.setEmail(driver.getEmail());
                _driver.setNic(driver.getNic());
                _driver.setDateOfBirth(driver.getDateOfBirth());
                _driver.setJoinedDate(driver.getJoinedDate());
                _driver.setUserRoll(driver.getUserRoll());
                _driver.setPassword(driver.getPassword());
                _driver.setLiscenceNo(driver.getLiscenceNo());
                _driver.setLiscenceExpireDate(driver.getLiscenceExpireDate());


                return new ResponseEntity<>(driverRepository.save(_driver), HttpStatus.OK);
            } else {
                return new ResponseEntity<>((Driver) null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>((Driver) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Driver> deleteDriver(@PathVariable("id") int id) {
        try {
            driverRepository.deleteById(id);
            return new ResponseEntity<>((Driver) null, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>((Driver) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
