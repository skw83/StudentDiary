package pl.school.subject.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.school.correspondence.dto.CorrespondenceDto;
import pl.school.grade.entity.Grade;
import pl.school.parent.entity.Parent;
import pl.school.schoolGroup.entity.SchoolGroup;
import pl.school.student.dto.StudentDto;
import pl.school.subject.dto.SubjectDto;
import pl.school.teacher.dto.TeacherDto;
import pl.school.teacher.entity.Teacher;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToOne
	@JoinColumn(name = "id_teacher")
	private Teacher idTeacher;			// pole do pobrania Id nauczyciela, który wykłada dany przedmiot
	
	@ManyToMany(mappedBy = "subjects", cascade	=	{CascadeType.PERSIST,	CascadeType.MERGE})
	private List<SchoolGroup> schoolGroups = new ArrayList<>();
	
	@ManyToMany(mappedBy = "subjects", cascade	=	{CascadeType.PERSIST,	CascadeType.MERGE})
	private List<Grade> grades = new ArrayList<>();
	
	@Transient
	public SubjectDto toDto() {
		
		SubjectDto dto = new SubjectDto();
		
		dto.setId(getId());
		dto.setName(getName());
		dto.setIdTeacher(getIdTeacher().toDto());
		
		if(Objects.nonNull(getSchoolGroups()) && !getSchoolGroups().isEmpty()) {
			dto.getSchoolGroupsDto().clear();
			getSchoolGroups()
			.stream()
			.filter(Objects::nonNull)
			.map(SchoolGroup::toDto)
			.forEach(el -> dto.getSchoolGroupsDto().add(el));

		}
		
		if(Objects.nonNull(getGrades()) && !getGrades().isEmpty()) {
			dto.getGradesDto().clear();
			getGrades()
			.stream()
			.filter(Objects::nonNull)
			.map(Grade::toDto)
			.forEach(el -> dto.getGradesDto().add(el));

		}
		
		return dto;
	}

}
