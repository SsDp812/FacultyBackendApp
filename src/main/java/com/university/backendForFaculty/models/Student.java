package com.university.backendForFaculty.models;


import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "middlename")
    private String middle;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "mail")
    private String mail;

    @OneToMany
    @JoinColumn(name = "courses", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Student(String name, String surname, String middle, Date birthday, String address, String mobile, String mail) {
        this.name = name;
        this.surname = surname;
        this.middle = middle;
        this.birthday = birthday;
        this.address = address;
        this.mobile = mobile;
        this.mail = mail;
        this.courses = new ArrayList<>();
    }

    public Student() {
    }

    public Student(Long id, String name, String surname, String middle, Date birthday, String address, String mobile, String mail) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middle = middle;
        this.birthday = birthday;
        this.address = address;
        this.mobile = mobile;
        this.mail = mail;
        this.courses = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middle='" + middle + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
