package com.gabrielguimaraes.springbootwithsoap.service;

import com.gabrielguimaraes.springbootwithsoap.datashape.Student;
import com.in28minutes.students.StudentDetails;

public interface StudentService {

    Student findById(Long id);

    Student addStudent(Student student);

    void deleteStudent(Long id);

    StudentDetails updateStudent(StudentDetails studentDetails);
}
