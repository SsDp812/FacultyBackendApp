package com.university.backendForFaculty.Controllers;


import com.university.backendForFaculty.dao.MarkDao;
import com.university.backendForFaculty.dao.StudentDao;
import com.university.backendForFaculty.models.Student;
import com.university.backendForFaculty.services.CoursesService;
import com.university.backendForFaculty.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/")
    public List<Student> getAll(){
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id){
        return service.getStudentById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }

    @PostMapping("/update/{id}")
    public void update(@RequestParam(name = "name") String name,
                       @RequestParam(name = "surname") String surname,
                       @RequestParam(name = "middlename") String middlename,
                       @RequestParam(name = "birthday") Date birthday,
                       @RequestParam(name = "address") String address,
                       @RequestParam(name = "mobile") String mobile,
                       @RequestParam(name = "mail") String mail,
                       @PathVariable Long id){
        service.update(new Student(id,name,surname,middlename,birthday,
                address,mobile,mail));

    }

    @PostMapping("/create")
    public void create(@RequestParam(name = "name") String name,
                       @RequestParam(name = "surname") String surname,
                       @RequestParam(name = "middlename") String middlename,
                       @RequestParam(name = "birthday") Date birthday,
                       @RequestParam(name = "address") String address,
                       @RequestParam(name = "mobile") String mobile,
                       @RequestParam(name = "mail") String mail){
        Student student = new Student(name,surname,middlename,birthday,
                address,mobile,mail);
        student.setCourses(new ArrayList<>());
        service.save(student);
    }



    @PostMapping("/courses/add/{id}")
    public void addCourse(@RequestParam(name = "course_id") Long course_id, @PathVariable Long id){
        Student student = service.getStudentById(id);
        CoursesService coursesService = new CoursesService();
        student.getCourses().add(coursesService.getCourseById(course_id));
        service.update(student);
    }


    @PostMapping("/courses/remove/{id}")
    public void removeCourse(@RequestParam(name = "course_id") Long course_id,@PathVariable Long id){
        Student student = service.getStudentById(id);
        CoursesService coursesService = new CoursesService();
        student.getCourses().remove(coursesService.getCourseById(course_id));
        service.update(student);
    }


}
