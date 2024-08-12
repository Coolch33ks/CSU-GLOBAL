package Shapes;

public class triangle extends shape {
    private double side1;
    private double side2;
    private double side3;

    //Constructor
    public  triangle(int side1, int side2, int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    //Calculate the area of the triangle using Heron's formula
    @Override
    public double area() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    //Calculate the perimeter of the triangle
    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }

    //Return the string representation of the triangle
    @Override
    public String toString() {
        return "Triangle: " +
                "Area = " + area() +
                ", Perimeter = " + perimeter();
    }

}
