package pl.school.parent.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.school.parent.dto.ParentDto;
import pl.school.student.entity.Student;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Parent {

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
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	        name="Student_Parent",
	        joinColumns=
	            @JoinColumn(name="parents_id"),
	        inverseJoinColumns=
	            @JoinColumn(name="students_id")
	    )
	private List<Student> students = new ArrayList<>(); 
	
	@Transient
	public ParentDto toDto() {
		
		ParentDto dto = new ParentDto();
		
		dto.setId(getId());
		dto.setName(getName());
		dto.setSurname(getSurname());
		dto.setEmail(getEmail());
		
		if(Objects.nonNull(getStudents()) && !getStudents().isEmpty()) {
			dto.getStudentsDto().clear();
			getStudents()
				.stream()
				.filter(Objects::nonNull)
				.map(Student::toDto)
				.forEach(el -> dto.getStudentsDto().add(el));
			
		}
		
		return dto;
	}
	
	@Transient
	public ParentDto toSimpleDto() {

		ParentDto dto = new ParentDto();

		dto.setId(getId());
		dto.setName(getName());
		dto.setSurname(getSurname());
		dto.setEmail(getEmail());

		return dto;
	}

	@Override
	public String toString() {

		return String.format("id: %s\t name: %s\t surname: %s\t email: %s\t", id, name, surname, email);
	}
	
}
