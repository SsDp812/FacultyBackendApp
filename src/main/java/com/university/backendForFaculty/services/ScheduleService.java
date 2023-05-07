package com.university.backendForFaculty.services;


import com.university.backendForFaculty.dao.CourseDao;
import com.university.backendForFaculty.dao.ScheduleDao;
import com.university.backendForFaculty.models.Course;
import com.university.backendForFaculty.models.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    ScheduleDao dao;

    public void save(Schedule schedule){
        dao.save(schedule);
    }

    public void update(Schedule schedule){
        dao.update(schedule);
    }

    public void delete(Long id){
        dao.delete(id);
    }

    public Schedule getScheduleById(Long id){
        return dao.getScheduleById(id);
    }
    public List<Schedule> getAllSchedules(){
        return dao.getAllSchedules();
    }
}
