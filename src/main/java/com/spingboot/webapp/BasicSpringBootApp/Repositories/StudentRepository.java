package com.spingboot.webapp.BasicSpringBootApp.Repositories;

import com.spingboot.webapp.BasicSpringBootApp.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
