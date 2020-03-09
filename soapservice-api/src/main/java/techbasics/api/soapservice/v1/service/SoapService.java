package techbasics.api.soapservice.v1.service;

import techbasics.api.soapservice.v1.model.Request1;
import techbasics.api.soapservice.v1.model.Response1;

//WSDL: http://localhost:8080/soapService/v1.wsdl
public interface SoapService {

    //This should be in a properties file to make provision for different environments.
    String NAMESPACE_URI_V1 = "http://localhost:8080/soapService/v1";

    Response1 processSoapRequest1(Request1 request1);

}
