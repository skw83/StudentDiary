package pl.school.grade.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.school.student.dto.StudentDto;
import pl.school.student.entity.Student;
import pl.school.subject.dto.SubjectDto;
import pl.school.subject.entity.Subject;
import pl.school.teacher.dto.TeacherDto;
import pl.school.teacher.entity.Teacher;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeDto {

	private Long id;
	
	private Integer gradeValue;
	
	private StudentDto idStudent;
	
	private List<SubjectDto> subjectsDto = new ArrayList<>(); 
//	@Column(name = "id_subject")
//	private Subject idSubject;
	
	private TeacherDto idTeacher;
	
	private LocalDate data;
	
	private String descritpion;
	
//	@Column(name = "id_parent")
//	private Parent idParent;
	
	private Boolean accept;
	
}
