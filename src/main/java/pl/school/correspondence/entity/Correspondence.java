package pl.school.correspondence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import pl.school.correspondence.dto.CorrespondenceDto;
import pl.school.student.entity.Student;
import pl.school.teacher.entity.Teacher;

@Data
@Entity
public class Correspondence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String message;
	
	@ManyToOne
	@JoinColumn(name = "id_student")
	private Student idStudent;
	
	@ManyToOne
	@JoinColumn(name = "id_teacher")
	private Teacher idTeacher;
	
	@Column(name = "id_primary_message")
	private Long idPrimaryMess;
	
	@Column(name = "accept_parent")
	private Boolean acceptParent;
	
	@Column(name = "accept_teacher")
	private Boolean acceptTeacher;
	
	@Transient
	public CorrespondenceDto toDto() {
		
		CorrespondenceDto dto = new CorrespondenceDto();
		
		dto.setId(getId());
		dto.setMessage(getMessage());
		dto.setIdStudent(getIdStudent().toSimpleDto());
		dto.setIdTeacher(getIdTeacher().toDto());
		dto.setIdPrimaryMess(getIdPrimaryMess());
		dto.setAcceptParent(getAcceptParent());
		dto.setAcceptTeacher(getAcceptTeacher());
		
		return dto;
	}

}
