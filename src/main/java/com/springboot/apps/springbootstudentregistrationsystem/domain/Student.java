package com.springboot.apps.springbootstudentregistrationsystem.domain;


import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="student_name")
    private String studentName;

    @Column(name="course")
    private String course;

    @Column(name="fee")
    private Integer fee;

    public Student(){}

    public Student(Integer id, String studentName, String course, Integer fee) {
        this.id = id;
        this.studentName = studentName;
        this.course = course;
        this.fee = fee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }
}
