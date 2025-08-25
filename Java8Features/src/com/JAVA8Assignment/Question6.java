package com.JAVA8Assignment;

import java.util.*;

public class Question6 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Amit", "Anjali", "Sameer", "Sankalp", "Rahul", "Bhavya");

        long count = names.stream() .filter(name -> name.length() > 5) .count();

        System.out.println("Names longer than 5 characters: " + count);
    }
}

