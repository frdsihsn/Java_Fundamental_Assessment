package com.generation.service;
import com.generation.model.Course;
import com.generation.model.Module;
import com.generation.model.Student;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class CourseServiceTest {

    private final CourseService courseService = new CourseService();
    Module module = new Module( "INTRO-CS", "Introduction to Computer Science",
            "Introductory module for the generation technical programs" );
    Course course1;
    Course course2;
    Course course3;

    @Before
    public void setup(){
        course1 = new Course("INTRO-CS-1", "Introduction to Computer Science", 9, module );
        course2 = new Course( "INTRO-CS-2", "Introduction to Algorithms", 9, module );
        course3 = new Course( "INTRO-CS-3", "Algorithm Design and Problem Solving - Introduction ", 9, module );
        courseService.registerCourse(course1);
        courseService.registerCourse(course2);
        courseService.registerCourse(course3);
    }

    @Test
    public void getCourse(){
        assertEquals(course1, courseService.getCourse("INTRO-CS-1"));
    }

    @Test
    public void showEnrolledStudents() throws ParseException {

        DateFormat formatter = new SimpleDateFormat( "MM/dd/yyyy");
        Student student1 = new Student("001", "Firdaus", "firdaus@gmail.com", formatter.parse("18/12/1997"));
        String courseId = course1.getCode();
        courseService.enrollStudent(courseId, student1);
        assertTrue(courseService.showEnrolledStudents(courseId).contains(student1));
    }
}