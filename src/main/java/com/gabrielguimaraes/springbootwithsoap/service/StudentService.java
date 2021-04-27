package com.gabrielguimaraes.springbootwithsoap.service;

import com.gabrielguimaraes.springbootwithsoap.datashape.Student;

public interface StudentService {

    Student findById(Long id);

    Student addStudent(Student student);

    void deleteStudent(Long id);
}
