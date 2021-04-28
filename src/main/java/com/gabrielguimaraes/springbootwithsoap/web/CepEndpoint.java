package com.gabrielguimaraes.springbootwithsoap.web;

import com.gabrielguimaraes.springbootwithsoap.service.CepService;
import com.in28minutes.students.GetAddressByCepRequest;
import com.in28minutes.students.GetAddressByCepResponse;
import com.in28minutes.students.UpdateStudentDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CepEndpoint {

    @Autowired
    private CepService cepService;

    @PayloadRoot(namespace = "http://in28minutes.com/students", localPart = "GetAddressByCepRequest")
    @ResponsePayload
    public GetAddressByCepResponse getAddressByCepRequest(@RequestPayload GetAddressByCepRequest request) {
        GetAddressByCepResponse response = new GetAddressByCepResponse();
        response.setAddress(cepService.findAddressByCep(request.getCep()));
        return response;
    }
}
