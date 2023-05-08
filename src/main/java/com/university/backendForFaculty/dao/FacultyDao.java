package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.Faculty;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacultyDao {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void save(Faculty faculty){
        sessionFactory.openSession().save(faculty);
    }

    @Transactional
    public void update(Faculty faculty){
        sessionFactory.openSession().update(faculty);
    }

    @Transactional
    public void delete(Long id){
        sessionFactory.openSession().delete(id);
    }

    @Transactional
    public Faculty getFacultyById(Long id){
        return sessionFactory.openSession().get(Faculty.class,id);
    }
    @Transactional
    public List<Faculty> getAllFaculties(){
        return sessionFactory.openSession().createQuery("SELECT f FROM Faculty f",Faculty.class)
                .getResultList();
    }
}
