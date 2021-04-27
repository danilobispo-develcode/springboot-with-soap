package com.gabrielguimaraes.springbootwithsoap.service.impl;

import com.gabrielguimaraes.springbootwithsoap.datashape.Student;
import com.gabrielguimaraes.springbootwithsoap.repository.StudentRepository;
import com.gabrielguimaraes.springbootwithsoap.service.StudentService;
import com.in28minutes.students.StudentDetails;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student findById(Long id) {
        return studentRepository.getOne(id);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.delete(studentRepository.getOne(id));
    }

    @Override
    public StudentDetails updateStudent(StudentDetails studentDetails) {
        Student saved = studentRepository.getOne(studentDetails.getId());
        if (Objects.isNull(saved)) {
            return null;
        }
        saved.setName(studentDetails.getName());
        saved.setPassportNumber(studentDetails.getPassportNumber());
        studentRepository.save(saved);
        return studentDetails;
    }
}
