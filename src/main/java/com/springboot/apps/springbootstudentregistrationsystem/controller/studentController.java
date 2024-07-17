package com.springboot.apps.springbootstudentregistrationsystem.controller;

import com.springboot.apps.springbootstudentregistrationsystem.domain.Student;
import com.springboot.apps.springbootstudentregistrationsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class studentController {

    private StudentService studentService;

    @Autowired
    public studentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping("/")
    public String showHomePage(Model theModel){

       List<Student> listStudents=studentService.listAll();

       theModel.addAttribute("listStudents",listStudents);

        return "home";
    }

    @GetMapping("/addNewStudent")
    public String showCreateStudentForm(Model theModel){

        Student theStudent=new Student();
        theModel.addAttribute("students",theStudent);

        return "new-student";

    }

    @PostMapping("/saveStudents")
    public String saveStudents(@ModelAttribute("students")Student theStudent){

        studentService.saveStudent(theStudent);

        return"redirect:/";

    }

    @GetMapping("/showFormForUpdate")
    public String EditStudent(@RequestParam("studentId")int id ,Model theModel){

        //GET THE STUDENT FROM THE SERVICE BY THE PRIMARY KEY
        Student theStudent=studentService.findById(id);
        //BIND IT TO A MODEL TO REPOPULATE THE FORM

        theModel.addAttribute("students",theStudent);

        return"new-student";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId")int id){

        studentService.deleteStudent(id);

        return "redirect:/";


    }

}
