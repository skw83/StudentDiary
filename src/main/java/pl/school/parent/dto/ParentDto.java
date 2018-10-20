package pl.school.parent.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.school.correspondence.dto.CorrespondenceDto;
import pl.school.grade.dto.GradeDto;
import pl.school.schoolGroup.entity.SchoolGroup;
import pl.school.student.dto.StudentDto;
import pl.school.student.entity.Student;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentDto {

	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String surname;
	
	@Email
	@NotBlank
	private String email;
	
	private List<StudentDto> studentsDto = new ArrayList<>(); 
	
}
