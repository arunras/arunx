package com.arunx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arunx.model.Car;
import com.arunx.repository.CarRepository;

@Service
public class CarService {
	private CarRepository carRepository;
	
	@Autowired
	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	public Car addCar(Car car) {
		return carRepository.save(car);
	}
	
	public void update(Car car) {
		carRepository.save(car);
	}
	
	public Iterable<Car> getAllCars() {
		return carRepository.findAll();
	}
	
	public long totalCar() {
		return carRepository.count();
	}
}
