package com.koderunner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/SayHello")
public class HelloController {
	@RequestMapping(method=RequestMethod.GET)
	public String sayHello(ModelMap model){
		model.addAttribute("greeting", "Welcome to code runner");
		return "Welcome";
		
	}
	
}
