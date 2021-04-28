package com.gabrielguimaraes.springbootwithsoap.service.impl;

import com.gabrielguimaraes.springbootwithsoap.datashape.Student;
import com.gabrielguimaraes.springbootwithsoap.repository.StudentRepository;
import com.gabrielguimaraes.springbootwithsoap.service.StudentService;
import com.gabrielguimaraes.springbootwithsoap.service.outofbounds.SecondarySoapFeignClient;
import com.in28minutes.students.StudentDetails;
import com.secondaryServer.GetStudentDetailsRequest;
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

    @Autowired
    private SecondarySoapFeignClient secondarySoapFeignClient;

    @Override
    public StudentDetails findById(Long id) {
        return toStudentDetails(studentRepository.getOne(id));
    }

    @Override
    public StudentDetails addStudent(Student student) {
        return toStudentDetails(studentRepository.save(student));
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

    @Override
    public StudentDetails findByIdOnSecondaryServer(Long id) {
        GetStudentDetailsRequest secondaryRequest = new GetStudentDetailsRequest();
        secondaryRequest.setId(id);
        return secondarySoapFeignClient.getStudentDetails(secondaryRequest);
    }

    private StudentDetails toStudentDetails(Student st){
        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setId(st.getId());
        studentDetails.setName(st.getName());
        studentDetails.setPassportNumber(st.getPassportNumber());
        return studentDetails;
    }
}
