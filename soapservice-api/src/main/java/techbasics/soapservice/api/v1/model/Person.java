package techbasics.soapservice.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import techbasics.soapservice.api.v1.service.SoapService;

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
public class Person {

	@XmlElement(name = "name")
	private String name;

	@XmlElement(name = "age")
	private int age;

	@XmlElementWrapper(name = "qualifications", nillable = true)
	@XmlElement(name = "qualification")
	private List<String> qualifications;

}