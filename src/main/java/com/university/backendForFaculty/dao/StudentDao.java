package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.Student;
import jakarta.transaction.Transactional;
import jakarta.websocket.Session;
import org.apache.naming.factory.MailSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import java.util.List;



@Repository
public class StudentDao {

    SessionFactory sessionFactory;

    private org.hibernate.Session session;

    @Autowired
    public StudentDao(SessionFactory factory){
        sessionFactory = factory;
        session = (org.hibernate.Session) sessionFactory.openSession();
    }

    @Transactional
    public void save(Student student){
        session.save(student);
    }
    @Transactional
    public void update(Student student){
        Student studentToUpdate = getStudentById(student.getId());
        studentToUpdate.setAddress(student.getAddress());
        studentToUpdate.setName(student.getName());
        studentToUpdate.setSurname(student.getSurname());
        studentToUpdate.setBirthday(student.getBirthday());
        studentToUpdate.setMail(student.getMail());
        studentToUpdate.setMiddle(student.getMiddle());
        studentToUpdate.setMobile(student.getMobile());
        session.update(studentToUpdate);
    }
    @Transactional
    public void delete(Long id){
        session.getTransaction().begin();
        try {
            Query query = session.createQuery("DELETE FROM Student WHERE id=:id");
            query.setParameter("id", id);
            query.executeUpdate();
        } catch (HibernateException e) {
            throw e;
        }
        session.getTransaction().commit();
    }

    @Transactional
    public Student getStudentById(Long id){
        return session.get(Student.class,id);
    }
    @Transactional
    public List<Student> getAllStudents(){
        return session.createQuery("SELECT s FROM Student s", Student.class)
                .getResultList();
    }
}
