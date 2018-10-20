package pl.school.student.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.pl.PESEL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.school.correspondence.entity.Correspondence;
import pl.school.grade.entity.Grade;
import pl.school.parent.dto.ParentDto;
import pl.school.parent.entity.Parent;
import pl.school.schoolGroup.entity.SchoolGroup;
import pl.school.student.dto.StudentDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;

	@NotBlank
	private String surname;
	
	private String password;
	
	@Column(unique = true)
	@PESEL
	private String pesel; //11 liczb

//	@NotBlank
	@ManyToOne
	@JoinColumn(name = "id_school_group")
	private SchoolGroup idSchoolGroup;

	
	@ManyToMany(cascade	=	{CascadeType.PERSIST,	CascadeType.MERGE})
	@JoinTable(
	        name="Student_Parent",
	        joinColumns=
	            @JoinColumn(name="students_id"),
	        inverseJoinColumns=
	            @JoinColumn(name="parents_id")
	    )
	private List<Parent> parents = new ArrayList<>();

	@OneToMany(mappedBy = "idStudent",
			cascade = CascadeType.ALL
			)
	private List<Grade> grades;

	@OneToMany(mappedBy = "idStudent", fetch = FetchType.EAGER)
	private List<Correspondence> correspondences;


	//	Nie wiem czy lista nauczycieli jest mi potrzebna
	//	@NotBlank
	//	private List<Teacher> teachers = new ArrayList<>(); 
	//	

	@Transient
	public StudentDto toDto() {

		StudentDto dto = new StudentDto();

		dto.setId(getId());
		dto.setName(getName());
		dto.setSurname(getSurname());
		dto.setIdSchoolGroup(getIdSchoolGroup());

		if(Objects.nonNull(getParents()) && !getParents().isEmpty()) {
			dto.getParentsDto().clear();
			getParents()
			.stream()
			.filter(Objects::nonNull)
			.map(Parent::toDto)
			.forEach(el -> dto.getParentsDto().add(el));
			

		}
		
//		@Transient
//		public StudentDto toDto() {
//
//			StudentDto dto = new StudentDto();
//
//			dto.setId(getId());
//			dto.setName(getName());
//			dto.setSurname(getSurname());
//			dto.setIdSchoolGroup(getIdSchoolGroup());
//
//			if(Objects.nonNull(getParents()) && !getParents().isEmpty()) {
//				dto.getParentsDto().clear();
//				getParents()
//				.stream()
//				.filter(Objects::nonNull)
//				.map(Parent::toDto)
//				.forEach(el -> dto.getParentsDto().add(el));
//				
//
//			}

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

	@Transient
	public StudentDto toSimpleDto() {

		StudentDto dto = new StudentDto();

		dto.setId(getId());
		dto.setName(getName());
		dto.setSurname(getSurname());
		dto.setIdSchoolGroup(getIdSchoolGroup());

		return dto;
	}

}
