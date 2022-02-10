package com.example.demo.demo.repository;

import com.example.demo.demo.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    List<Vehicle> findByVehicleModel(String vehicleModel);
}
