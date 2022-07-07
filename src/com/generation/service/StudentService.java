package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent( Student student )
    {
        students.put( student.getId(), student );
    }

    public Student findStudent( String studentId )
    {
        if ( students.containsKey( studentId ) )
        {
            return students.get( studentId );
        }
        return null;
    }

    public boolean isSubscribed( String studentId )
    {
        //TODO implement this method
        if (students.containsKey(studentId)){
            return true;
        } else {return false;}
    }

    public void showSummary()
    {
        //TODO implement
        System.out.println("Student summary:");
        for(Student studentList : students.values()){
            System.out.println(studentList);
        }
    }

    public void enrollToCourse( String studentId, Course course )
    {
        if ( students.containsKey( studentId ) )
        {
            students.get( studentId ).enrollToCourse( course );
        }
    }

    public void registerApprovedCourse( Student student, Course course )
    {
        student.registerApprovedCourse(course);
        student.removeFromCourse(course);
    }

}
