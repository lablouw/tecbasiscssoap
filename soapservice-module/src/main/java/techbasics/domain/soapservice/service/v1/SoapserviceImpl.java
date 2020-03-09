package techbasics.domain.soapservice.service.v1;

import techbasics.api.soapservice.v1.model.Request1;
import techbasics.api.soapservice.v1.model.Response1;
import techbasics.api.soapservice.v1.service.SoapService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

@Endpoint
public class SoapserviceImpl implements SoapService {


    @PayloadRoot(namespace = SoapService.NAMESPACE_URI_V1, localPart = "processSoapRequest1")
    public Response1 processSoapRequest1(@RequestPayload Request1 request1) {

        return new Response1();

    }

}
