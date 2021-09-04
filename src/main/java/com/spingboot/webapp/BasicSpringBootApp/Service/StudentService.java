package com.spingboot.webapp.BasicSpringBootApp.Service;

import com.spingboot.webapp.BasicSpringBootApp.Entities.Student;
import org.springframework.http.ResponseEntity;

public interface StudentService {

    ResponseEntity<Student> makeStudentNameUpperCase(int rollNumber);
}
