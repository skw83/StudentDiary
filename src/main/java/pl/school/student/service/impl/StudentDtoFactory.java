package pl.school.student.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.school.parent.entity.Parent;
import pl.school.parent.repository.ParentRepository;
import pl.school.student.dto.StudentDto;
import pl.school.student.entity.Student;

@Service
public class StudentDtoFactory {

	@Autowired 
	private ParentRepository parentRepository;

	@Transient
	public StudentDto toDto(Student student) {

		StudentDto dto = new StudentDto();

		dto.setId(student.getId());
		dto.setName(student.getName());
		dto.setSurname(student.getSurname());
		dto.setIdSchoolGroup(student.getIdSchoolGroup());

		if (Objects.nonNull(student.getParents()) && !student.getParents().isEmpty()) {
			dto.getParentsDto().clear();

			List<Student> studentList = new ArrayList<>();
			studentList.add(student);

			parentRepository.findAllByStudents(studentList)
				.stream()
				.filter(Objects::nonNull)
				.map(Parent::toSimpleDto)
				.forEach(el -> dto.getParentsDto().add(el));

		}

		return dto;
	}
}
