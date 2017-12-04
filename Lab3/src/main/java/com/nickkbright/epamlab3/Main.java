package com.nickkbright.epamlab3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an expression: ");
        String string = scanner.nextLine();
        System.out.println(calculator.calculate(string));
    }
}