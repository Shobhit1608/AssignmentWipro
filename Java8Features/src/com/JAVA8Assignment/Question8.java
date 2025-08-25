package com.JAVA8Assignment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question8 {

    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Delhi", "Mumbai", "Chennai", "Kolkata", "Bengaluru");

        String result = cities.stream()
                              .collect(Collectors.joining(", "));  

        System.out.println("Joined Cities: " + result);
    }
}

