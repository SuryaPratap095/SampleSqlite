package com.example.surya.samplesqlite;

/**
 * Created by surya on 12/11/16.
 */
public class Student {

    private int studentID;
    private String FirstName;
    private String LAstName;
    private String email;
    private int age;
    private String city;

    public Student() {
    }

    public Student(int studentID, String firstName, String LAstName, int age, String email, String city) {
        this.studentID = studentID;
        FirstName = firstName;
        this.LAstName = LAstName;
        this.email = email;
        this.age = age;
        this.city = city;
    }

    public Student(String firstName, String LAstName, int age, String email, String city) {
        this.FirstName = firstName;
        this.LAstName = LAstName;
        this.email = email;
        this.age = age;
        this.city = city;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLAstName() {
        return LAstName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setLAstName(String LAstName) {
        this.LAstName = LAstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "FirstName='" + FirstName + '\'' +
                ", LAstName='" + LAstName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
