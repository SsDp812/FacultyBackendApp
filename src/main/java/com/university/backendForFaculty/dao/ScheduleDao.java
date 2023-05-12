package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.Schedule;
import jakarta.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleDao {
    SessionFactory sessionFactory;

    private org.hibernate.Session session;

    @Autowired
    public ScheduleDao(SessionFactory factory){
        sessionFactory = factory;
        session = (org.hibernate.Session) sessionFactory.openSession();
    }

    @Transactional
    public void save(Schedule schedule){
        session.save(schedule);
    }
    @Transactional
    public void update(Schedule schedule){
        Schedule scheduleToUpdate = getScheduleById(schedule.getId());
        scheduleToUpdate.setCourse(schedule.getCourse());
        scheduleToUpdate.setClassRoom(schedule.getClassRoom());
        scheduleToUpdate.setDayOfWeek(schedule.getDayOfWeek());
        scheduleToUpdate.setTeacher(schedule.getTeacher());
        scheduleToUpdate.setStart_time(schedule.getStart_time());
        scheduleToUpdate.setEnd_time(schedule.getEnd_time());
        session.update(scheduleToUpdate);
    }
    @Transactional
    public void delete(Long id){
        session.getTransaction().begin();
        try {
            Query query = session.createQuery("DELETE FROM Schedule WHERE id=:id");
            query.setParameter("id", id);
            query.executeUpdate();
        } catch (HibernateException e) {
            throw e;
        }
        session.getTransaction().commit();
    }

    @Transactional
    public Schedule getScheduleById(Long id){
        return session.get(Schedule.class,id);
    }
    @Transactional
    public List<Schedule> getAllSchedules(){
        return session.createQuery("SELECT s FROM Schedule s", Schedule.class)
                .getResultList();
    }
}
