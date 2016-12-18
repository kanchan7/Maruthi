package com.koderunner.rest;

import com.koderunner.dao.SDUserDAO;
import com.koderunner.vo.SDUserVO;

public interface  SDUserService{
	

	SDUserVO findUserById(SDUserDAO pSDUserDaO, String loginId);

}
