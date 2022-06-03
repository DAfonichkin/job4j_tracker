package ru.job4j.oop;

public class Triangle {

    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point a, Point b, Point c) {
        this.first = a;
        this.second = b;
        this.third = c;
    }

    public double semiPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    public boolean exist(double ab, double ac, double bc) {
        return (ab + ac) > bc && (ac + bc) > ab && (ab + bc) > ac;
    }

    public double area() {
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        if (this.exist(ab, ac, bc)) {
            double p = semiPerimeter(ab, ac, bc);
            return Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return -1;
    }
}
