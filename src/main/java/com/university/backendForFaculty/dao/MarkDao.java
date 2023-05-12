package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.Mark;
import jakarta.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarkDao {
    SessionFactory sessionFactory;

    private org.hibernate.Session session;

    @Autowired
    public MarkDao(SessionFactory factory){
        sessionFactory = factory;
        session = (org.hibernate.Session) sessionFactory.openSession();
    }

    @Transactional
    public void save(Mark mark){
        session.save(mark);
    }

    @Transactional
    public void update(Mark mark){
        Mark markToUpdate = getMarkById(mark.getId());
        markToUpdate.setCourse(mark.getCourse());
        markToUpdate.setStudent(mark.getStudent());
        markToUpdate.setScore(mark.getScore());
        session.update(markToUpdate);
    }

    @Transactional
    public void delete(Long id){
        session.getTransaction().begin();
        try {
            Query query = session.createQuery("DELETE FROM Mark WHERE id=:id");
            query.setParameter("id", id);
            query.executeUpdate();
        } catch (HibernateException e) {
            throw e;
        }
        session.getTransaction().commit();
    }

    @Transactional
    public Mark getMarkById(Long id){
        return session.get(Mark.class,id);
    }
    @Transactional
    public List<Mark> getAllMarks(){
        return session.createQuery("SELECT m FROM Mark m", Mark.class)
                .getResultList();
    }
}
