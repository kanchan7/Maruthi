package com.koderunner.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koderunner.dao.ProductDao;
import com.koderunner.dao.SDUserDAO;
import com.koderunner.vo.SDUserVO;
@Service("userService")
@Transactional
public class SDUserServiceImpl implements SDUserService{
	@Autowired
    private  SDUserDAO userDAO;
	
	
    private  List<SDUserVO> populateAllUsers(){
        return (List<SDUserVO>)(userDAO.getAllUsers());
    }


	public SDUserVO findUserById(String pLoginId) {
		List<SDUserVO> allUsers = null;
		allUsers = populateAllUsers();
		if(allUsers != null){
			for(SDUserVO vUser:allUsers){
	    		if(vUser.getLoginId().equalsIgnoreCase(pLoginId)){
	    			return vUser;
	    		}
	    	}
		}
		return null;
	}




}
