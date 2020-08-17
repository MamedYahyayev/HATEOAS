package az.maqa.hateoas.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTeacherV1 {

	private Long id;

	private String name;

	private String surname;

	private int age;
}
