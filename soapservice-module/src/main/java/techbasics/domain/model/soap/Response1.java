package techbasics.domain.model.soap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response1 {

	private String responseString1;
	private int responseInt1;
	private List<String> response1Strings;

}
