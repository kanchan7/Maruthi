package com.koderunner.dao;

import java.util.List;
import java.util.Properties;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.koderunner.vo.Product;
import com.koderunner.vo.SDUserVO;

public class SDUserDAO extends HibernateDaoSupport {
	/*private static SessionFactory sessionFactory = null;  
    private static ServiceRegistry serviceRegistry = null;  
       
    private static SessionFactory configureSessionFactory() throws HibernateException {  
        Configuration configuration = new Configuration();  
        configuration.configure();  
        Properties properties = configuration.getProperties();
        serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();          
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
        return sessionFactory;  
    }*/
	
	 @SuppressWarnings("unchecked")
	public Integer checkUser(String pEmailId, String pPassword) {
	        Integer noofuser = 0;
	        List<Integer> totuser = null;
	        Transaction tx = null;
	        // Configure the session factory
	      //  configureSessionFactory();
	        Session session = getSessionFactory().openSession();
	        try {
	            tx = session.beginTransaction();
	            totuser = session.createSQLQuery("SELECT count(*) FROM SDUSER_DETAILS where EMAIL_ID='" + pEmailId + "' and PASSWORD='" + pPassword + "'").list();
	            String val = "" + totuser.get(0);
	            noofuser = Integer.parseInt(val);
	            tx.commit();
	            tx = null;
	        } catch (HibernateException e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return noofuser;
	    }
	 
	 public void save(SDUserVO pUserDetails) {
		 	Transaction tx = null;
		 	  Session session = getSessionFactory().openSession();
	        try {
	             	tx = session.beginTransaction();
		            session.saveOrUpdate(pUserDetails);
		            tx.commit();
	        } catch (Exception e) {
	            	e.printStackTrace();
	        } finally {
		            session.clear();
		            session.close();
	        }
	    }
	 @SuppressWarnings("unchecked")
		public List<SDUserVO> getAllUsers() {
		        List<SDUserVO> allUsers = null;
		        Transaction tx = null;
		        // Configure the session factory
		      //  configureSessionFactory();
		        Session session = getSessionFactory().openSession();
		        try {
		            tx = session.beginTransaction();
		            allUsers = ( List<SDUserVO>)(session.createSQLQuery("SELECT * FROM SDUSER_DETAILS").list());
		            tx.commit();
		            tx = null;
		        } catch (HibernateException e) {
		            e.printStackTrace();
		        } finally {
		            session.close();
		        }
		        return allUsers;
		    }
	 
	 
	 
	 @SuppressWarnings("unchecked")
		public SDUserVO findUserByLoginId(String pLoginId) {
		        List<SDUserVO> allUsers = null;
		        SDUserVO vUser = null;
		        Transaction tx = null;
		        Session session = getSessionFactory().openSession();
		        try {
		        	Query query = session.createQuery("from SDUserVO where loginId='"+pLoginId+"'");
		        	allUsers = query.list();
		        	System.out.println(12345);
		        	for(SDUserVO kUser:allUsers){
		        		System.out.println(kUser.getLoginId());
		        	}
		      
		        } catch (HibernateException e) {
		            e.printStackTrace();
		        } finally {
		            session.close();
		        }
		        return allUsers.get(0);
		        
		    }
	 
	 
	 
	
	 
}
