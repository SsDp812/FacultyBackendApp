package com.university.backendForFaculty.models;


import jakarta.persistence.*;

@Entity
@Table(name = "Mark")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id",referencedColumnName = "id")
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;



    @Column(name = "score")
    private Long score;


    public Mark(Long id, Long score, Course course, Student student) {
        this.id = id;
        this.score = score;
        this.course = course;
        this.student = student;
    }

    public Mark(Long score, Course course, Student student) {
        this.score = score;
        this.course = course;
        this.student = student;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Mark() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", course=" + course +
                ", student=" + student +
                '}';
    }
}
