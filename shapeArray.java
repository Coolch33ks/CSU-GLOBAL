package Shapes;

public class shapeArray {
	  public static void main(String[] args) {
	        // Instantiate one triangle, circle, and rectangle
	        shape triangle = new triangle(3, 5, 7);
	        shape circle = new circle(8);
	        shape rectangle = new rectangle(1,4);

	        //Store in an array
	        shape[] shapeArray = {triangle, circle, rectangle};

	        //Loop through the array and print out the instance data
	        for (shape shape : shapeArray) {
	            System.out.println(shape.toString());
	        }
	    }

}
