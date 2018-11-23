package com.arunx.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arunx.model.Car;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {
	
	@GetMapping(path="")
	public List<Car> getAllCars() {
		return new ArrayList<Car>();
	}
	
	@GetMapping(path="/{id}")
	public Optional<Car> getCar(int id) {
		return null;
	}
	
	@PostMapping(path="")
	public Car addCar(Car car) {
		return null;
	}
	
	@PutMapping(path="/{id}")
	public Car updateCar(Car car) {
		return null;
	}
	
	@DeleteMapping(path="/{id")
	public void deleteCar(int id) {
		
	}
}
