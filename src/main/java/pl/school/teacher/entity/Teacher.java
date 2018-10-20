package pl.school.teacher.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.school.correspondence.entity.Correspondence;
import pl.school.grade.dto.GradeDto;
import pl.school.grade.entity.Grade;
import pl.school.parent.entity.Parent;
import pl.school.schoolGroup.dto.SchoolGroupDto;
import pl.school.schoolGroup.entity.SchoolGroup;
import pl.school.subject.entity.Subject;
import pl.school.teacher.dto.TeacherDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String surname;
	
	@Email
	@NotBlank
	private String email;
	
	@OneToOne(mappedBy = "idTeacher")
	@JoinColumn(name = "id_subject")
	private Subject idSubject;		// pole do pobrania Id przedmiotu
	
	@OneToMany(mappedBy = "idTeacher")
	private List<Grade> grades;
	
	@OneToOne(mappedBy = "mainTeacher")
	private SchoolGroup schoolGroup;
	
	@OneToMany(mappedBy = "idTeacher")
	private List<Correspondence> correspondences;
	
	@Transient
	public TeacherDto toDto() {
		
		TeacherDto dto = new TeacherDto();
		
		dto.setId(getId());
		dto.setName(getName());
		dto.setSurname(getSurname());
		dto.setEmail(getEmail());
		dto.setIdSubject(getIdSubject().toDto());
		dto.setSchoolGroup(getSchoolGroup().toDto());
		
		if(Objects.nonNull(getGrades()) && !getGrades().isEmpty()) {
			dto.getGradesDto().clear();
			getGrades()
			.stream()
			.filter(Objects::nonNull)
			.map(Grade::toDto)
			.forEach(el -> dto.getGradesDto().add(el));

		}
		
		if(Objects.nonNull(getCorrespondences()) && !getCorrespondences().isEmpty()) {
			dto.getCorrespondenceDto().clear();
			getCorrespondences()
			.stream()
			.filter(Objects::nonNull)
			.map(Correspondence::toDto)
			.forEach(el -> dto.getCorrespondenceDto().add(el));

		}
		
		return dto;
	}

}
