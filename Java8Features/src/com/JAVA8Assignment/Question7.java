package com.JAVA8Assignment;

import java.util.*;
import java.util.stream.Collectors;

public class Question7 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 3, 7, 8, 2, 15, 20, 5);

        List<Integer> evenNumbers = numbers.stream()
                                           .filter(num -> num % 2 == 0)
                                           .collect(Collectors.toList());

        System.out.println("Even Numbers: " + evenNumbers);
    }
}

