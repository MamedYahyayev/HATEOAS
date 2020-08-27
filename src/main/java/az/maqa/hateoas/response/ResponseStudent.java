package az.maqa.hateoas.response;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import az.maqa.hateoas.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "students")
public class ResponseStudent extends RepresentationModel<ResponseStudent> {

	private Long id;

	private String name;

	private String surname;

	private int age;

	private int active;

	private int course;

	private String imgPath;
	
	private Double examPoint;

	private Address address;

	private ResponseTeacherV1 teacher;

}
