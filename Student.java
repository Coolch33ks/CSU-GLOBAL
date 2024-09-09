package Shapes;

import java.util.Objects;

//Student class to hold student data
public class Student {
 private String name;
 private String address;
 private double GPA;

 //Constructor
 public Student(String name, String address, double GPA) {
     this.name = name;
     this.address = address;
     this.GPA = GPA;
 }

 //Getter for the name 
 public String getName() {
     return name;
 }

 //Getter for the address 
 public String getAddress() {
     return address;
 }

 //Getter for the GPA 
 public double getGPA() {
     return GPA;
 }

 //Override the toString method to display student information
 @Override
 public String toString() {
     return "Name: " + name + ", Address: " + address + ", GPA: " + GPA;
 }

 //Override equals and hashCode for proper comparison in sorting
 @Override
 public boolean equals(Object o) {
     if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;
     Student student = (Student) o;
     return Double.compare(student.GPA, GPA) == 0 &&
             Objects.equals(name, student.name) &&
             Objects.equals(address, student.address);
 }

 @Override
 public int hashCode() {
     return Objects.hash(name, address, GPA);
 }
}
