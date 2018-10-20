package pl.school.student.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.school.parent.dto.ParentDto;
import pl.school.parent.entity.Parent;
import pl.school.parent.repository.ParentRepository;
import pl.school.student.dto.StudentDto;
import pl.school.student.entity.Student;
import pl.school.student.repository.StudentRepository;
import pl.school.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private final StudentRepository studentRepo;
	private final ParentRepository parentRepository;
	private final StudentDtoFactory studentDtoFactory;
	
	@Autowired
	public StudentServiceImpl(
			StudentRepository studentRepo,
			ParentRepository parentRepository,
			StudentDtoFactory studentDtoFactory
			) {
		this.studentRepo = studentRepo;
		this.parentRepository = parentRepository;
		this.studentDtoFactory = studentDtoFactory;
	}

	@Override
	public StudentDto save(StudentDto dto) {
		
		final Student savedStudent = studentRepo.save(toStudentEntity(dto));

		System.out.println("savedStudent : " + savedStudent);

		List<Parent> parents = dto.getParentsDto().stream()
			.map(ParentDto::getEmail)
			.map(parentRepository::findByEmail)
			.collect(Collectors.toList());

		System.out.println("Parents = " + parents.toString());

		savedStudent.setParents(parents);

		final Student resavedStudent = studentRepo.save(savedStudent);
		return studentDtoFactory.toDto(resavedStudent);
	}


	@Override
	public StudentDto update(StudentDto dto) {
		
		final Student toUpdateStudent = studentRepo.findOne(dto.getId());
		System.out.println("Student to Update : " + toUpdateStudent);
		
		if(Objects.nonNull(toUpdateStudent)) {
			final StudentDto toUpdateStudentDto =  toUpdateStudent.toDto();
			return studentRepo.save(toStudentEntity(toUpdateStudentDto)).toDto();
		}else 
			
			return null;
	}

	@Override
	public StudentDto find(Long id) {
		return studentRepo.findOne(id).toDto();
	}

	@Override
	public Boolean remove(Long id) {
		studentRepo.delete(id);
		if(Objects.isNull(studentRepo.findOne(id))) {
			return true;
		}else return false;
	}
	@Override
	public List<StudentDto> getAll() {
		return toStudentDtoList(studentRepo.findAll());
	}


	@Override
	public StudentDto login(StudentDto dto) {
		Student student = studentRepo.findByPesel(dto.getPesel());
		if(Objects.isNull(student)) {
			return null;			
		}
		if(BCrypt.checkpw(dto.getPassword(), student.getPassword())) {
			return student.toDto();
		}
		return null;
	}
	
	@Override
	public StudentDto showStudentByPesel(StudentDto dto) {
		Student student = studentRepo.findByPesel(dto.getPesel());
		
		if(Objects.nonNull(student)) {
			return student.toDto();
		}
		
		return null;
	}
	
	private Student toStudentEntity(StudentDto dto) {
		
		Student student = new Student();
		
		student.setId(dto.getId());
		student.setName(dto.getName());
		student.setSurname(dto.getSurname());
		student.setPassword(dto.getPassword());
		student.setPesel(dto.getPesel());
		student.setIdSchoolGroup(dto.getIdSchoolGroup());
		
		return student;
	}
	
	private List<StudentDto> toStudentDtoList(List<Student> student){
		
		
		
		return student.stream().filter(Objects::nonNull).map(s -> new StudentDtoFactory().toDto(s)).collect(Collectors.toList());
	}


	

	

}
