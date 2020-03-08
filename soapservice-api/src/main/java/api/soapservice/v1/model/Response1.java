package api.soapservice.v1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Response1 {

	private String responseString1;
	private int responseInt1;

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
}
