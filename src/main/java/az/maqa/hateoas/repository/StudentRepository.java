package az.maqa.hateoas.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import az.maqa.hateoas.entity.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

	Page<Student> findAllByActive(Pageable pageable, int active);

	Student findStudentById(Long id);

}
