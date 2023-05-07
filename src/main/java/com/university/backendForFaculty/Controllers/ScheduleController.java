package com.university.backendForFaculty.Controllers;


import com.university.backendForFaculty.dao.MarkDao;
import com.university.backendForFaculty.dao.ScheduleDao;
import com.university.backendForFaculty.models.Schedule;
import com.university.backendForFaculty.services.ClassRoomService;
import com.university.backendForFaculty.services.CoursesService;
import com.university.backendForFaculty.services.ScheduleService;
import com.university.backendForFaculty.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleService service;

    @GetMapping("/")
    public List<Schedule> getAll(){
        return service.getAllSchedules();
    }

    @GetMapping("/{id}")
    public Schedule getById(@PathVariable Long id){
        return service.getScheduleById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }

    @PostMapping("/update/{id}")
    public void update(@RequestParam(name = "classroom_id") Long classroom_id,
                       @RequestParam(name = "dayOfWeek") String dayOfWeek,
                       @RequestParam(name = "start_time") Time start_time,
                       @RequestParam(name = "end_time") Time end_time,
                       @RequestParam(name = "course_id") Long course_id,
                       @RequestParam(name = "teacher_id") Long teacher_id){
        ClassRoomService classRoomService = new ClassRoomService();
        CoursesService coursesService = new CoursesService();
        TeacherService teacherService = new TeacherService();
        service.update(new Schedule(classRoomService.getClassRoomById(classroom_id),
                dayOfWeek,start_time,end_time,coursesService.getCourseById(course_id),
                teacherService.getTeacherById(teacher_id)));

    }

    @PostMapping("/create")
    public void create(@RequestParam(name = "classroom_id") Long classroom_id,
                       @RequestParam(name = "dayOfWeek") String dayOfWeek,
                       @RequestParam(name = "start_time") Time start_time,
                       @RequestParam(name = "end_time") Time end_time,
                       @RequestParam(name = "course_id") Long course_id,
                       @RequestParam(name = "teacher_id") Long teacher_id){
        ClassRoomService classRoomService = new ClassRoomService();
        CoursesService coursesService = new CoursesService();
        TeacherService teacherService = new TeacherService();
        service.save(new Schedule(classRoomService.getClassRoomById(classroom_id),
                dayOfWeek,start_time,end_time,coursesService.getCourseById(course_id),
                teacherService.getTeacherById(teacher_id)));
    }
}
