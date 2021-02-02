package com.java8.optional;

import java.util.Optional;

public class Java8Optional {
	public static void main(String[] args) {

		String str = null;
		Optional<String> optional1 = Optional.ofNullable(str);
		System.err.println(optional1);

		//Optional<String> optional2 = Optional.of(str);
		//System.err.println(optional2);

		double carFixedPrice = 199.98;
		Car car = new Car(10000000D);
		car.setCarModel("Audi");
		Optional<Car> carPrice1 = Optional.empty();
		carPrice1.orElseThrow(IllegalStateException::new);

		Optional<Car> carPrice2 = Optional.ofNullable(car);
		Car car1 = new Car(carFixedPrice);
		double carResponse = carPrice2.orElse(car1).getPrice();
		System.err.println(carResponse);

		Optional<String> stringToUse = Optional.of("optional is there");
		if (stringToUse.isPresent()) {
			System.out.println(stringToUse.get());
		}

		stringToUse.ifPresent(System.out::println);

		// Filer(Lambda) Examples

		// if the value is not present
		Optional<Car> carOptionalEmpty = Optional.empty();
		carOptionalEmpty.filter(x -> new Double(10000000).equals(x.getPrice()))
				.ifPresent(x -> System.out.println(car.getPrice() + " is ok!"));
		System.err.println("carOptionalEmpty :" + carOptionalEmpty);

		// if the value does not pass the filter
		Optional<Car> carOptionalExpensive = Optional.of(new Car(3333D));
		carOptionalExpensive.filter(x -> new Double(10000000).equals(x.getPrice()))
				.ifPresent(x -> System.out.println(x.getPrice() + " is ok!"));
		System.err.println("carOptionalExpensive :" + carOptionalExpensive);

		// if the value is present and does pass the filter
		Optional<Car> carOptionalOk = Optional.of(new Car(250D));
		carOptionalOk.filter(x -> new Double(250D).equals(x.getPrice()))
				.ifPresent(x -> System.out.println(x.getPrice() + " is ok!"));
		System.err.println(carOptionalOk);

		// Map (Lambdas) Examples

		// non empty string map to its length -> we get the lenght as output (18)
		Optional<String> stringOptional = Optional.of("loooooooong string");
		Optional<Integer> sizeOptional = stringOptional.map(String::length); // map from Optional to Optional
		System.out.println("size of string " + sizeOptional.orElse(0));

		// empty string map to its length -> we get 0 as lenght
		Optional<String> stringOptionalNull = Optional.ofNullable(null);
		Optional<Integer> sizeOptionalNull = stringOptionalNull.map(x -> x.length()); // we can use Lambdas as we want
		System.out.println("size of string " + sizeOptionalNull.orElse(0));

	}
}

 class Car {
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

