package pl.school.teacher.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.school.correspondence.dto.CorrespondenceDto;
import pl.school.grade.dto.GradeDto;
import pl.school.schoolGroup.dto.SchoolGroupDto;
import pl.school.subject.dto.SubjectDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
	
	private Long id;
	
	private String name;
	
	private String surname;
	
	private String email;
	
	private SubjectDto idSubject;		// pole do pobrania Id przedmiotu
	
	private List<GradeDto> gradesDto;
	
	private SchoolGroupDto schoolGroup;
	
	private List<CorrespondenceDto> correspondenceDto;

}
