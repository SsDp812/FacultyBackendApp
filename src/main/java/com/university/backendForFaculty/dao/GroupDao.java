package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.Group;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupDao {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void save(Group group){
        sessionFactory.getCurrentSession().persist(group);
    }

    @Transactional
    public void update(Group group){
        sessionFactory.getCurrentSession().update(group);
    }

    @Transactional
    public void delete(Long id){
        sessionFactory.getCurrentSession().update(id);
    }

    @Transactional
    public Group getGroupById(Long id){
        return sessionFactory.getCurrentSession().get(Group.class,id);
    }
    @Transactional
    public List<Group> getAllGroups(){
        return sessionFactory.getCurrentSession().createQuery("SELECT g FROM Group g",Group.class)
                .getResultList();
    }
}

