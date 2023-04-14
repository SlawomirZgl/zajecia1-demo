package com.example.demo;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class StudentServiceTest {

//    @Test
//    public void getStudents() {
//    }

    @Test
    public void addStudent() {
        final StudentService service = new StudentService();
        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        assertNotNull(created);
    }

    @Test
    public void addStudentIsReturned() {
        final StudentService service = new StudentService();
        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        final List<Student> all = service.getStudents();
        assertEquals("Student1", all.head().name);
    }

    @Test
    public void addStudentNewID() {
        final StudentService service = new StudentService();
        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        final Student created2 = service.addStudent(new NewStudent("Student2", "21-2-3", "IM"));

        final List<Student> all = service.getStudents();
        assertNotEquals(created.id, created2.id);
    }

    @Test
    public void getEmptyList() {
        final StudentService service = new StudentService();
        List<Student> students = service.getStudents();

        assertTrue(students.isEmpty());
    }
}