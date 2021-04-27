package com.gabrielguimaraes.springbootwithsoap.repository;

import com.gabrielguimaraes.springbootwithsoap.datashape.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
