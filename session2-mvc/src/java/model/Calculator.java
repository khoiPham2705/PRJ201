package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LAPTOP
 * javaBean:
 * Co default constructor
 * Co getter/setter
 * 
 */
public class Calculator {
    //Field va Attribute
    private double num1;
    private double num2;
    private String op;

    public Calculator() {
        this.num1 = 0;
        this.num2 = 0;
        this.op = null;
    }

    public Calculator(double num1, double num2, String op) {
        this.num1 = num1;
        this.num2 = num2;
        this.op = op;
    }
    
    //Dinh nghia property num1
    public double getNum1() {
        return num1;
    }
    //Dinh nghia property num2
    public double getNum2() {
        return num2;
    }

    public String getOp() {
        return op;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public void setOp(String op) {
        this.op = op;
    }
    // Dinh nghia read-only property result
    public Object getResult() {
        Object result = null;
        switch (op) {
            case "add":
                result = num1 + num2; 
                break;
            case "sub":
                result = num1 - num2;   
                break;
            case "mul":
                 result = num1 * num2;  
                 break;
            case "div":
                if (num2 == 0){
                    result = "Can devide by zero";
                }
                else{
                    result = num1 / num2;    
                }
                  
                break;
        }  
        return result;
    }
}
