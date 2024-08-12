package Shapes;

public class circle extends shape {
    private double radius;

    //Constructor
    public  circle(int radius) {
        this.radius = radius;
    }

    //Calculate the area of the circle
    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    //Calculate the perimeter of the circle
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    //Return the string representation of the circle
    @Override
    public String toString() {
        return "Circle: " +
                "Area = " + area() +
                ", Perimeter = " + perimeter();
    }

}
