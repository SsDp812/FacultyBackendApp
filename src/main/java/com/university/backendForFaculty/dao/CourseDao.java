package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.Course;
import jakarta.persistence.Column;
import jakarta.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao {
    SessionFactory sessionFactory;

    private org.hibernate.Session session;

    @Autowired
    public CourseDao(SessionFactory factory){
        sessionFactory = factory;
        session = (org.hibernate.Session) sessionFactory.openSession();
    }
    @Transactional
    public void save(Course course){
        session.save(course);
    }

    @Transactional
    public void update(Course course){
        Course courseToUpdate = getCourseById(course.getId());
        courseToUpdate.setName(course.getName());
        courseToUpdate.setDescription(course.getDescription());
        courseToUpdate.setTeacher(course.getTeacher());
        session.update(courseToUpdate);
    }

    @Transactional
    public void delete(Long id){
        session.getTransaction().begin();
        try {
            Query query = session.createQuery("DELETE FROM Course WHERE id=:id");
            query.setParameter("id", id);
            query.executeUpdate();
        } catch (HibernateException e) {
            throw e;
        }
        session.getTransaction().commit();
    }

    @Transactional
    public Course getCourseById(Long id){
        System.out.println("-- --");
        System.out.println(id);
        System.out.println(session.get(Course.class,id));
        return session.get(Course.class,id);
    }
    @Transactional
    public List<Course> getAllCourses(){
        return session.createQuery("SELECT c FROM Course c",Course.class)
                .getResultList();
    }
}
