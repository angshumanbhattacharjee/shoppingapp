package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	
	@Autowired
	private UserService service;
	
	
	@RequestMapping("/find")
	public User findone(@RequestParam String name) {
		 return service.findByFirstName(name);
		
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public ModelAndView create(Model model, @ModelAttribute("user") User user, @ModelAttribute("fname")String name, @ModelAttribute("password")String password,@ModelAttribute("email")String email, @ModelAttribute("address")String address) {
		User user1= service.create(name, password, email, address);
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("users", user1);
		mav.setViewName("success");
		return mav;
	}
	
	
}
