package CT;

/*Using recursion, this program will allow a user 
to enter five numbers and this program will produce the sum. */

import java.util.Scanner;

public class Calculator {

 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     double[] numbers = new double[5];
     
     System.out.println("Please enter five numbers:");

     //Getting the input from the user
     for (int i = 0; i < numbers.length; i++) {
         try {
             System.out.print("Number " + (i + 1) + ": ");
             numbers[i] = scanner.nextDouble();
         } catch (Exception e) {
             System.out.println("Invalid input. Please enter a valid number.");
             scanner.next(); //Clear the invalid input
             i--; //Step back to re-enter the value
         }
     }

     scanner.close();

     //Calculating the sum using a recursive method
     try {
         double sum = calculateSum(numbers, numbers.length);
         System.out.println("The sum of the entered numbers is: " + sum);
     } catch (Exception e) {
         System.out.println("An error occurred while calculating the sum: " + e.getMessage());
     }
 }

 /**
  * Recursive method to calculate the sum of numbers in an array.
  * 
  * @param numbers the array of numbers
  * @param n the number of elements to include in the sum
  * @return the sum of the first n numbers in the array
  */
 public static double calculateSum(double[] numbers, int n) {
     //Base case: if only one number is left, return that number
     if (n == 1) {
         return numbers[0];
     }
     //Recursive case: add the last number to the sum of the rest
     return numbers[n - 1] + calculateSum(numbers, n - 1);
 }
}
