package com.gabrielguimaraes.springbootwithsoap.web;

import com.gabrielguimaraes.springbootwithsoap.datashape.Student;
import com.gabrielguimaraes.springbootwithsoap.service.StudentService;
import com.in28minutes.students.AddStudentDetailsRequest;
import com.in28minutes.students.AddStudentDetailsResponse;
import com.in28minutes.students.GetStudentDetailsRequest;
import com.in28minutes.students.GetStudentDetailsResponse;
import com.in28minutes.students.StudentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentDetailsEndpoint {

    @Autowired
    private StudentService studentService;

    @PayloadRoot(namespace = "http://in28minutes.com/students", localPart = "GetStudentDetailsRequest")
    @ResponsePayload
    public GetStudentDetailsResponse getStudentDetailsRequest(@RequestPayload GetStudentDetailsRequest request) {

        GetStudentDetailsResponse response = new GetStudentDetailsResponse();

        Student st = studentService.findById((long) request.getId());

        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setId(st.getId());
        studentDetails.setName("Adam");
        studentDetails.setPassportNumber("E1234567");

        response.setStudentDetails(studentDetails);



        return response;
    }

    @PayloadRoot(namespace = "http://in28minutes.com/students", localPart = "AddStudentDetailsRequest")
    @ResponsePayload
    public AddStudentDetailsResponse addStudentDetailsResponse(@RequestPayload AddStudentDetailsRequest request) {

        AddStudentDetailsResponse response = new AddStudentDetailsResponse();

        Student st = studentService.addStudent(new Student(request.getName(), request.getPassportNumber()));

        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setId(st.getId());
        studentDetails.setName(st.getName());
        studentDetails.setPassportNumber(st.getPassportNumber());

        response.setStudentDetails(studentDetails);

        return response;
    }
}
