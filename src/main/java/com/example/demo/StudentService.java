package com.example.demo;


import io.vavr.collection.List;

public class StudentService {

    private List<Student> students = List.empty();

    List<Student> getStudents() {
        return students;
    }

    Student addStudent(NewStudent student) {
        Student newStudent = new Student(students.size(), student.name, student.number, student.grupa);
        students = students.prepend(newStudent);
        return newStudent;
    }
}
