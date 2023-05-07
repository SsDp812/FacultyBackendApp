package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.Course;
import jakarta.persistence.Column;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void save(Course course){
        sessionFactory.getCurrentSession().persist(course);
    }

    @Transactional
    public void update(Course course){
        sessionFactory.getCurrentSession().update(course);
    }

    @Transactional
    public void delete(Long id){
        sessionFactory.getCurrentSession().delete(id);
    }

    @Transactional
    public Course getCourseById(Long id){
        return sessionFactory.getCurrentSession().get(Course.class,id);
    }
    @Transactional
    public List<Course> getAllCourses(){
        return sessionFactory.getCurrentSession().createQuery("SELECT c FROM Course c",Course.class)
                .getResultList();
    }
}
