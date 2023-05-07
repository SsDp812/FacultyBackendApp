package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.Teacher;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherDao {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void save(Teacher teacher){
        sessionFactory.getCurrentSession().persist(teacher);
    }

    @Transactional
    public void update(Teacher teacher){
        sessionFactory.getCurrentSession().update(teacher);
    }

    @Transactional
    public void delete(Long id){
        sessionFactory.getCurrentSession().delete(id);
    }

    public Teacher getTeacherById(Long id){
        return sessionFactory.getCurrentSession().get(Teacher.class,id);
    }
    public List<Teacher> getAllTeachers(){
        return sessionFactory.getCurrentSession().createQuery("SELECT t FROM Teacher t", Teacher.class)
                .getResultList();
    }
}
