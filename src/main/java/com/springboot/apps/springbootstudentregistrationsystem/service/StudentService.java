package com.springboot.apps.springbootstudentregistrationsystem.service;

import com.springboot.apps.springbootstudentregistrationsystem.domain.Student;

import java.util.List;

public interface StudentService {

    List<Student> listAll();

    void saveStudent(Student theStudent);

    void deleteStudent(Integer id);

    Student findById(int id);
}
