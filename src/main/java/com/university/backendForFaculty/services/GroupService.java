package com.university.backendForFaculty.services;

import com.university.backendForFaculty.dao.CourseDao;
import com.university.backendForFaculty.dao.GroupDao;
import com.university.backendForFaculty.models.Course;
import com.university.backendForFaculty.models.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    GroupDao dao;

    public void save(Group group){
        dao.save(group);
    }

    public void update(Group group){
        dao.update(group);
    }

    public void delete(Long id){
        dao.delete(id);
    }

    public Group getGroupById(Long id){
        return dao.getGroupById(id);
    }
    public List<Group> getAllGroups(){
        return dao.getAllGroups();
    }
}
