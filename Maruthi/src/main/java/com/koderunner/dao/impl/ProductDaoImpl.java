package com.koderunner.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.koderunner.dao.ProductDao;
import com.koderunner.vo.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory session;
	
	public void addProduct(Product product) {
		Transaction tx = null;
		Session newSession =  session.openSession();
		
		try {
			tx = newSession.beginTransaction(); 
			newSession.save(product);
			tx.commit();
			tx=null;
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			newSession.close();
        }
	}

	public void editProduct(Product product) {
		Transaction tx = null;
		Session newSession =  session.openSession();
		
		try {
			tx = newSession.beginTransaction(); 
			newSession.update(product);
			tx.commit();
			tx=null;
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			newSession.close();
        }
	}

	public void deleteProduct(int productId) {
		Transaction tx = null;
		Session newSession =  session.openSession();
		
		try {
			tx = newSession.beginTransaction(); 
			newSession.delete(getProduct(productId));
			tx.commit();
			tx=null;
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			newSession.close();
        }
	}

	public Product getProduct(int productId) {
		Session newSession =  session.openSession();
		Product product= null;
		try {
			product = (Product) newSession.get(Product.class, productId);
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			newSession.close();
        }
		return product;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProduct() {
		//return session.openSession().createSQLQuery("SELECT * FROM Product").list();
		return session.openSession().createQuery("from Product").list();
	}

}
