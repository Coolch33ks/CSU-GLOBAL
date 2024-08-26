package CT;

public class Student {
    // Fields for the Student class
    int rollno;
    String name;
    String address;

    // Constructor to initialize the student object
    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    // toString method to return the string representation of the student object
    @Override
    public String toString() {
        return "Roll No: " + rollno + ", Name: " + name + ", Address: " + address;
    }
}