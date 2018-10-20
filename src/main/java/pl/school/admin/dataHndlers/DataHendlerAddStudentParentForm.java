package pl.school.admin.dataHndlers;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.school.schoolGroup.entity.SchoolGroup;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataHendlerAddStudentParentForm {
	
	@NotBlank(message = "Pole nie może być puste!!!")
	private String nameSt;

	@NotBlank(message = "Pole nie może być puste!!!")
	private String surnameSt;
	
	private String passwordSt;
	
	@NotBlank(message = "Pole nie może być puste!!!")
	@PESEL(message = "Wprowadziłeś błędny PESEL")
	private String peselSt; //11 liczb


	private SchoolGroup idSchoolGroup;
	
	
	@NotBlank(message = "Pole nie może być puste!!!")
	private String nameP;
	
	@NotBlank(message = "Pole nie może być puste!!!")
	private String surnameP;
	
	@NotBlank(message = "Pole nie może być puste!!!")
	@Email(message = "Wprowadziłeś błedny email")
	private String email;
	
	

}
