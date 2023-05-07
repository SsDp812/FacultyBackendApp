package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.Faculty;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacultyDao {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void save(Faculty faculty){
        sessionFactory.getCurrentSession().persist(faculty);
    }

    @Transactional
    public void update(Faculty faculty){
        sessionFactory.getCurrentSession().update(faculty);
    }

    @Transactional
    public void delete(Long id){
        sessionFactory.getCurrentSession().delete(id);
    }

    @Transactional
    public Faculty getFacultyById(Long id){
        return sessionFactory.getCurrentSession().get(Faculty.class,id);
    }
    @Transactional
    public List<Faculty> getAllFaculties(){
        return sessionFactory.getCurrentSession().createQuery("SELECT f FROM Faculty f",Faculty.class)
                .getResultList();
    }
}
