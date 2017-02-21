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

import com.koderunner.vo.SDUserVO;


@RestController
public class SDRestController {
	@Autowired
    private SDUserService userService;

    
	
    @RequestMapping(value = "/abc/user/{loginId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SDUserVO> getUserDetail(@PathVariable("loginId") String loginId) {
    	 SDUserVO user = null;
        System.out.println("Fetching User with loginId " + loginId);
       // SDUserVO user = userService.findUserById(userDAO,loginId);
        //SDUserVO user = (SDUserVO) userDAO.findUserByLoginId(loginId);
        
        if (user == null) {
            System.out.println("User with id " + loginId + " not found");
            return new ResponseEntity<SDUserVO>(HttpStatus.NOT_FOUND);
        }
        	return new ResponseEntity<SDUserVO>(user, HttpStatus.OK);
    }	
	
    @RequestMapping(value = "/user1/{loginId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SDUserVO> getUser(@PathVariable("loginId") String pLoginId) {
        System.out.println("Fetching User with loginId " + pLoginId);
        SDUserVO vUser = userService.findUserById(pLoginId);
       // SDUserVO user = (SDUserVO) userDAO.findUserByLoginId(loginId);
        
        if (vUser == null) {
            System.out.println("User with id " + pLoginId + " not found");
            return new ResponseEntity<SDUserVO>(HttpStatus.NOT_FOUND);
        }else{
        	
        	return new ResponseEntity<SDUserVO>(vUser, HttpStatus.OK);
        }
        
    }	
    @RequestMapping(value = "/user/{loginId}", method = RequestMethod.GET, headers="Accept=application/json")
    public SDUserVO getUser1(@PathVariable("loginId") String pLoginId) {
        System.out.println("Fetching User with loginId " + pLoginId);
        SDUserVO vUser = userService.findUserById(pLoginId);
       // SDUserVO user = (SDUserVO) userDAO.findUserByLoginId(loginId);
        
        if (vUser == null) {
            System.out.println("User with id " + pLoginId + " not found");
            return null;
            //return new ResponseEntity<SDUserVO>(HttpStatus.NOT_FOUND);
        }else{
        	
        	//return new ResponseEntity<SDUserVO>(vUser, HttpStatus.OK);
        	return vUser;
        	
        }
        
    }

}
