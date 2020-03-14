package techbasics.soapservice.domain.service.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import techbasics.common.manager.PersonManager;
import techbasics.soapservice.api.v1.model.Person;
import techbasics.soapservice.api.v1.model.ProcessedPerson;
import techbasics.soapservice.api.v1.service.SoapService;
import techbasics.soapservice.mapper.PersonMapper;
import techbasics.soapservice.mapper.ProcessedPersonMapper;

// Service layer should contain only input validation and calls to manager classes.
// No non-domain classes are to be passed into the manager layer, mapping between api and domain classes to take place here.

@Endpoint
public class SoapserviceV1Impl implements SoapService {

	@Autowired
	PersonManager personManager;

	@PayloadRoot(namespace = SoapService.NAMESPACE_URI_V1, localPart = "processPerson")
	public ProcessedPerson processPerson(@RequestPayload Person person) {

		techbasics.common.domain.model.Person p = PersonMapper.INSTANCE.mapToDomain(person);

		techbasics.common.domain.model.ProcessedPerson pp = personManager.processPerson(p);

		return ProcessedPersonMapper.INSTANCE.mapToV1(pp);

	}

}
