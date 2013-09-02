package com.referspark.dao;

import org.hibernate.SessionFactory;

import com.referspark.common.CommonException;

public class BusinessDao implements BaseDao{
	
	private SessionFactory sessionFactory;
	
	public Object save(Object obj) throws CommonException{
		Object newObj = sessionFactory.getCurrentSession().save(obj);
		if(newObj != null) {
			return newObj;
		}
		else
			throw new CommonException();

	}
	public Object update(Object obj) throws CommonException{
		return null;
	}
	public Object delete(Object obj) throws CommonException{
		return null;
	}	
	
	public Object readById(int id) throws CommonException{
		return null;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
}
