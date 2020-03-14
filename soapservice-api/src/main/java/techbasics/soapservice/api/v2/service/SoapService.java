package techbasics.soapservice.api.v2.service;

import techbasics.soapservice.api.v2.model.Person;
import techbasics.soapservice.api.v2.model.ProcessedPerson;

//WSDL: http://localhost:8080/soapService/v2.wsdl
public interface SoapService {

    //This should be in a properties file to make provision for different environments.
    String NAMESPACE_URI_V2 = "http://localhost:8080/soapService/v2";

    ProcessedPerson processPerson(Person person);

}
