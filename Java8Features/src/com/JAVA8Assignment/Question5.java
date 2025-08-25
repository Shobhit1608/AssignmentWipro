package com.JAVA8Assignment;

import java.util.*;

public class Question5 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Amit", "Ravi", "Anjali", "Sunil", "Arjun", "Bhuvan");

        System.out.println("Names starting with A:");
        
        names.stream()
             .filter(name -> name.startsWith("A"))
             .forEach(System.out::println);
    }
}

