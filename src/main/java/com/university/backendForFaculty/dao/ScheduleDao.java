package com.university.backendForFaculty.dao;


import com.university.backendForFaculty.models.Schedule;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleDao {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void save(Schedule schedule){
        sessionFactory.openSession().save(schedule);
    }
    @Transactional
    public void update(Schedule schedule){
        sessionFactory.openSession().update(schedule);
    }
    @Transactional
    public void delete(Long id){
        sessionFactory.openSession().delete(id);
    }

    @Transactional
    public Schedule getScheduleById(Long id){
        return sessionFactory.openSession().get(Schedule.class,id);
    }
    @Transactional
    public List<Schedule> getAllSchedules(){
        return sessionFactory.openSession().createQuery("SELECT s FROM Schedule s", Schedule.class)
                .getResultList();
    }
}
