/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static java.lang.Math.sqrt;

/**
 *
 * @author LAPTOP
 */
public class equation2 {
    private double a;
    private double b;
    private double c;

    public equation2() {
    }

    public equation2(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }
    public String getResult() {
        if (a == 0) {
            return "day khong phai la phuong trinh bac 2";
        }

        double delta = (b * b) - (4 * a * c);

        if (delta > 0) {
            double x1 = (-b + sqrt(delta)) / (2 * a);
            double x2 = (-b - sqrt(delta)) / (2 * a);
            return "phuong trinh co 2 nghiem phan biet: x1 = " + x1 + ", x2 = " + x2;
        } else if (delta == 0) {
            double x = -b / (2 * a);
            return "phuong trinh co nghiem kep: x = " + x;
        } else {
            return "phuong trinh vo nghiem";
        }
    }
    
}
