package com.koderunner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koderunner.vo.EmployeeVO;

@Controller
public class AdminLogin {
	@RequestMapping(value="/LoginUser", method=RequestMethod.POST)
	public String loginUser(@ModelAttribute("SpringMavenProject")EmployeeVO user, ModelMap map) {
		
		map.addAttribute("name", user.getName());
		map.addAttribute("password",user.getPassword());
		return "loginSuccess";
	}

}
