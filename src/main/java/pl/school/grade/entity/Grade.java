package pl.school.grade.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.school.grade.dto.GradeDto;
import pl.school.student.entity.Student;
import pl.school.subject.entity.Subject;
import pl.school.teacher.entity.Teacher;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Grade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "grade_value")
	private Integer gradeValue;
	
	@ManyToOne
	@JoinColumn(name = "id_student")
	private Student idStudent;
	
	@ManyToMany
	private List<Subject> subjects = new ArrayList<>(); 
//	@Column(name = "id_subject")
//	private Subject idSubject;
	
	@ManyToOne
	@JoinColumn(name = "id_teacher")
	private Teacher idTeacher;
	
	private LocalDate data = LocalDate.now();		
	
	private String descritpion;
	
//	@Column(name = "id_parent")
//	private Parent idParent;
	
	private Boolean accepted;
	
	@Transient
	public GradeDto toDto() {
		
		GradeDto dto = new GradeDto();
		
		dto.setId(getId());
		dto.setGradeValue(getGradeValue());
		dto.setIdStudent(getIdStudent().toSimpleDto());
		dto.setIdTeacher(getIdTeacher().toDto());
		dto.setData(getData());
		dto.setDescritpion(getDescritpion());
		dto.setAccept(getAccepted());
		
		if(Objects.nonNull(getSubjects()) && !getSubjects().isEmpty()) {
			dto.getSubjectsDto().clear();
			getSubjects()
			.stream()
			.filter(Objects::nonNull)
			.map(Subject::toDto)
			.forEach(el -> dto.getSubjectsDto().add(el));

		}
		
		return dto;
	}
	
	
}
