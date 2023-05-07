package com.university.backendForFaculty.services;


import com.university.backendForFaculty.dao.CourseDao;
import com.university.backendForFaculty.dao.TeacherDao;
import com.university.backendForFaculty.models.Course;
import com.university.backendForFaculty.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherDao dao;


    public void save(Teacher teacher){
        dao.save(teacher);
    }

    public void update(Teacher teacher){
        dao.update(teacher);
    }

    public void delete(Long id){
        dao.delete(id);
    }

    public Teacher getTeacherById(Long id){
        return dao.getTeacherById(id);
    }
    public List<Teacher> getAllTeachers(){
        return dao.getAllTeachers();
    }
}
