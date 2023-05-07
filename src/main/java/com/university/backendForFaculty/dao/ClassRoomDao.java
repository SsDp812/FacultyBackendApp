package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.ClassRoom;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassRoomDao {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void save(ClassRoom classRoom){
        sessionFactory.getCurrentSession().persist(classRoom);
    }

    @Transactional
    public void update(ClassRoom classRoom){
        sessionFactory.getCurrentSession().update(classRoom);
    }

    @Transactional
    public void delete(Long id){
        sessionFactory.getCurrentSession().delete(id);
    }

    @Transactional
    public ClassRoom getClassRoomById(Long id){
        return sessionFactory.getCurrentSession().get(ClassRoom.class,id);
    }

    @Transactional
    public List<ClassRoom> getAllClassRooms(){
        return sessionFactory.getCurrentSession().createQuery("SELECT c from ClassRoom c",ClassRoom.class)
                .getResultList();
    }
}
