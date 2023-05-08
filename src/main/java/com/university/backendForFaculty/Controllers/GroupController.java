package com.university.backendForFaculty.Controllers;


import com.university.backendForFaculty.dao.FacultyDao;
import com.university.backendForFaculty.dao.GroupDao;
import com.university.backendForFaculty.models.Faculty;
import com.university.backendForFaculty.models.Group;
import com.university.backendForFaculty.models.Student;
import com.university.backendForFaculty.services.CoursesService;
import com.university.backendForFaculty.services.GroupService;
import com.university.backendForFaculty.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
                       @RequestParam(name = "course_id") Long course_id,
                       @PathVariable Long id){
        CoursesService coursesService = new CoursesService();
        StudentService studentService = new StudentService();
        service.update(new Group(id,name,coursesService.getCourseById(course_id),service.getGroupById(id).getStudent()));
    }

    @PostMapping("/create")
    public void create(@RequestParam(name = "name") String name,
                       @RequestParam(name = "course_id") Long course_id){
        CoursesService coursesService = new CoursesService();
        service.save(new Group(name,coursesService.getCourseById(course_id),new ArrayList<>()));
    }


   @PostMapping("/addStudent/{id}")
    public void addStudent(@RequestParam(name = "student_id") Long student_id, @PathVariable Long id){
        StudentService studentService = new StudentService();
        Group group = service.getGroupById(id);
        group.getStudent().add(studentService.getStudentById(student_id));
        service.update(group);
   }


    @PostMapping("/removeStudent/{id}")
    public void removeStudent(@RequestParam(name = "student_id") Long student_id, @PathVariable Long id){
        StudentService studentService = new StudentService();
        Group group = service.getGroupById(id);
        group.getStudent().remove(studentService.getStudentById(student_id));
        service.update(group);
    }
}
