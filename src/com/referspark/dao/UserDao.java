package com.referspark.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.referspark.common.CommonException;
import com.referspark.domain.User;

public class UserDao implements BaseDao{
	private SessionFactory sessionFactory;
	
	public Object save(Object obj) throws CommonException{
		Object newObj = sessionFactory.getCurrentSession().save(obj);
		if(newObj != null) {
			return newObj;
		}
		else
			throw new CommonException();

	}
	public void update(Object obj) throws CommonException{
		sessionFactory.getCurrentSession().update(obj);
	}
	public Object delete(Object obj) throws CommonException{
		return null;
	}	
	
	public Object readById(int id) throws CommonException{
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("userid", id));
		try{
			return criteria.uniqueResult();
		}catch (HibernateException e) {
			throw new CommonException();
		}
	}
		
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
}
