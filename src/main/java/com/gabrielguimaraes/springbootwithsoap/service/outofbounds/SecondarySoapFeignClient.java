package com.gabrielguimaraes.springbootwithsoap.service.outofbounds;

import com.in28minutes.students.StudentDetails;
import com.secondaryServer.GetStudentDetailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class SecondarySoapFeignClient {
    @Autowired
    private Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;

    public StudentDetails getStudentDetails(GetStudentDetailsRequest secondaryRequest){
        template = new WebServiceTemplate(marshaller);
        StudentDetails toReturn = new StudentDetails();
        com.secondaryServer.StudentDetails response = ((com.secondaryServer.GetStudentDetailsResponse) template.marshalSendAndReceive(
                "http://localhost:8081/ws",    //This is where the secondary server is running
                secondaryRequest
        )).getStudentDetails();

        toReturn.setId(response.getId());
        toReturn.setName(response.getName());
        toReturn.setPassportNumber(response.getPassportNumber());
        return toReturn;
    }
}
