package com.gabrielguimaraes.springbootwithsoap.web;

import com.gabrielguimaraes.springbootwithsoap.datashape.Student;
import com.gabrielguimaraes.springbootwithsoap.service.StudentService;
import com.in28minutes.students.AddStudentDetailsRequest;
import com.in28minutes.students.AddStudentDetailsResponse;
import com.in28minutes.students.DeleteStudentDetailsRequest;
import com.in28minutes.students.DeleteStudentDetailsResponse;
import com.in28minutes.students.GetStudentDetailsRequest;
import com.in28minutes.students.GetStudentDetailsResponse;
import com.in28minutes.students.GetStudentDetailsSecondaryServerRequest;
import com.in28minutes.students.GetStudentDetailsSecondaryServerResponse;
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
        response.setStudentDetails(studentService.findById(request.getId()));
        return response;
    }

    @PayloadRoot(namespace = "http://in28minutes.com/students", localPart = "AddStudentDetailsRequest")
    @ResponsePayload
    public AddStudentDetailsResponse addStudentDetailsRequest(@RequestPayload AddStudentDetailsRequest request) {
        AddStudentDetailsResponse response = new AddStudentDetailsResponse();
        response.setStudentDetails(studentService.addStudent(new Student(request.getName(), request.getPassportNumber())));
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

    @PayloadRoot(namespace = "http://in28minutes.com/students", localPart = "GetStudentDetailsSecondaryServerRequest")
    @ResponsePayload
    public GetStudentDetailsSecondaryServerResponse getStudentDetailsSecondaryServerRequest(@RequestPayload GetStudentDetailsSecondaryServerRequest request) {
        GetStudentDetailsSecondaryServerResponse response = new GetStudentDetailsSecondaryServerResponse();
        response.setStudentDetails(studentService.findByIdOnSecondaryServer(request.getId()));
        return response;
    }
}
