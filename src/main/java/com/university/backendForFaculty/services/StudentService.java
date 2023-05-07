package com.university.backendForFaculty.services;


import com.university.backendForFaculty.dao.CourseDao;
import com.university.backendForFaculty.dao.StudentDao;
import com.university.backendForFaculty.models.Course;
import com.university.backendForFaculty.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDao dao;


    public void save(Student student){
        dao.save(student);
    }

    public void update(Student student){
        dao.update(student);
    }

    public void delete(Long id){
        dao.delete(id);
    }

    public Student getStudentById(Long id){
        return dao.getStudentById(id);
    }
    public List<Student> getAllStudents(){
        return dao.getAllStudents();
    }
}
