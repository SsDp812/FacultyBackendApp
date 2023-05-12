package com.university.backendForFaculty.Controllers;


import com.university.backendForFaculty.dao.ClassRoomDao;
import com.university.backendForFaculty.dao.CourseDao;
import com.university.backendForFaculty.models.ClassRoom;
import com.university.backendForFaculty.models.Course;
import com.university.backendForFaculty.models.Teacher;
import com.university.backendForFaculty.services.CoursesService;
import com.university.backendForFaculty.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CoursesService service;

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/")
    public List<Course> getAll(){
        return service.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Long id){
        System.out.println(service.getCourseById(id));
        return service.getCourseById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }

    @PostMapping("/update")
    public void update(@RequestParam(name = "name") String name,
                       @RequestParam(name = "description") String description,
                       @RequestParam(name = "teacher_id") Long teacher_id,
                       @RequestParam(name = "id") Long id){
        service.update(new Course(id,name,description,teacherService.getTeacherById(teacher_id)));

    }

    @PostMapping("/create")
    public void create(@RequestParam(name = "name") String name,
                       @RequestParam(name = "description") String description,
                       @RequestParam(name = "teacher_id") Long teacher_id){
        service.save(new Course(name,description,teacherService.getTeacherById(teacher_id)));
    }
}
