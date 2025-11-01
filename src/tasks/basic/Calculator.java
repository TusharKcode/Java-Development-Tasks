package tasks.basic;

import java.util.Scanner;

public class Calculator {

    //    Method for Addition
    public static double add(double a, double b){
        return a + b;
    }

    //    Method for Subtraction
    public static double subtract(double a, double b){
        return a - b;
    }

    //    Method for Multiplication
    public static double multiply(double a, double b){
        return a * b;
    }

    //    Method for Division
    public static double divide(double a, double b){
        if(b == 0){
            System.out.println("Divide by zero is not allowed!");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner calc = new Scanner(System.in);

        System.out.println("==== Basic Calculator ====");

        System.out.println("Enter first number: ");
        double num1 = calc.nextDouble();

        System.out.println("Enter second number: ");
        double num2 = calc.nextDouble();

        System.out.println("Choose operation (+, - , *, /): ");
        char operator = calc.next().charAt(0);

        double result;

        switch (operator){
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                result = divide(num1, num2);
                break;
            default:
                System.out.println("Invalid Operator!");
                calc.close();
                return;
        }

        System.out.println("Result: " + result);
        calc.close();
    }
}
