package CT;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Creating an ArrayList to store Student objects
        ArrayList<Student> students = new ArrayList<>();

        // Adding 10 Student objects to the ArrayList
        students.add(new Student(3, "Alice", "123 Street A"));
        students.add(new Student(1, "Bob", "456 Street B"));
        students.add(new Student(10, "Charlie", "789 Street C"));
        students.add(new Student(5, "David", "101 Street D"));
        students.add(new Student(2, "Eve", "112 Street E"));
        students.add(new Student(4, "Frank", "131 Street F"));
        students.add(new Student(9, "Grace", "415 Street G"));
        students.add(new Student(8, "Heidi", "162 Street H"));
        students.add(new Student(6, "Ivy", "718 Street I"));
        students.add(new Student(7, "Judy", "194 Street J"));

        // Sorting by name
        System.out.println("Sorting by Name:");
        SelectionSort.selectionSort(students, new NameComparator());
        for (Student s : students) {
            System.out.println(s);
        }

        // Sorting by roll number
        System.out.println("\nSorting by Roll No:");
        SelectionSort.selectionSort(students, new RollNoComparator());
        for (Student s : students) {
            System.out.println(s);
        }
    }
}