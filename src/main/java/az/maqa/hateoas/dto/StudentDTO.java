package az.maqa.hateoas.dto;

import az.maqa.hateoas.entity.Address;
import az.maqa.hateoas.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

	private Long id;

	private String name;

	private String surname;

	private int age;

	private int active;

	private int course;

	private Double examPoint;

	private Address address;

	private Teacher teacher;

}
