package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.ClassRoom;
import jakarta.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassRoomDao {
    SessionFactory sessionFactory;

    private org.hibernate.Session session;

    @Autowired
    public ClassRoomDao(SessionFactory factory){
        sessionFactory = factory;
        session = (org.hibernate.Session) sessionFactory.openSession();
    }

    @Transactional
    public void save(ClassRoom classRoom){
        session.save(classRoom);
    }

    @Transactional
    public void update(ClassRoom classRoom){
        ClassRoom classRoomToUpdate = getClassRoomById(classRoom.getId());
        classRoomToUpdate.setName(classRoom.getName());
        classRoomToUpdate.setDescription(classRoom.getDescription());
        classRoomToUpdate.setCapacity(classRoom.getCapacity());
        session.update(classRoomToUpdate);
    }

    @Transactional
    public void delete(Long id){
        session.getTransaction().begin();
        try {
            Query query = session.createQuery("DELETE FROM ClassRoom WHERE id=:id");
            query.setParameter("id", id);
            query.executeUpdate();
        } catch (HibernateException e) {
            throw e;
        }
        session.getTransaction().commit();
    }

    @Transactional
    public ClassRoom getClassRoomById(Long id){
        return session.get(ClassRoom.class,id);
    }

    @Transactional
    public List<ClassRoom> getAllClassRooms(){
        return session.createQuery("SELECT c from ClassRoom c",ClassRoom.class)
                .getResultList();
    }
}
