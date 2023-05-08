package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.Student;
import jakarta.transaction.Transactional;
import jakarta.websocket.Session;
import org.apache.naming.factory.MailSessionFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import java.util.List;

@Repository
public class StudentDao {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void save(Student student){
        sessionFactory.openSession().save(student);
    }
    @Transactional
    public void update(Student student){
        sessionFactory.openSession().update(student);
    }
    @Transactional
    public void delete(Long id){
        sessionFactory.openSession().delete(id);
    }
    @Transactional
    public Student getStudentById(Long id){
        return sessionFactory.openSession().get(Student.class,id);
    }
    @Transactional
    public List<Student> getAllStudents(){
        return sessionFactory.openSession().createQuery("SELECT s FROM Student s", Student.class)
                .getResultList();
    }
}
