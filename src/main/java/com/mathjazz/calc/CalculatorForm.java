package com.mathjazz.calc;

public class CalculatorForm {
    private Double x;
    private Double y;
    private String operation;

    public CalculatorForm(Double x, Double y, String operation) {
        this.x = x;
        this.y = y;
        this.operation = operation;
    }

    public CalculatorForm() {
    }

    public Double getX() {
        return x;
    }
    
    public void setX(Double x) {
        this.x = x;
    }
    
    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public String getOperation() {
        return operation;
    }
    
    public void setOperation(String operation) {
        this.operation = operation;
    }
    
    
}
