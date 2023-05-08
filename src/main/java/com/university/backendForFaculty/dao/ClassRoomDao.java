package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.ClassRoom;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassRoomDao {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void save(ClassRoom classRoom){
        sessionFactory.openSession().save(classRoom);
    }

    @Transactional
    public void update(ClassRoom classRoom){
        sessionFactory.openSession().update(classRoom);
    }

    @Transactional
    public void delete(Long id){
        sessionFactory.openSession().delete(id);
    }

    @Transactional
    public ClassRoom getClassRoomById(Long id){
        return sessionFactory.openSession().get(ClassRoom.class,id);
    }

    @Transactional
    public List<ClassRoom> getAllClassRooms(){
        return sessionFactory.openSession().createQuery("SELECT c from ClassRoom c",ClassRoom.class)
                .getResultList();
    }
}
