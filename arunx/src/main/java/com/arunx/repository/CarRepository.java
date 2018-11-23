package com.arunx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arunx.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
