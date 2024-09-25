package springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("name", "Dhruv Pandey");
		model.addAttribute("number",1234567890);
		List<String> friends = new ArrayList<String>();
		friends.add("Ganesh Sanap");
		friends.add("Prajwal Gadge");
		friends.add("Ganesh Vishwakarma");
		friends.add("Avadhut Vagal");
		model.addAttribute("friends",friends);
		System.out.println("This is about controller");
		return "about";
	}
}
