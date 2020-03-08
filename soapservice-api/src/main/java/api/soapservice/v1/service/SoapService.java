package api.soapservice.v1.service;

import api.soapservice.v1.model.Request1;
import api.soapservice.v1.model.Response1;

public interface SoapService {

    String NAMESPACE_URI = "http://localhost:8080/soapService/v1/";

    Response1 processSoapRequest1(Request1 request1);

}
