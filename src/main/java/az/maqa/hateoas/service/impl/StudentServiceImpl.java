package az.maqa.hateoas.service.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import az.maqa.hateoas.dto.StudentDTO;
import az.maqa.hateoas.entity.Student;
import az.maqa.hateoas.repository.StudentRepository;
import az.maqa.hateoas.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<StudentDTO> getAllStudents(int page, int size) {
		ModelMapper modelMapper = new ModelMapper();

		if (page > 0)
			page -= 1;

		Pageable pageable = PageRequest.of(page, size);

		Page<Student> studentsPage = studentRepository.findAllByActive(pageable, 1);

		List<Student> students = studentsPage.getContent();

		Type listType = new TypeToken<List<StudentDTO>>() {
		}.getType();

		List<StudentDTO> returnvalue = modelMapper.map(students, listType);

		return returnvalue;
	}

	@Override
	public StudentDTO getStudent(Long id) {
		ModelMapper modelMapper = new ModelMapper();

		Student student = studentRepository.findStudentById(id);

		StudentDTO returnValue = modelMapper.map(student, StudentDTO.class);

		return returnValue;
	}

}
