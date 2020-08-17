package az.maqa.hateoas.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.lang.reflect.Type;
import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.maqa.hateoas.dto.StudentDTO;
import az.maqa.hateoas.response.ResponseStudent;
import az.maqa.hateoas.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/students", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	private CollectionModel<ResponseStudent> getAllStudents(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "25") int size) {
		ModelMapper modelMapper = new ModelMapper();

		List<StudentDTO> students = studentService.getAllStudents(page, size);

		Type listType = new TypeToken<List<ResponseStudent>>() {
		}.getType();

		List<ResponseStudent> response = modelMapper.map(students, listType);

		for (ResponseStudent responseStudent : response) {
			Link selfLink = linkTo(StudentController.class).slash("student").slash(responseStudent.getId())
					.withSelfRel();
			responseStudent.add(selfLink);
		}

		Link link = linkTo(StudentController.class).slash("/students?page=1&size=20").withSelfRel();
		CollectionModel<ResponseStudent> result = new CollectionModel<>(response, link);

		return result;
	}

	@GetMapping(value = "/student/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	private ResponseStudent getStudent(@PathVariable(value = "id") Long id) {
		ModelMapper modelMapper = new ModelMapper();

		StudentDTO student = studentService.getStudent(id);

		ResponseStudent response = modelMapper.map(student, ResponseStudent.class);

		Link link = linkTo(StudentController.class).slash("/students").withRel("studentList");
		response.add(link);

		return response;
	}

}
