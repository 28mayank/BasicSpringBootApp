package com.spingboot.webapp.BasicSpringBootApp.Service;

import com.spingboot.webapp.BasicSpringBootApp.Entities.Student;
import com.spingboot.webapp.BasicSpringBootApp.Repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository repository;

    @Override
    public ResponseEntity<Student> makeStudentNameUpperCase(int id) {
        Optional<Student> s = repository.findById(id);
        if(s.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            s.get().setName(s.get().getName().toUpperCase());
            return new ResponseEntity<>(s.get(), HttpStatus.OK);
        }
    }
}