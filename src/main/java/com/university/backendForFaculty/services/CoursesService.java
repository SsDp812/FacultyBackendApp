package com.university.backendForFaculty.services;

import com.university.backendForFaculty.dao.CourseDao;
import com.university.backendForFaculty.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {
    @Autowired
    CourseDao dao;


    public void save(Course course){
        dao.save(course);
    }

    public void update(Course course){
        dao.update(course);
    }

    public void delete(Long id){
        dao.delete(id);
    }

    public Course getCourseById(Long id){
        return dao.getCourseById(id);
    }
    public List<Course> getAllCourses(){
        return dao.getAllCourses();
    }
}
