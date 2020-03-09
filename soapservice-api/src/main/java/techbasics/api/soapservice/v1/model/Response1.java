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
public class Response1 {

	private String responseString1;
	private int responseInt1;
	private List<String> response1Strings;

	public String getResponseString1() {
		return responseString1;
	}

	public void setResponseString1(String responseString1) {
		this.responseString1 = responseString1;
	}

	public int getResponseInt1() {
		return responseInt1;
	}

	public void setResponseInt1(int responseInt1) {
		this.responseInt1 = responseInt1;
	}

	public List<String> getResponse1Strings() {
		return response1Strings;
	}

	public void setResponse1Strings(List<String> response1Strings) {
		this.response1Strings = response1Strings;
	}
}
