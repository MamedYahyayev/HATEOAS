package az.maqa.hateoas.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestStudent {

	private String name;

	private String surname;

	private int age;

	private int active;

	private int course;

	private String imgPath;

	private Double examPoint;

}
