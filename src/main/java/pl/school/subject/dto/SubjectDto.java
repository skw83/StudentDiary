package pl.school.subject.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.school.grade.dto.GradeDto;
import pl.school.schoolGroup.dto.SchoolGroupDto;
import pl.school.teacher.dto.TeacherDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDto {
	
	private Long id;
	
	private String name;
	
	private TeacherDto idTeacher;			// pole do pobrania Id nauczyciela, który wykłada dany przedmiot
	
	private List<SchoolGroupDto> schoolGroupsDto = new ArrayList<>();
	
	private List<GradeDto> gradesDto = new ArrayList<>();

}
