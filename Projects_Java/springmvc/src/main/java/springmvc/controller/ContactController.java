package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
class ContactController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public void commonModelData(Model m) {
		m.addAttribute("Header", "Test Header for pages");
		m.addAttribute("Desc", "Description for sample test");
	}

	@RequestMapping("/contact")
	public String ContactManager(Model m) {
		return "contact";
	}
	
	@RequestMapping(path ="/processForm",method=RequestMethod.POST)
	public String processForm(@ModelAttribute("user") User user,Model model,BindingResult result) {
		
		if(result.hasErrors()) {
			return"contact";
		}
		if(user.getEmail().isBlank()) {
			System.out.println("blank email");
			return "redirect:/contact";
		}
		System.out.println(user);
		 this.userService.createUser(user);
		return "success";
	}
	/*public String processForm(HttpServletRequest request) {
		System.out.println(request.getParameter("password"));
		System.out.println(request.getParameter("email"));
		return "success";
	}
	public String processForm(@RequestParam("email") String email,@RequestParam("password") String pass,Model model) {
		model.addAttribute("email",email);
		model.addAttribute("password",pass);
		return "success";
	}*/
}
