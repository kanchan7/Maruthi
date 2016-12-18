package com.koderunner.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koderunner.dao.SDUserDAO;
import com.koderunner.vo.SDUserVO;
@Service("")
@Transactional
public class SDUserServiceImpl implements SDUserService{
	

    private static List<SDUserVO> populateAllUsers(SDUserDAO pSDUserDaO){
        List<SDUserVO> users = (List<SDUserVO>)(pSDUserDaO.getAllUsers());
        return users;
    }


	public SDUserVO findUserById(SDUserDAO pSDUserDaO, String pLoginId) {
		List<SDUserVO> allUsers = null;
		allUsers = populateAllUsers(pSDUserDaO);
		if(allUsers != null){
			for(Object user : allUsers){
				SDUserVO vUser = (SDUserVO)user;
				System.out.println("123");
				//String vlogid = ((SDUserVO)user).getLoginId();
				/*if((((SDUserVO)user).getLoginId()).equalsIgnoreCase(pLoginId)){
					return (SDUserVO) user;
				}*/
			}
		}
		return null;
	}




}
