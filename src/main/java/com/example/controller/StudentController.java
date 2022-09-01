package com.example.controller;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentRepository.addStudent(student);
    }

    @DeleteMapping
    public void deleteStudent(@RequestBody Student student) {
        studentRepository.deleteStudent(student.getId());
    }

    @GetMapping
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
}
