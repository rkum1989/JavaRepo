package com.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream api process objects from collection.
 *
 * @author Rituraj Kumar
 */
public class StreamApiExample {
		
	public static void main(String[] args) {
		Integer[] arr = {5,20,0,25,30,50,10};
        List<Integer> li = Arrays.stream(arr).filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println("Filtered numbers which are even "+ li);

        List<Integer> li2 = Arrays.stream(arr).map(i -> i * 2).collect(Collectors.toList());
        System.out.println("Mapped each numbers in collection to it's double "+ li2);

        Long count = Arrays.stream(arr).filter(i -> i > 10).count();
        System.out.println("Count Numbers greater than 10 "+ count);

        //Default sorting order i.e Ascending order.
        List<Integer> li3 = Arrays.stream(arr).sorted().collect(Collectors.toList());
        System.out.println("In AScending order"+ li3);

        //Custom sorting order i.e Descending order.
        List<Integer> li4 = Arrays.stream(arr).sorted((i1,i2) -> -i1.compareTo(i2)).collect(Collectors.toList());
        System.out.println("Descending order"+ li4);

        Optional<Integer> min = Arrays.stream(arr).min((i1, i2) -> i1.compareTo(i2));
        System.out.println("Minimum number in array "+ min.get());

        Optional<Integer> max = Arrays.stream(arr).max((i1,i2) -> i1.compareTo(i2));
        System.out.println("Maximum number in array "+ max.get());

        Arrays.stream(arr).forEach(System.out::println);

        Integer[] copyArray = Arrays.stream(arr).toArray(Integer[]::new);
        Arrays.stream(copyArray).forEach(System.out::println);
        System.out.println();

        Stream<Integer> s = Stream.of(9,19,10,20,3838);
        s.forEach(System.out::println);


    }
}
