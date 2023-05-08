package com.university.backendForFaculty.Controllers;


import com.university.backendForFaculty.dao.GroupDao;
import com.university.backendForFaculty.dao.MarkDao;
import com.university.backendForFaculty.models.Mark;
import com.university.backendForFaculty.services.CoursesService;
import com.university.backendForFaculty.services.MarkService;
import com.university.backendForFaculty.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarkController {
    @Autowired
    private MarkService service;

    @GetMapping("/")
    public List<Mark> getAll(){
        return service.getAllMarks();
    }

    @GetMapping("/{id}")
    public Mark getById(@PathVariable Long id){
        return service.getMarkById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }

    @PostMapping("/update/{id}")
    public void update(@RequestParam(name = "score") Long score,
                       @RequestParam(name = "course_id") Long course_id,
                       @RequestParam(name = "student_id") Long student_id,
                       @PathVariable Long id){
        CoursesService coursesService = new CoursesService();
        StudentService studentService = new StudentService();
        service.update(new Mark(id,score,coursesService.getCourseById(course_id),
                studentService.getStudentById(student_id)));

    }

    @PostMapping("/create")
    public void create(@RequestParam(name = "score") Long score,
                       @RequestParam(name = "course_id") Long course_id,
                       @RequestParam(name = "student_id") Long student_id){
        CoursesService coursesService = new CoursesService();
        StudentService studentService = new StudentService();
        service.save(new Mark(score,coursesService.getCourseById(course_id),
                studentService.getStudentById(student_id)));
    }
}
