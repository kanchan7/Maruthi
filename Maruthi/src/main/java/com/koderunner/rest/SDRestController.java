package com.koderunner.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.koderunner.dao.SDUserDAO;
import com.koderunner.vo.SDUserVO;

@RestController
public class SDRestController {
	@Autowired
    SDUserService userService;
	@Autowired
    SDUserDAO userDAO;
    
    
    /*@RequestMapping(value = "/addUser",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity addUserDetails() {
		
		return new ResponseEntity("Shailendra added", HttpStatus.OK);
	}
    
	@RequestMapping(value = "/customer/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity getUserDetails(@PathVariable("id")String id) {
		
		return new ResponseEntity("Shailendra", HttpStatus.OK);
	}*/
	
	 //-------------------Retrieve Single User--------------------------------------------------------
    
	
    @RequestMapping(value = "/user/{loginId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SDUserVO> getUser(@PathVariable("loginId") String loginId) {
        System.out.println("Fetching User with loginId " + loginId);
       // SDUserVO user = userService.findUserById(userDAO,loginId);
        SDUserVO user = (SDUserVO) userDAO.findUserByLoginId(loginId);
        
        if (user == null) {
            System.out.println("User with id " + loginId + " not found");
            return new ResponseEntity<SDUserVO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SDUserVO>(user, HttpStatus.OK);
    }	
	



}
