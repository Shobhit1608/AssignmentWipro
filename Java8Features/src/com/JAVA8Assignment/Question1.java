package com.JAVA8Assignment;

import java.util.Arrays;
import java.util.List;

public class Question1 {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Shobhit","Rahul","Mohit","Ramesh");
		names.sort((name1,name2)-> name1.compareTo(name2) );
		
		System.out.println("Sorted Names are :- ");
		names.forEach(System.out::println);
	}

}
