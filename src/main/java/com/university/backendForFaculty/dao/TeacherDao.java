package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.Teacher;
import jakarta.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeacherDao {
    SessionFactory sessionFactory;

    private org.hibernate.Session session;

    @Autowired
    public TeacherDao(SessionFactory factory){
        sessionFactory = factory;
        session = (org.hibernate.Session) sessionFactory.openSession();
    }

    @Transactional
    public void save(Teacher teacher){
        session.save(teacher);
    }

    @Transactional
    public void update(Teacher teacher){
        Teacher teacherToUpdate = getTeacherById(teacher.getId());
        teacherToUpdate.setAddress(teacher.getAddress());
        teacherToUpdate.setBirthday(teacher.getBirthday());
        teacherToUpdate.setMail(teacher.getMail());
        teacherToUpdate.setName(teacher.getName());
        teacherToUpdate.setMiddle(teacher.getMiddle());
        teacherToUpdate.setMobile(teacher.getMobile());
        teacherToUpdate.setSurname(teacher.getSurname());
        session.update(teacherToUpdate);
    }

    @Transactional
    public void delete(Long id){
        session.getTransaction().begin();
        try {
            Query query = session.createQuery("DELETE FROM Teacher WHERE id=:id");
            query.setParameter("id", id);
            query.executeUpdate();
        } catch (HibernateException e) {
            throw e;
        }
        session.getTransaction().commit();
    }

    public Teacher getTeacherById(Long id){
        return session.get(Teacher.class,id);
    }
    public List<Teacher> getAllTeachers(){
        return session.createQuery("SELECT t FROM Teacher t", Teacher.class)
                .getResultList();
    }
}
