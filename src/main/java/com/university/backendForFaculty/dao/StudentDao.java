package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.Student;
import jakarta.transaction.Transactional;
import jakarta.websocket.Session;
import org.apache.naming.factory.MailSessionFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import java.util.List;

@Component
public class StudentDao {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void save(Student student){
        sessionFactory.getCurrentSession().persist(student);
    }
    @Transactional
    public void update(Student student){
        sessionFactory.getCurrentSession().update(student);
    }
    @Transactional
    public void delete(Long id){
        sessionFactory.getCurrentSession().delete(id);
    }
    @Transactional
    public Student getStudentById(Long id){
        return sessionFactory.getCurrentSession().get(Student.class,id);
    }
    @Transactional
    public List<Student> getAllStudents(){
        return sessionFactory.getCurrentSession().createQuery("SELECT s FROM Student s", Student.class)
                .getResultList();
    }
}
