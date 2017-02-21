package com.koderunner.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.koderunner.dao.SDUserDAO;
import com.koderunner.vo.SDUserVO;

public class SDUserController {
	@Autowired
    private SDUserDAO userDAO;
	
	@RequestMapping("/login/login.htm")
    public ModelAndView redirectToLoginPage(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("login");
    }
	@RequestMapping("login/userRegistration.htm")
    public ModelAndView redirectToRegistrationPage(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("login");
    }
    @RequestMapping("/login/logout.htm")
    public ModelAndView redirectToLandingPage(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        session.invalidate();
        return new ModelAndView("login");
    }
    /*@RequestMapping("/login/login.htm")
    public ModelAndView redirectToLoginPa(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("login");
    }*/
    @RequestMapping("/login/home.htm")
    public ModelAndView redirectToHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(true);
        ModelMap map = new ModelMap();
        String emailId = request.getParameter("emailId");
        String password = request.getParameter("password");
        Integer noofuser = 0;
        if (("".equals(emailId) || "".equals(password)) || (emailId == null || password == null)) {
            map.addAttribute("failmsg", "* Login failed please try again...");
            return new ModelAndView("login", map);
        } else {
            noofuser = userDAO.checkUser(emailId, password);
            if (noofuser > 0) {
                session.setAttribute("emailId", emailId);
                return new ModelAndView("../login/home", map);
            } else {
                map.addAttribute("failmsg", "* Login failed please try again...");
                return new ModelAndView("login", map);
            }
        }

    }
    
    @RequestMapping("/searchCountry.htm")
    public ModelAndView redirectToSearchCountry(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("searchCountry");
    }
    
    @RequestMapping("/login/welcome.htm")
    public ModelAndView registrationSubmit(HttpServletRequest request, HttpServletResponse response) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String UserName = request.getParameter("UserName");
        String emailId = request.getParameter("emailId");
        String password = request.getParameter("password");
       // String gender = request.getParameter("gender");
        SDUserVO userdetails=new SDUserVO("pgr12", firstName, lastName, password, emailId, UserName);
        userDAO.save(userdetails);
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("UserName", emailId);
        return new ModelAndView("../login/welcome", modelMap);
    }
}
