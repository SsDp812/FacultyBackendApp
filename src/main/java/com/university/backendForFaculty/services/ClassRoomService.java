package com.university.backendForFaculty.services;


import com.university.backendForFaculty.dao.ClassRoomDao;
import com.university.backendForFaculty.models.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService {
    @Autowired
    ClassRoomDao dao;

    public void save(ClassRoom classRoom){
        dao.save(classRoom);
    }

    public void update(ClassRoom classRoom){
        dao.update(classRoom);
    }

    public void delete(Long id){
        dao.delete(id);
    }

    public ClassRoom getClassRoomById(Long id){
        return dao.getClassRoomById(id);
    }

    public List<ClassRoom> getAllClassRooms(){
        return dao.getAllClassRooms();
    }
}
