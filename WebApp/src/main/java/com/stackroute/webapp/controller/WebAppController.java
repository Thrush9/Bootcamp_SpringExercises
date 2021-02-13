package com.stackroute.webapp.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.webapp.model.User;
import com.stackroute.webapp.repository.UserRepository;

@Controller
public class WebAppController {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	UserRepository userRepo = context.getBean("userrepo",UserRepository.class);

	@GetMapping("/")
	public String getUserDetails(ModelMap map) {
		map.put("userList", userRepo.getUsersList());
		return "display";
	}
	
	@PostMapping("saveUser")
	public String saveUser(@ModelAttribute("newUser") User userObj) {
		userRepo.addUser(userObj);
		System.out.println(userRepo.getUsersList().size());
		return "redirect:/";
	}
	
	@RequestMapping("remove")
	public String removeUSer(@RequestParam("username") String username) {
		userRepo.removeUser(username);
		return "redirect:/";
	}
}
