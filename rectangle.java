package Shapes;

public class rectangle extends shape {

	private int width;
    private int length;

  

	//Constructor
    public rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    //Calculate the area of the rectangle
    @Override
    public double area() {
        return width * length;
    }

    //Calculate the perimeter of the rectangle
    @Override
    public double perimeter() {
        return 2 * (width + length);
    }

    //Return the string representation of the rectangle
    @Override
    public String toString() {
        return "Rectangle: " +
                "Area = " + area() +
                ", Perimeter = " + perimeter();
    }

}
