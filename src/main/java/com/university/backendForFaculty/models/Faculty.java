package com.university.backendForFaculty.models;


import jakarta.persistence.*;

@Entity
@Table(name = "Faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column (name = "description")
    private String description;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dean", referencedColumnName = "id")
    private Teacher dean;

    public Faculty(String name, String description, Teacher dean) {
        this.name = name;
        this.description = description;
        this.dean = dean;
    }

    public Faculty(Long id, String name, String description, Teacher dean) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dean = dean;
    }

    public Faculty() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getDean() {
        return dean;
    }

    public void setDean(Teacher dean) {
        this.dean = dean;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dean=" + dean +
                '}';
    }
}
