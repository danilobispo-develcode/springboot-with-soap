package com.gabrielguimaraes.springbootwithsoap.service;

import com.gabrielguimaraes.springbootwithsoap.datashape.Student;
import com.in28minutes.students.StudentDetails;
import com.secondaryServer.GetStudentDetailsRequest;

public interface StudentService {

    StudentDetails findById(Long id);

    StudentDetails findByIdOnSecondaryServer(Long id);

    StudentDetails addStudent(Student student);

    void deleteStudent(Long id);

    StudentDetails updateStudent(StudentDetails studentDetails);
}
