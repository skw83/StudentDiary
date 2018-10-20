package pl.school.student.controller;

import java.util.Objects;

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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import pl.school.student.dto.StudentDto;
import pl.school.student.service.StudentService;

@Controller
@RequestMapping("/student")
@SessionAttributes(names = {"studentDto", "isLoggedIn"})
public class StudentController {
	
	private final StudentService studentService;
	
	StudentDto studentDto = new StudentDto();
	private Boolean isLoggedIn =false;
	
	
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
//	@GetMapping("/register")
//	public ModelAndView registerNewStudent(Model model) {
//		model.addAttribute("studentDto", studentDto);
//		return new ModelAndView("/student/register");
//	}
//
//	@PostMapping("/register")
//	public ModelAndView processRegisterNewStudent(@Valid @ModelAttribute("studentDto") StudentDto dto,
//			BindingResult rs,
//			@SessionAttribute("isLoggedIn") Boolean isLoggedIn,
//			Model model) {
//		
//		if(rs.hasErrors()) {
//			return new ModelAndView("student/register");
//		}
//		dto = studentService.save(dto);
//		model.addAttribute("isLoggedIn", true);
//		model.addAttribute("student", dto);
//		return new ModelAndView("redirect:/student/index");
//	}
	
	@GetMapping("/hello")
	public String helloStudent() {
		
		return "student/hello";
	}
	
	@GetMapping("/login")
	public ModelAndView loginStudent(Model model) {
		model.addAttribute("studentDto", new StudentDto());
		return new ModelAndView("student/login");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginStudent(
			@ModelAttribute("studentDto") StudentDto dto,
			@SessionAttribute("isLoggedIn") Boolean isLoggedIn,
			Model model) {
//		isLoggedIn = false;
		model.addAttribute("isLoggedIn", false);
		
//		model.addAttribute("studentDto", new StudentDto());
		
		StudentDto studentDto = studentService.login(dto);
		if(Objects.nonNull(studentDto)) {
			isLoggedIn = true;
			dto = studentDto;
			model.addAttribute("isLoggedIn", true);
			model.addAttribute("studentDto", studentDto);
			return new ModelAndView("redirect:/student/index");
		}
		System.out.println(dto.toString());
		return new ModelAndView("student/login");
	}
	
}
