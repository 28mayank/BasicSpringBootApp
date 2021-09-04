package com.spingboot.webapp.BasicSpringBootApp.Controller;

import com.spingboot.webapp.BasicSpringBootApp.Entities.Student;
import com.spingboot.webapp.BasicSpringBootApp.Repositories.StudentRepository;
import com.spingboot.webapp.BasicSpringBootApp.Service.StudentService;
import com.spingboot.webapp.BasicSpringBootApp.Service.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository repository;
    private final StudentService service;

    @GetMapping("/showStudents")
    public List<Student> getAllStudent(){
        return repository.findAll();
    }

    @GetMapping("/student/{rollNumber}")
    public ResponseEntity<Student> getStudent(@PathVariable int rollNumber){
        return service.makeStudentNameUpperCase(rollNumber);
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        repository.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
