package pl.school.student.service;

import java.util.List;

import pl.school.common.service.BaseCRUDService;
import pl.school.student.dto.StudentDto;
import pl.school.student.entity.Student;

public interface StudentService extends BaseCRUDService<StudentDto, Long> {

	StudentDto login(StudentDto dto);
	
	StudentDto showStudentByPesel(StudentDto dto);
	
	List<StudentDto> getAll();
	
}
