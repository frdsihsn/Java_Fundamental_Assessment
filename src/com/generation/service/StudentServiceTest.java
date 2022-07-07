package com.generation.service;

import com.generation.model.Student;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;


public class StudentServiceTest {
    private final StudentService studentService= new StudentService();
    Student student1;
    Student student2;
    Student student3;
    Student student4;

    @Before
    public void setup() throws ParseException {
        DateFormat formatter = new SimpleDateFormat( "MM/dd/yyyy");
         student1 = new Student("001", "Firdaus", "firdaus@gmail.com", formatter.parse("18/12/1997"));
         student2 = new Student("002", "Frodo", "fodo@gmail.com", formatter.parse("13/12/1997"));
         student3 = new Student("003", "Sal", "sal@gmail.com", formatter.parse("11/12/1997"));
         student4 = new Student("004", "John", "john@gmail.com", formatter.parse("12/12/1997"));

        studentService.subscribeStudent(student2);
        studentService.subscribeStudent(student3);
        studentService.subscribeStudent(student4);


    }



    @Test
    public void findStudent(){
        studentService.subscribeStudent(student1);
        String studentId = student1.getId();
        assertEquals(student1, studentService.findStudent(studentId));
    }

    @Test
    public void  isSubscribed(){
        studentService.subscribeStudent(student2);
        assertTrue(studentService.isSubscribed(student2.getId()));
    }
}