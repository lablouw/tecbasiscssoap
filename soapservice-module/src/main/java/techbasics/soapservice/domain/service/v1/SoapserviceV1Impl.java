package techbasics.soapservice.domain.service.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import techbasics.common.annotaiton.UncaughtExceptionHandler;
import techbasics.common.manager.PersonManager;
import techbasics.soapservice.api.v1.model.Person;
import techbasics.soapservice.api.v1.model.ProcessedPerson;
import techbasics.soapservice.api.v1.service.SoapService;
import techbasics.soapservice.mapper.PersonMapper;
import techbasics.soapservice.mapper.ProcessedPersonMapper;

// Service layer should contain only input validation and calls to manager classes.
// No non-domain classes are to be passed into the manager layer, mapping between api and domain classes to take place here.

@Endpoint
@UncaughtExceptionHandler
public class SoapserviceV1Impl implements SoapService {

	@Autowired
	PersonManager personManager;

	@Override
	@PayloadRoot(namespace = SoapService.NAMESPACE_URI_V1, localPart = "processPerson")
	@ResponsePayload
	public ProcessedPerson processPerson(@RequestPayload Person person) {

		techbasics.common.domain.model.Person p = PersonMapper.INSTANCE.mapToDomain(person);

		techbasics.common.domain.model.ProcessedPerson pp = personManager.processPerson(p);

		return ProcessedPersonMapper.INSTANCE.mapToV1(pp);

	}

	@Override
	@PayloadRoot(namespace = SoapService.NAMESPACE_URI_V1, localPart = "testException")
	public void testException() throws Exception {
		throw new Exception("Exception from soap method testException");
	}

}
