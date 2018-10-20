package pl.school.correspondence.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.school.grade.dto.GradeDto;
import pl.school.student.dto.StudentDto;
import pl.school.student.entity.Student;
import pl.school.subject.dto.SubjectDto;
import pl.school.teacher.dto.TeacherDto;
import pl.school.teacher.entity.Teacher;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorrespondenceDto {
	
	private Long id;
	
	private String message;
	
	private StudentDto idStudent;
	
	private TeacherDto idTeacher;
	
	private Long idPrimaryMess;
	
	private Boolean acceptParent;
	
	private Boolean acceptTeacher;

}
