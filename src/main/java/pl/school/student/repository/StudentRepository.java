package pl.school.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.school.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByName(String name);
	
	Student findBySurname(String surname);
	
	Student findByPesel(String pesel);
	
}
