package pl.school.schoolGroup.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.school.student.dto.StudentDto;
import pl.school.subject.dto.SubjectDto;
import pl.school.teacher.dto.TeacherDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolGroupDto {
	
	private Long id;
	
	private String name;
	
	private List<StudentDto> studentsDto = new ArrayList<>();
	
	private TeacherDto mainTeacher;
	
	private List<SubjectDto> subjectsDto = new ArrayList<>(); 
	

}
