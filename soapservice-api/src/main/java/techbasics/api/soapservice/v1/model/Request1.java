package techbasics.api.soapservice.v1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import techbasics.api.soapservice.v1.service.SoapService;

import javax.xml.bind.annotation.XmlType;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

//For more annotations see https://www.mojohaus.org/jaxb2-maven-plugin/Documentation/v2.2/example_schemagen_basic.html
@XmlType(namespace = SoapService.NAMESPACE_URI)
public class Request1 {

	private String requestString1;
	private int requestInt1;
	private List<String> request1Strings;

	public String getRequestString1() {
		return requestString1;
	}

	public void setRequestString1(String requestString1) {
		this.requestString1 = requestString1;
	}

	public int getRequestInt1() {
		return requestInt1;
	}

	public void setRequestInt1(int requestInt1) {
		this.requestInt1 = requestInt1;
	}

	public List<String> getRequest1Strings() {
		return request1Strings;
	}

	public void setRequest1Strings(List<String> request1Strings) {
		this.request1Strings = request1Strings;
	}
}