package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.service.UserService;



@RestController
public class SignInController {
	
	@Autowired
	private UserService service;
	
//	@RequestMapping(value = "/signin")
//	public ModelAndView init(Model model) {
//		model.addAttribute("msg", "Please Enter Your Login Details");
//		ModelAndView mav = new ModelAndView("signin");
//		return mav;
//	}

//	@RequestMapping(method = RequestMethod.POST)
//	public void validate(Model model, @ModelAttribute("user") User user) {
//		
//	}

	@RequestMapping(value="/signindemo", method = RequestMethod.POST)
	public ModelAndView validate(Model model, @ModelAttribute("user") User user) {
//		if (user != null && user.getName() != null & user.getPassword() != null) {
//			if (user.getName().equals("chandra") && user.getPassword().equals("chandra123")) {
//				model.addAttribute("msg", user.getName());
//				return "success";
//			} else {
//				model.addAttribute("error", "Invalid Details");
//				return "signin";
//			}
//		} else {
//			model.addAttribute("error", "Please enter Details");
//			return "signin";
//		}
		if(service.findByNameAndPassword(user.getName(), user.getPassword()) != null) {
			ModelAndView mav = new ModelAndView(); 
			mav.addObject("users", user);
			mav.setViewName("success");
			return mav;
		}
		else {
			ModelAndView mav1 = new ModelAndView("signindemo");
			return mav1;
		}
		
	}
}
