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
        sessionFactory.getCurrentSession().persist(schedule);
    }
    @Transactional
    public void update(Schedule schedule){
        sessionFactory.getCurrentSession().update(schedule);
    }
    @Transactional
    public void delete(Long id){
        sessionFactory.getCurrentSession().delete(id);
    }

    @Transactional
    public Schedule getScheduleById(Long id){
        return sessionFactory.getCurrentSession().get(Schedule.class,id);
    }
    @Transactional
    public List<Schedule> getAllSchedules(){
        return sessionFactory.getCurrentSession().createQuery("SELECT s FROM Schedule s", Schedule.class)
                .getResultList();
    }
}
