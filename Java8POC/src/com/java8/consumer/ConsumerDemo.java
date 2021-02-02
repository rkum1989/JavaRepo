package com.java8.consumer;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * interface Consumer<T>{
 * 	public abstract void accept(T t);
 *  andThen();
 * 	
 * }
 * @author Rituraj Kumar
 *
 */
public class ConsumerDemo {

	public static void main(String[] args) {
		Consumer<String> c = s -> System.out.println(s);
		c.accept("Hello Consumer function");
		
		ArrayList<Movie> al = new ArrayList<>();
		al.add(new Movie("Bahuballi", "Prabash", "Anushka"));
		al.add(new Movie("Bahuballi2", "Prabash2", "Anushka2"));
		al.add(new Movie("Bahuballi3", "Prabash3", "Anushka3"));
		al.add(new Movie("Bahuball4", "Prabash4", "Anushka4"));
		al.add(new Movie("Bahuball5", "Prabash5", "Anushka5"));
		al.add(new Movie("Bahuballi6", "Prabash6", "Anushka6"));
		
		Consumer<Movie> movieCons = mov -> System.out.println(mov.toString());
		for(Movie m : al) {
			movieCons.accept(m);
		}
		
		//Consumer Chain
		Consumer<Movie> movieCons2 = mov -> System.out.println("Movie name :"+ mov.getName() + " is hit");
		Consumer<Movie> movieCons3 = mov -> System.out.println("Movie name :"+ mov.getName() + " showing in our theater");
		
		Consumer<Movie> chain = movieCons.andThen(movieCons2).andThen(movieCons3);
		chain.accept(new Movie("Bahuballi", "Prabash", "Anushka"));
		
		//BiConsumer
		BiConsumer<String, String> biCons = (x, y) -> System.out.println(x+y);
		biCons.accept("anbc", "xyzzz");
	}

}

class Movie{
	public String name;
	public String hero;
	public String heroine;
	
	public Movie(String name, String hero, String heroine) {
		super();
		this.name = name;
		this.hero = hero;
		this.heroine = heroine;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", hero=" + hero + ", heroine=" + heroine + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHero() {
		return hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

	public String getHeroine() {
		return heroine;
	}

	public void setHeroine(String heroine) {
		this.heroine = heroine;
	}
	
}
