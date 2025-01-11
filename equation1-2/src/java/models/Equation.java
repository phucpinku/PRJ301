package models;

public class Equation {

    private double a;
    private double b;

    public Equation() {
    }

    public Equation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getNum1() {
        return a;
    }

    public void setNum1(double a) {
        this.a = a;
    }

    public double getNum2() {
        return b;
    }

    public void setNum2(double b) {
        this.b = b;
    }

    public Object getResult() {
        Object result;
        if (a == 0) {
            if (b == 0) {
                result = "Equation has infinite solution";
            } else {
                result = "Equation has no solution";
            }
        } else {
            double x = (double)-b / a;
            result = String.format("Equation has a solution: %.2f", x);
        }
        return result;
    }
}
