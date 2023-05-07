package com.university.backendForFaculty.Controllers;


import com.university.backendForFaculty.dao.FacultyDao;
import com.university.backendForFaculty.dao.GroupDao;
import com.university.backendForFaculty.models.Faculty;
import com.university.backendForFaculty.models.Group;
import com.university.backendForFaculty.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupService service;

    @GetMapping("/")
    public List<Group> getAll(){
        return service.getAllGroups();
    }

    @GetMapping("/{id}")
    public Group getById(@PathVariable Long id){
        return service.getGroupById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }

    @PostMapping("/update/{id}")
    public void update(@RequestParam(name = "name") String name,
                       @RequestParam(name = "course_id") String course_id,
                       @RequestParam(name = "student_id") Long student_id){
        //TODO groupController1

    }

    @PostMapping("/create")
    public void create(@RequestParam(name = "name") String name,
                       @RequestParam(name = "course_id") String course_id,
                       @RequestParam(name = "student_id") Long student_id){
        //TODO groupController2
    }
}
