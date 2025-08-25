package com.JAVA8Assignment;

interface MessagePrinter {
    void printMessage(String message);
}

public class Question2 {

    public static void displayGreeting(MessagePrinter printer) {
        printer.printMessage("Hello, welcome to Java Lambda!");
    }

    public static void main(String[] args) {
        displayGreeting(message -> System.out.println(message));
    }
}
