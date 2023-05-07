package com.university.backendForFaculty.Controllers;


import com.university.backendForFaculty.dao.CourseDao;
import com.university.backendForFaculty.dao.FacultyDao;
import com.university.backendForFaculty.models.Course;
import com.university.backendForFaculty.models.Faculty;
import com.university.backendForFaculty.models.Teacher;
import com.university.backendForFaculty.services.FacultyService;
import com.university.backendForFaculty.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
    @Autowired
    private FacultyService service;

    @GetMapping("/")
    public List<Faculty> getAll(){
        return service.getAllFaculties();
    }

    @GetMapping("/{id}")
    public Faculty getById(@PathVariable Long id){
        return service.getFacultyById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }

    @PostMapping("/update/{id}")
    public void update(@RequestParam(name = "name") String name,
                       @RequestParam(name = "description") String description,
                       @RequestParam(name = "dean") Long dean_id){
        TeacherService teacherService = new TeacherService();
        service.update(new Faculty(name,description,teacherService.getTeacherById(dean_id)));

    }

    @PostMapping("/create")
    public void create(@RequestParam(name = "name") String name,
                       @RequestParam(name = "description") String description,
                       @RequestParam(name = "dean") Long dean_id){
        TeacherService teacherService = new TeacherService();
        service.save(new Faculty(name,description,teacherService.getTeacherById(dean_id)));
    }
}
