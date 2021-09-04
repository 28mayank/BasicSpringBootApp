package com.spingboot.webapp.BasicSpringBootApp.Service;

import com.spingboot.webapp.BasicSpringBootApp.Entities.Student;
import com.spingboot.webapp.BasicSpringBootApp.Repositories.StudentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Locale;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @InjectMocks private StudentServiceImpl service;
    @Mock private StudentRepository repository;
    @Mock private Student student;

    private static final int num = 1;

    @Test
    void makeStudentNameUpperCase() {
        when(repository.findById(anyInt())).thenReturn(getStudent());
        ResponseEntity<Student> s = service.makeStudentNameUpperCase(num);

        assertTrue(s.getStatusCode().is2xxSuccessful());
    }

    private Optional<Student> getStudent(){
        student.setRollNumber(1);
        student.setName("Mayank");
        student.setCity("Kharar");

        return Optional.of(student);
    }
}