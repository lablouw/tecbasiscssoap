package techbasics.api.soapservice.v1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import techbasics.api.soapservice.v1.service.SoapService;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data

//For more annotations see https://www.mojohaus.org/jaxb2-maven-plugin/Documentation/v2.2/example_schemagen_basic.html
@XmlType(namespace = SoapService.NAMESPACE_URI_V1)
public class Request1 {

	@XmlElement(name = "requestString1")
	private String requestString1;

	@XmlElement(name = "requestInt1")
	private int requestInt1;

	@XmlElementWrapper(name = "request1Strings", nillable = true, required = false)
	@XmlElement(name = "request1String")
	private List<String> request1Strings;

}