package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomepageController {

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@RequestMapping(value="/signindemo", method=RequestMethod.GET)
	public ModelAndView signin() {
		ModelAndView mav = new ModelAndView("signindemo");
		return mav;
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView mav = new ModelAndView("signup");
		return mav;
	}

}
