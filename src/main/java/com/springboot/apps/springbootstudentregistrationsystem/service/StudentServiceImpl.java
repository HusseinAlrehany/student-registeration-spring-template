package com.springboot.apps.springbootstudentregistrationsystem.service;

import com.springboot.apps.springbootstudentregistrationsystem.domain.Student;
import com.springboot.apps.springbootstudentregistrationsystem.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{


    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;

    }
    @Override
    public List<Student> listAll() {

        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public void saveStudent(Student theStudent) {
        studentRepository.save(theStudent);
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {


        studentRepository.deleteById(id);

    }

    @Override
    public Student findById(int id) {

        Optional<Student> result =studentRepository.findById(id);
        //SET A VARIABLE OF TYPE STUDENT TO NULL
        Student theStudent=null;

        //CHECK IF THE STUDENT EXISTS OR NOT
        if(result.isPresent()){
            theStudent=result.get();
        }
        else{
            throw new RuntimeException("STUDENT NOT FOUND ID - " + id);
        }
        return theStudent;



    }
}
