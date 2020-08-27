package az.maqa.hateoas.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import az.maqa.hateoas.dto.StudentDTO;

public interface StudentService {

	List<StudentDTO> getAllStudents(int page, int size);

	StudentDTO getStudent(Long id);

	StudentDTO addStudent(StudentDTO studentDTO , MultipartFile multipartFile);

	
}
