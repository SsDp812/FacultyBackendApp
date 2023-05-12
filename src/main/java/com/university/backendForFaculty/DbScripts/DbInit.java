package com.university.backendForFaculty.DbScripts;


import com.university.backendForFaculty.models.*;
import com.university.backendForFaculty.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;

@Component
public class DbInit {
    @Autowired
    ClassRoomService classRoomService;

    @Autowired
    CoursesService coursesService;

    @Autowired
    FacultyService facultyService;

    @Autowired
    GroupService groupService;

    @Autowired
    MarkService markService;

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;



    public void initDB(){
        initStudents();
        initTeachers();
        initCourses();
        initFaculties();
        initClassroom();
        initSchedules();
        initMarks();
        initGroups();
        addCoursesToStudents();
        addStudentsToGroups();
    }


    public void initClassroom(){
        classRoomService.save(new ClassRoom("A415","Math",120));
        classRoomService.save(new ClassRoom("B314","Music",120));
        classRoomService.save(new ClassRoom("C465","IT",120));
        classRoomService.save(new ClassRoom("G165","Russian",120));
        classRoomService.save(new ClassRoom("F545","History",120));
        classRoomService.save(new ClassRoom("L905","Labs",120));
        classRoomService.save(new ClassRoom("B115","IT",120));
        classRoomService.save(new ClassRoom("P001","Math",120));
        classRoomService.save(new ClassRoom("B762","History",120));
        classRoomService.save(new ClassRoom("H372","Math",120));
    }

    public void initCourses(){
        coursesService.save(new Course("algorithms","math and etc",teacherService.getTeacherById(Long.valueOf("1"))));
        coursesService.save(new Course("graphics","graphics and etc",teacherService.getTeacherById(Long.valueOf("1"))));
        coursesService.save(new Course("programming","it",teacherService.getTeacherById(Long.valueOf("2"))));
        coursesService.save(new Course("c++","c++ learning",teacherService.getTeacherById(Long.valueOf("2"))));
    }

    public void initFaculties(){
        facultyService.save(new Faculty("MathFaculty","Math",teacherService.getTeacherById(Long.valueOf("1"))));
        facultyService.save(new Faculty("ITFaculty","IT-Computers",teacherService.getTeacherById(Long.valueOf("2"))));
    }

    public void initGroups(){
        groupService.save(new Group("121",coursesService.getCourseById(Long.valueOf("1"))));
        groupService.save(new Group("347",coursesService.getCourseById(Long.valueOf("2"))));
        groupService.save(new Group("432",coursesService.getCourseById(Long.valueOf("3"))));
    }

    public void initMarks(){
        markService.save(new Mark(Long.valueOf("5"),coursesService.getCourseById(Long.valueOf("1")),studentService.getStudentById(Long.valueOf("1"))));
        markService.save(new Mark(Long.valueOf("4"),coursesService.getCourseById(Long.valueOf("2")),studentService.getStudentById(Long.valueOf("2"))));
        markService.save(new Mark(Long.valueOf("5"),coursesService.getCourseById(Long.valueOf("2")),studentService.getStudentById(Long.valueOf("1"))));
    }

    public void initSchedules(){
        scheduleService.save(new Schedule(
                classRoomService.getClassRoomById(Long.valueOf("1")),
                "Monday",
                Time.valueOf("12:00:00"),
                Time.valueOf("13:00:00"),
                coursesService.getCourseById(Long.valueOf("1")),
                teacherService.getTeacherById(Long.valueOf("1"))
        ));

        scheduleService.save(new Schedule(
                classRoomService.getClassRoomById(Long.valueOf("1")),
                "Wednsday",
                Time.valueOf("11:00:00"),
                Time.valueOf("14:00:00"),
                coursesService.getCourseById(Long.valueOf("2")),
                teacherService.getTeacherById(Long.valueOf("2"))
        ));
    }

    public void initStudents(){
        studentService.save(new Student("Ilya","Ivanov","Vladich",Date.valueOf("2004-12-12"),"vologda","104","il@mail.ru"));
        studentService.save(new Student("Gleb","Grebob","Umkich",Date.valueOf("2001-04-21"),"ryazan","802","gleb@mail.ru"));

    }

    public void initTeachers(){
        teacherService.save(new Teacher("Ivan","Ivanov","Ivanovuch", Date.valueOf("1978-12-12"),"moscow","900","iv@mail.ru"));
        teacherService.save(new Teacher("Andrei","Andreev","Ivanovuch", Date.valueOf("2002-10-09"),"moscow","100","and@mail.ru"));
        teacherService.save(new Teacher("Sergei","Sergeev","Ivanovuch", Date.valueOf("2003-05-10"),"moscow","200","serg@mail.ru"));
    }

    public void addCoursesToStudents(){
        studentService.getStudentById(Long.valueOf("1")).getCourses().add(coursesService.getCourseById(Long.valueOf("1")));
        studentService.getStudentById(Long.valueOf("1")).getCourses().add(coursesService.getCourseById(Long.valueOf("2")));

        studentService.getStudentById(Long.valueOf("2")).getCourses().add(coursesService.getCourseById(Long.valueOf("1")));
        studentService.getStudentById(Long.valueOf("2")).getCourses().add(coursesService.getCourseById(Long.valueOf("2")));
    }

    public void addStudentsToGroups(){
        groupService.getGroupById(Long.valueOf("1")).getStudent().add(studentService.getStudentById(Long.valueOf("1")));
        groupService.getGroupById(Long.valueOf("1")).getStudent().add(studentService.getStudentById(Long.valueOf("2")));

    }

}
