package techbasics.domain.soapservice.service.v1;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import techbasics.api.soapservice.v1.model.Request1;
import techbasics.api.soapservice.v1.model.Response1;
import techbasics.api.soapservice.v1.service.SoapService;

@Endpoint
public class SoapserviceImpl implements SoapService {

    private static final String NAMESPACE_URI = "http://localhost:8080/soapService/v1/";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "processSoapRequest1")
    public Response1 processSoapRequest1(@RequestPayload Request1 request1) {

        return new Response1();

    }

}
