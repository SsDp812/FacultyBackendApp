package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.Faculty;
import jakarta.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacultyDao {
    SessionFactory sessionFactory;

    private org.hibernate.Session session;

    @Autowired
    public FacultyDao(SessionFactory factory){
        sessionFactory = factory;
        session = (org.hibernate.Session) sessionFactory.openSession();
    }

    @Transactional
    public void save(Faculty faculty){
        session.save(faculty);
    }

    @Transactional
    public void update(Faculty faculty){
        Faculty facultyToUpdate = getFacultyById(faculty.getId());
        facultyToUpdate.setName(faculty.getName());
        facultyToUpdate.setDescription(faculty.getDescription());
        facultyToUpdate.setDean(faculty.getDean());
        session.update(facultyToUpdate);
    }

    @Transactional
    public void delete(Long id){
        session.getTransaction().begin();
        try {
            Query query = session.createQuery("DELETE FROM Faculty WHERE id=:id");
            query.setParameter("id", id);
            query.executeUpdate();
        } catch (HibernateException e) {
            throw e;
        }
        session.getTransaction().commit();
    }

    @Transactional
    public Faculty getFacultyById(Long id){
        return session.get(Faculty.class,id);
    }
    @Transactional
    public List<Faculty> getAllFaculties(){
        return session.createQuery("SELECT f FROM Faculty f",Faculty.class)
                .getResultList();
    }
}
