package models;

public class Equation1 {

    private double a;
    private double b;
    private double c;

    public Equation1() {
    }

    public Equation1(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    public double getNum3() {
        return c;
    }

    public void setNum3(double c) {
        this.c = c;
    }

    public Object getResult() {
        Object result;
        double delta;
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    result = "Equation has infinite solution";
                } else {
                    result = "Equation has no solution";
                }
            } else {
                result = -c / b;
            }
        } else {
            delta = b*b - 4*a*c;
            if (delta < 0) {
                result = "Equation has no solution";
            } else if (delta == 0) {
                result = String.format("The equation has two same solutions x = %.2f", -b/(2 * a));
            } else {
                double x1 = (-b+Math.sqrt(delta))/(2*a);
                double x2 = (-b-Math.sqrt(delta)) / (2*a);
                result = String.format("The equation has two different solutions x1 = %.2f, x2 =%.2f", x1, x2);
            }
        }
        return result;
    }
}
