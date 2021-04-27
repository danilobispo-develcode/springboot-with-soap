package com.gabrielguimaraes.springbootwithsoap.web;

import com.gabrielguimaraes.springbootwithsoap.datashape.Student;
import com.gabrielguimaraes.springbootwithsoap.service.StudentService;
import com.in28minutes.students.AddStudentDetailsRequest;
import com.in28minutes.students.AddStudentDetailsResponse;
import com.in28minutes.students.DeleteStudentDetailsRequest;
import com.in28minutes.students.DeleteStudentDetailsResponse;
import com.in28minutes.students.GetStudentDetailsRequest;
import com.in28minutes.students.GetStudentDetailsResponse;
import com.in28minutes.students.StudentDetails;
import com.in28minutes.students.UpdateStudentDetailsRequest;
import com.in28minutes.students.UpdateStudentDetailsResponse;
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

        Student st = studentService.findById(request.getId());

        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setId(st.getId());
        studentDetails.setName("Adam");
        studentDetails.setPassportNumber("E1234567");

        response.setStudentDetails(studentDetails);

        return response;
    }

    @PayloadRoot(namespace = "http://in28minutes.com/students", localPart = "AddStudentDetailsRequest")
    @ResponsePayload
    public AddStudentDetailsResponse addStudentDetailsRequest(@RequestPayload AddStudentDetailsRequest request) {

        AddStudentDetailsResponse response = new AddStudentDetailsResponse();

        Student st = studentService.addStudent(new Student(request.getName(), request.getPassportNumber()));

        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setId(st.getId());
        studentDetails.setName(st.getName());
        studentDetails.setPassportNumber(st.getPassportNumber());

        response.setStudentDetails(studentDetails);

        return response;
    }

    @PayloadRoot(namespace = "http://in28minutes.com/students", localPart = "DeleteStudentDetailsRequest")
    @ResponsePayload
    public DeleteStudentDetailsResponse deleteStudentDetailsRequest(@RequestPayload DeleteStudentDetailsRequest request) {

        DeleteStudentDetailsResponse response = new DeleteStudentDetailsResponse();

        studentService.deleteStudent(request.getId());

        response.setConfirmacao(Boolean.TRUE);

        return response;
    }

    @PayloadRoot(namespace = "http://in28minutes.com/students", localPart = "UpdateStudentDetailsRequest")
    @ResponsePayload
    public UpdateStudentDetailsResponse deleteStudentDetailsRequest(@RequestPayload UpdateStudentDetailsRequest request) {

        UpdateStudentDetailsResponse response = new UpdateStudentDetailsResponse();

        response.setStudentDetails(studentService.updateStudent(request.getStudentDetails()));

        return response;
    }
}
