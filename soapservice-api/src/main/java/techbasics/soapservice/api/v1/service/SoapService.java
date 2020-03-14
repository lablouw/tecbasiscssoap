package techbasics.soapservice.api.v1.service;

import techbasics.soapservice.api.v1.model.Person;
import techbasics.soapservice.api.v1.model.ProcessedPerson;

//WSDL: http://localhost:8080/soapService/v1.wsdl
public interface SoapService {

    //This should be in a properties file to make provision for different environments.
    String NAMESPACE_URI_V1 = "http://localhost:8080/soapService/v1";

    ProcessedPerson processPerson(Person person);

}
