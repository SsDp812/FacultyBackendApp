package com.university.backendForFaculty.Controllers;


import com.university.backendForFaculty.dao.ClassRoomDao;
import com.university.backendForFaculty.models.ClassRoom;
import com.university.backendForFaculty.services.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classrooms")
public class ClassRoomController {

    @Autowired
    private ClassRoomService service;

    @GetMapping("/")
    public List<ClassRoom> getAll(){
       return service.getAllClassRooms();
    }

    @GetMapping("/{id}")
    public ClassRoom getById(@PathVariable Long id){
        return service.getClassRoomById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }

    @PostMapping("/update")
    public void update(@RequestParam(name = "name") String name,
                       @RequestParam(name = "description") String description,
                       @RequestParam(name = "capacity") int capacity,
                       @RequestParam(name = "id") Long id){
        service.update(new ClassRoom(id,name,description,capacity));
    }

    @PostMapping("/create")
    public void create(@RequestParam(name = "name") String name,
                       @RequestParam(name = "description") String description,
                       @RequestParam(name = "capacity") int capacity){
        service.save(new ClassRoom(name,description,capacity));
    }

}
