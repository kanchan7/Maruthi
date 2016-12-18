package com.koderunner.util;

import java.io.IOException;
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.koderunner.dao.SDUserDAO;



public class SDUserUtil {
	 private SDUserDAO userDao;
	 public Blob getImage(@RequestParam("file") MultipartFile file) throws HibernateException, IOException{
		 Blob blobObj = (Blob) Hibernate.getLobCreator(getUserDao().getSessionFactory().getCurrentSession()).createBlob(file.getInputStream(), file.getSize());
		 return blobObj;
	 }
	public SDUserDAO getUserDao() {
		if(userDao == null){
			userDao = new SDUserDAO();
		}
		return userDao;
	}
	
	
	
}
