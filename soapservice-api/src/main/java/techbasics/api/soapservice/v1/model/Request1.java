package techbasics.api.soapservice.v1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Request1 {

	private String requestString1;
	private int requestInt1;

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
}