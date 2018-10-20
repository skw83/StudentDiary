package pl.school.parent.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.school.parent.entity.Parent;
import pl.school.student.entity.Student;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

	Parent findByEmail(String email);
	Set<Parent> findAllByStudents(List<Student> student);
}
