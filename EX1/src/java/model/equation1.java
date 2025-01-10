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
public class equation1 {
    private double a;
    private double b;

    public equation1() {
    }

    public equation1(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }
    public String getResult() {
        if (a == 0) {
            if (b == 0) {
                return "phuong trinh co vo so nghiem.";
            } else {
                return "phuong trinh vo nghiem.";
            }
        } else {
            double x = -b / a;
            return "nghiem cua phuong trinh la x = " + x;
        }
    }
}
