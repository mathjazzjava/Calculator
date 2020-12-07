package com.mathjazz.calc;


import java.lang.Math;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    
    public double add(double a, double b) {
        return (double)(Math.round((a + b) * 100000000)) / 100000000;
    }
    
    public double subtract(double a, double b) {
        return (double)(Math.round((a - b) * 100000000)) / 100000000;
    }
    
    public double multiply(double a, double b) {
        return (double)(Math.round(a * b * 100000000)) / 100000000;
    }
    
    public double division(double a, double b) {
        return (double)(Math.round(a/b * 100000000)) / 100000000;
    }
    
    public double sqrt2(double a) {
        return (double)(Math.round(Math.sqrt(a) * 100000000)) / 100000000;
    }
    
    public double secondPower(double a) {
        return (double)(Math.round(a * a * 100000000)) / 100000000;
    }
    
    public double percent(double a) {
        return (double)(Math.round(a * 0.01 * 100000000)) / 100000000;
    }
    
    public int factorials(int a) {
        
        if (a>1)
            return a*factorials(a-1);
        else
            return 1;
   }
    
    public double sine(double a) {
        return (double)(Math.round(Math.sin((a*Math.PI)/180) * 100000000)) / 100000000;
    }
    
    public double cosine(double a) {
        return (double)(Math.round(Math.cos((a*Math.PI)/180) * 100000000)) / 100000000;
    }
    
    public double tangent(double a) {
        return (double)(Math.round(Math.tan((a*Math.PI)/180) * 100000000)) / 100000000;
    }
    
    public double logarithm(double a) {
        return (double)(Math.round(Math.log(a) * 100000000)) / 100000000;
    }
    
    public double calculate(double x, double y, String operation) {
        switch(operation) {
            case "+":
                return add(x, y);
            case "-":
                return subtract(x, y);
            case "*":
                return multiply(x, y);
            case "/":
                return division(x, y);
            case "sqrt":
                return sqrt2(x);
            case "^2":
                return secondPower(x);
            case "%":
                return percent(x);
            case "!":
                return factorials((int)(x));
            case "sin":
                return sine(x);
            case "cos":
                return cosine(x);
            case "tg":
                return tangent(x);
            case "ln":
                return logarithm(x);
        }
        throw new IllegalArgumentException("Nieznana operacja: " +operation);
    }
}
