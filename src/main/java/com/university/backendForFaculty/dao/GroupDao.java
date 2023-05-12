package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.Group;
import jakarta.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupDao {
    SessionFactory sessionFactory;

    private org.hibernate.Session session;

    @Autowired
    public GroupDao(SessionFactory factory){
        sessionFactory = factory;
        session = (org.hibernate.Session) sessionFactory.openSession();
    }

    @Transactional
    public void save(Group group){
        session.save(group);
    }

    @Transactional
    public void update(Group group){
        Group groupToUpdate = getGroupById(group.getId());
        groupToUpdate.setCourse(group.getCourse());
        groupToUpdate.setName(group.getName());
        session.update(groupToUpdate);
    }

    @Transactional
    public void delete(Long id){
        session.getTransaction().begin();
        try {
            Query query = session.createQuery("DELETE FROM Group WHERE id=:id");
            query.setParameter("id", id);
            query.executeUpdate();
        } catch (HibernateException e) {
            throw e;
        }
        session.getTransaction().commit();
    }

    @Transactional
    public Group getGroupById(Long id){
        return session.get(Group.class,id);
    }
    @Transactional
    public List<Group> getAllGroups(){
        return session.createQuery("SELECT g FROM Group g",Group.class)
                .getResultList();
    }
}

