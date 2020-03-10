package techbasics.domain.soapservice.service.v1;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import techbasics.api.soapservice.v1.model.Request1;
import techbasics.api.soapservice.v1.model.Response1;
import techbasics.api.soapservice.v1.service.SoapService;
import techbasics.mapper.Request1Mapper;
import techbasics.mapper.Response1Mapper;

import java.util.Collections;

@Endpoint
public class SoapserviceImpl implements SoapService {


	@PayloadRoot(namespace = SoapService.NAMESPACE_URI_V1, localPart = "doSomething")
	public Response1 doSomething(@RequestPayload Request1 request1) {

		techbasics.domain.model.Request1 domainRequest = Request1Mapper.INSTANCE.mapToDomain(request1);

		techbasics.domain.model.Response1 resp = new techbasics.domain.model.Response1();
		resp.setResponseInt1(domainRequest.getRequestInt1()*2);
		resp.setResponseString1("SoapServiceV1("+domainRequest.getRequestString1()+")");
		resp.setResponse1Strings(Collections.singletonList(resp.getResponseString1()));

		return Response1Mapper.INSTANCE.mapToApi(resp);

	}

}
