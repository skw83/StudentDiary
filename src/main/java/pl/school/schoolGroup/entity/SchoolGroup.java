package pl.school.schoolGroup.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.school.correspondence.dto.CorrespondenceDto;
import pl.school.grade.dto.GradeDto;
import pl.school.parent.entity.Parent;
import pl.school.schoolGroup.dto.SchoolGroupDto;
import pl.school.student.entity.Student;
import pl.school.subject.dto.SubjectDto;
import pl.school.subject.entity.Subject;
import pl.school.teacher.dto.TeacherDto;
import pl.school.teacher.entity.Teacher;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SchoolGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "idSchoolGroup")
	private List<Student> students = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name = "main_teacher")
	private Teacher mainTeacher;
	
	@ManyToMany
	private List<Subject> subjects = new ArrayList<>(); 
	
	@Transient
	public SchoolGroupDto toDto() {
		
		SchoolGroupDto dto = new  SchoolGroupDto();
		
		dto.setId(getId());
		dto.setName(getName());
		dto.setMainTeacher(getMainTeacher().toDto());
		
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
