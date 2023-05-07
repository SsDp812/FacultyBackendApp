package com.university.backendForFaculty.services;


import com.university.backendForFaculty.dao.CourseDao;
import com.university.backendForFaculty.dao.FacultyDao;
import com.university.backendForFaculty.models.Course;
import com.university.backendForFaculty.models.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    FacultyDao dao;

    public void save(Faculty faculty){
        dao.save(faculty);
    }

    public void update(Faculty faculty){
        dao.update(faculty);
    }

    public void delete(Long id){
        dao.delete(id);
    }

    public Faculty getFacultyById(Long id){
        return dao.getFacultyById(id);
    }
    public List<Faculty> getAllFaculties(){
        return dao.getAllFaculties();
    }
}
