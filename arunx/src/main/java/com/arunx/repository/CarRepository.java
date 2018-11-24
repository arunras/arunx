package com.arunx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arunx.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

	public Iterable<Car> findByMake(String make);
	public Iterable<Car> findByModel(String model);
	public Iterable<Car> findByMakeAndModel(String make, String model);
	public Iterable<Car> findByMakeAndModelAndYear(String make, String model, int year);
	public Iterable<Car> findByColor(String color);
	public Iterable<Car> findByYear(int year);
	
	
}
