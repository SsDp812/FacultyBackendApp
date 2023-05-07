package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.Mark;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarkDao {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void save(Mark mark){
        sessionFactory.getCurrentSession().persist(mark);
    }

    @Transactional
    public void update(Mark mark){
        sessionFactory.getCurrentSession().update(mark);
    }

    @Transactional
    public void delete(Long id){
        sessionFactory.getCurrentSession().delete(id);
    }

    @Transactional
    public Mark getMarkById(Long id){
        return sessionFactory.getCurrentSession().get(Mark.class,id);
    }
    @Transactional
    public List<Mark> getAllMarks(){
        return sessionFactory.getCurrentSession().createQuery("SELECT m FROM Mark m", Mark.class)
                .getResultList();
    }
}
