package pl.school.admin.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.school.admin.dataHndlers.DataHendlerAddStudentParentForm;
import pl.school.parent.dto.ParentDto;
import pl.school.parent.entity.Parent;
import pl.school.parent.repository.ParentRepository;
import pl.school.parent.service.ParentService;
import pl.school.student.dto.StudentDto;
import pl.school.student.entity.Student;
import pl.school.student.repository.StudentRepository;
import pl.school.student.service.StudentService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private final StudentService studentService;
	private final ParentService parentService;

//	StudentDto studentDto = new StudentDto();
	
	@Autowired
	ParentRepository parentRepository;
	
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	public AdminController(StudentService studentService, ParentService parentService) {
		this.studentService = studentService;
		this.parentService = parentService;
	}
	
	@GetMapping("/addUserForm")
	public ModelAndView addUserForm() {
		
		ModelAndView model = new ModelAndView("admin/addStudentPar");
		model.addObject("addStuPar", new DataHendlerAddStudentParentForm());
	
		return model;
	}
	
	@RequestMapping(value = "/addUserForm", method = RequestMethod.POST)
	public ModelAndView addUserForm(@Valid @ModelAttribute("addStuPar") DataHendlerAddStudentParentForm addStuPar, BindingResult res) {
		
		System.out.println("Dane studenta :" + addStuPar.getNameSt() + " " + addStuPar.getSurnameSt() + " " + addStuPar.getPasswordSt() + " " + addStuPar.getPeselSt() + " " + addStuPar.getIdSchoolGroup());
		System.out.println("Dane rodzica : " + addStuPar.getNameP() + " " + addStuPar.getSurnameP() + " " + addStuPar.getEmail());
		Parent parent = new Parent();
		List<StudentDto> studentDtoList = new ArrayList<>();
		List<ParentDto> parentDtoList = new ArrayList<>();
		
		if(res.hasErrors()) {
			return new ModelAndView("admin/addStudentPar");
		}else {
		
		StudentDto studentDto = new StudentDto();
		studentDto.setName(addStuPar.getNameSt());
		studentDto.setSurname(addStuPar.getSurnameSt());
		studentDto.setPassword(addStuPar.getPasswordSt());
		studentDto.setPesel(addStuPar.getPeselSt());
		studentDto.setIdSchoolGroup(addStuPar.getIdSchoolGroup());
		studentDtoList.add(studentDto);
		
		System.out.println("Pesel StudentDto: " + studentDto.getPesel());
		
		
		ParentDto parentDto = new ParentDto();
		parentDto.setName(addStuPar.getNameP());
		parentDto.setSurname(addStuPar.getSurnameP());
		parentDto.setEmail(addStuPar.getEmail());
		parentDto.setStudentsDto(studentDtoList);
		parentDtoList.add(parentDto);
		parentService.save(parentDto);
		Parent parentId = parentRepository.findByEmail(parentDto.getEmail());
		studentDto.setParentsDto(parentDtoList);
		System.out.println("Parent z pasującym mailem : " + parentId.getEmail() + " " + parentId.getId());
		studentService.save(studentDto);
		
		Student sto = studentRepository.findByPesel(studentDto.getPesel());
		System.out.println("Student : " + sto.getName() + " " + sto.getSurname() + " " + sto.getPesel());
		
		return new ModelAndView("admin/addStudentPar");
		}
	}

	@GetMapping("/addStudent")
	public ModelAndView addStudent() {

		ModelAndView model = new ModelAndView("admin/addStudent");
		model.addObject("studentDto", new StudentDto());
		//		model.addAttribute("studentDto", studentDto);
		return model;
	}

	@PostMapping("/addStudent")
	public ModelAndView processAddStudent(
			@Valid StudentDto dto,
			BindingResult res,
			Model model) {
		//		model.addAttribute("studentDto", studentDto);

		System.out.println(dto);

		if(res.hasErrors()) {
			return new ModelAndView("admin/addStudent");
		}
		dto = studentService.save(dto);
		model.addAttribute("studentDto", dto);
		return new ModelAndView("admin/addStudent");
	}
	
	@GetMapping("/addParent")
	public ModelAndView AddParent() {

		ModelAndView model = new ModelAndView("admin/addParent");
		model.addObject("parentDto", new StudentDto());
		//		model.addAttribute("studentDto", studentDto);
		return model;
	}
	

	@GetMapping("/showStudents")
	public ModelAndView showStudents() {
//		List<Parent> parents = new Student().getParents();
		StudentDto studentDto = studentRepository.findOne(new Long(2)).toDto();
		List<StudentDto> listsStudentDto = new ArrayList<>();
		listsStudentDto.add(studentDto);
//		studentService.getAll()

		ModelAndView model = new ModelAndView("admin/showStudents");
		model.addObject("listsStudentDto", listsStudentDto);
		//		model.addAttribute("studentDto", studentDto);
		return model;
	}

	@PostMapping("/showStudent")
	public ModelAndView showStudentsForView() {
		
		List<StudentDto> listsStudentDto = studentService.getAll();
		
//		StudentDto studentdto = studentService.find(id);

		ModelAndView model = new ModelAndView("admin/showStudent");
		model.addObject("listsStudentDto", listsStudentDto);
		//		model.addAttribute("studentDto", studentDto);
		return model;
	}
	
	@GetMapping("/showParents")
	public ModelAndView showParents() {
		
//		List<ParentDto> listsParentDto = new ArrayList<>();
		Collection<ParentDto> listsParentDto = parentService.getAll();

		ModelAndView model = new ModelAndView("admin/showParents");
		model.addObject("listsParentDto", listsParentDto);
		//		model.addAttribute("studentDto", studentDto);
		return model;
	}

	@PostMapping("/showParents")
	public ModelAndView showParentsForView() {
		
		Collection<ParentDto> listsParentDto = parentService.getAll();
		
		System.out.println("Lista Parentow : ");
		
//		StudentDto studentdto = studentService.find(id);

		ModelAndView model = new ModelAndView("admin/showParents");
		model.addObject("listsParentDto", listsParentDto);
		//		model.addAttribute("studentDto", studentDto);
		return model;
	}

}
