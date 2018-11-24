package com.arunx.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="car")
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	@Size(min=3, max=100, message="Name should have at least 2 characters")
	@Column(name="name")
	private String name;
	@NotBlank
	@Column(name="make")
	private String make;
	@NotNull
	@Column(name="model")
	private String model;
	@NotEmpty
	@Column(name="color")
	private String color;
	@NotNull
	//@Size(min=4, max=4, message="Please provide year")
	@Column(name="year")
	private Integer year;
	@NotNull
	@Column(name="price")
	private BigDecimal price;
	
	public Car() {}
	
	public Car(String name, String make, String model, String color, int year, BigDecimal price) {
		super();
		this.name = name;
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
