package com.JAVA8Assignment;

interface Power {
    int square(int x); 

    default void show() {
        System.out.println("This is the default method.");
    }
}
class MyCalculator implements Power {
    public int square(int x) {
        return x * x;
    }
}

public class Question3 {
    public static void main(String[] args) {
        MyCalculator calc = new MyCalculator();
        
        calc.show();

        System.out.println("Square: " + calc.square(5));
    }
}
