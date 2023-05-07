package com.university.backendForFaculty.services;


import com.university.backendForFaculty.dao.CourseDao;
import com.university.backendForFaculty.dao.MarkDao;
import com.university.backendForFaculty.models.Course;
import com.university.backendForFaculty.models.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {
    @Autowired
    MarkDao dao;

    public void save(Mark mark){
        dao.save(mark);
    }

    public void update(Mark mark){
        dao.update(mark);
    }

    public void delete(Long id){
        dao.delete(id);
    }

    public Mark getMarkById(Long id){
        return dao.getMarkById(id);
    }
    public List<Mark> getAllMarks(){
        return dao.getAllMarks();
    }
}
