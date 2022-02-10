package com.example.demo.demo.repository;

import com.example.demo.demo.entity.Driver;
import com.example.demo.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
    List<Driver> findByName(String driverName);
}
