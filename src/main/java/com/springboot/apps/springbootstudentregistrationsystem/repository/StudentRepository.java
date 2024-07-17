package com.springboot.apps.springbootstudentregistrationsystem.repository;

import com.springboot.apps.springbootstudentregistrationsystem.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
