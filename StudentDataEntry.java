package Shapes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

//Main class to handle student data entry and output
public class StudentDataEntry {
    public static void main(String[] args) {
        LinkedList<Student> studentList = new LinkedList<>();  //LinkedList to store Student objects
        Scanner scanner = new Scanner(System.in);  //Scanner for user input
        String choice;  //Variable to store user's choice for more entries

        do {
            //Prompt user for student details
            System.out.println("Enter student's name: ");
            String name = scanner.nextLine();

            System.out.println("Enter student's address: ");
            String address = scanner.nextLine();

            double GPA = 0.0;
            while (true) {
                try {
                    System.out.println("Enter student's GPA: ");
                    GPA = Double.parseDouble(scanner.nextLine());
                    if (GPA < 0.0 || GPA > 4.0) {
                        throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a numeric value for GPA.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            //Add the new student to the linked list
            studentList.add(new Student(name, address, GPA));

            //Ask user if they want to add another student
            System.out.println("Do you want to enter another student's data? (yes/no): ");
            choice = scanner.nextLine().trim().toLowerCase();
        } while (choice.equals("yes"));

        //Sort the list of students by name in ascending order
        Collections.sort(studentList, Comparator.comparing(Student::getName));

        //Output the sorted list to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            for (Student student : studentList) {
                writer.write(student.toString());
                writer.newLine();
            }
            System.out.println("Student data has been written to 'students.txt'.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
