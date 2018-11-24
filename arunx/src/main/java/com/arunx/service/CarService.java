package com.arunx.service;

import java.util.Optional;

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
	
	public Car update(Car car) {
		return carRepository.save(car);
	}
	
	public void delete(long id) {
		carRepository.deleteById(id);
	}
	
	public Iterable<Car> getAllCars() {
		return carRepository.findAll();
	}
	
	public Optional<Car> getCar(long id) {
		return carRepository.findById(id);
	}
	
	public Iterable<Car> findByQuery(String make, String model, String color, int year) {
		if (make != null && model != null && year != 0) {
			return carRepository.findByMakeAndModelAndYear(make, model, year);
		} else if (make != null) {
			return carRepository.findByMake(make);
		} else if (model != null) {
			return carRepository.findByModel(model);
		} else if (year != 0) {
			return carRepository.findByYear(year);
		} else if (color != null) {
			return carRepository.findByColor(color);
		} else {
			return carRepository.findAll();
		}
	}
	
	public long totalCar() {
		return carRepository.count();
	}
}
