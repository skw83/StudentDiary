package pl.school.student.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.pl.PESEL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.school.correspondence.dto.CorrespondenceDto;
import pl.school.grade.dto.GradeDto;
import pl.school.parent.dto.ParentDto;
import pl.school.schoolGroup.entity.SchoolGroup;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
	
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String surname;
	
	private String password;
	
	@PESEL
	private String pesel;
	
	private SchoolGroup idSchoolGroup;
	
	private List<ParentDto> parentsDto = new ArrayList<>();
	
	private List<GradeDto> gradesDto = new ArrayList<>();
	
	private List<CorrespondenceDto> correspondenceDto = new ArrayList<>();
	
	@Override
	public String toString() {
		String msg = "Obiekt logowanie studenta :" + pesel + " " + name + " " + surname;
		return msg;
	}

}
