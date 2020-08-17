package az.maqa.hateoas.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7010056786964968584L;

	private String teachLesson;

	private Integer experience;

	private String degree;

	@OneToOne(mappedBy = "teacher")
	@JsonBackReference
	private Student student;

	@Embedded
	private Address address;
}
