package com.arunx.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arunx.model.Car;
import com.arunx.service.CarService;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {
	private CarService carService;
	
	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}
	
	@PostMapping(path="")
	public Car addCar(@Valid @RequestBody Car car) {
		return carService.addCar(car);
	}
	
	//@PutMapping(path="/{id}")
	@PutMapping(path="")
	public ResponseEntity<Car> updateCar(@Valid @RequestBody Car car) {
		if (carService.getCar(car.getId()).isPresent()) {
			return new ResponseEntity<>(carService.update(car), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(car, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteCar(@PathVariable long id) {
		carService.delete(id);
	}
	
	@GetMapping(path="")
	public Iterable<Car> getAllCars() {
		return carService.getAllCars();
	}
	
	@GetMapping(path="/{id}")
	public Optional<Car> getCar(@PathVariable long id) {
		return carService.getCar(id);
	}
}
