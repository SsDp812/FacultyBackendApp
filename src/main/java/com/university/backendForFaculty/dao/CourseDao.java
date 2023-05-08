package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.Course;
import jakarta.persistence.Column;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void save(Course course){
        sessionFactory.openSession().save(course);
    }

    @Transactional
    public void update(Course course){
        sessionFactory.openSession().update(course);
    }

    @Transactional
    public void delete(Long id){
        sessionFactory.openSession().delete(id);
    }

    @Transactional
    public Course getCourseById(Long id){
        return sessionFactory.openSession().get(Course.class,id);
    }
    @Transactional
    public List<Course> getAllCourses(){
        return sessionFactory.openSession().createQuery("SELECT c FROM Course c",Course.class)
                .getResultList();
    }
}
