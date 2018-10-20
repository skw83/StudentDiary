package pl.school.doTestow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("/testowy")
public class TestowyController {
	
	@GetMapping(path = "/test")
	public	ModelAndView simple(Model model)	{
		
		KlasaTestowa testKl = new KlasaTestowa();
		model.addAttribute("testKl", testKl);
					return	new ModelAndView("/test");
	}
	
	@PostMapping(path = "/test")
	public	String	processSimple(@ModelAttribute("testKl") KlasaTestowa testKl, BindingResult result)	{
		
//					KlasaTestowa testKl	=	new	KlasaTestowa(name,	surname, pesel);
//					model.addAttribute("testoweDane",	new KlasaTestowa());
					String msg = testKl.toString();
					System.out.println(msg);
					
					return	("/welcomePage");
	}

}
