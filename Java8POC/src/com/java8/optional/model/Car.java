package com.java8.optional.model;

public class Car {
	private String carModel;
	private Double price;

	public Car(Double price) {
		this.price = price;
	}
	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [carModel=");
		builder.append(carModel);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}

	
}
