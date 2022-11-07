package CampSpringProject.Kodlama.io.Devs.business.responses.programmingLanguageTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdProgrammingLanguageTechnologyResponse {
	private int id;
	private String name;
	private String programmingLanguageName;
}