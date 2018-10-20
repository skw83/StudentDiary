package pl.school.common.controller;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import pl.school.parent.dto.ParentDto;
import pl.school.student.dto.StudentDto;
import pl.school.teacher.dto.TeacherDto;

@Controller
@RequestMapping("/")
@SessionAttributes(names = {"isLogedIn", "studentDto"})
public class HomeController {
	
	@GetMapping()
	public ModelAndView indexPage(@ModelAttribute("isLogedIn") Boolean isLoggedIn, Model model) {
		
//		, @ModelAttribute("studentDto") StudentDto studentDto,
//		@ModelAttribute("parentDto") ParentDto parentDto, @ModelAttribute("teacherDto") TeacherDto teacherDto
		if(isLoggedIn ) {
//			&& Objects.nonNull(studentDto)
			return new ModelAndView("redirect:/student/index");
		}
		
//		if(isLoggedIn && Objects.nonNull(parentDto)) {
//			return new ModelAndView("redirect:/parent/index");
//		}
//		
//		if(isLoggedIn && Objects.nonNull(teacherDto)) {
//			return new ModelAndView("redirect:/teacher/index");
//		}
		
		return new ModelAndView("welcomePage");
		
	}
	
	@ModelAttribute(name = "isLogedIn")
	private Boolean isLoggedIn() {
		return false;
	}
	
	
//	@GetMapping()
//	public String viewHomePage() {
////		System.out.println("homePage powinna sie zaladowac");
//		return "welcomePage";
//	}
//	
//	@GetMapping("/next")
//	public String nextPage() {
////		System.out.println("next Page");
//		return "homePage";
//	}
//	
	
	
}
