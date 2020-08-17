package az.maqa.hateoas.service;

import java.util.List;

import az.maqa.hateoas.dto.StudentDTO;

public interface StudentService {

	List<StudentDTO> getAllStudents(int page, int size);

	StudentDTO getStudent(Long id);

	
}
