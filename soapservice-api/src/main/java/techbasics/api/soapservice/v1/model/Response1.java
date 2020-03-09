package techbasics.api.soapservice.v1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import techbasics.api.soapservice.v1.service.SoapService;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

//For more annotations see https://www.mojohaus.org/jaxb2-maven-plugin/Documentation/v2.2/example_schemagen_basic.html
@XmlType(namespace = SoapService.NAMESPACE_URI_V1)
public class Response1 {

	@XmlElement(name = "responseString1")
	private String responseString1;

	@XmlElement(name = "responseInt1")
	private int responseInt1;

	@XmlElementWrapper(name = "response1Strings", nillable = true)
	@XmlElement(name = "response1String")
	private List<String> response1Strings;

}
