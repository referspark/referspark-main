package com.referspark.dao;

import org.hibernate.SessionFactory;

import com.referspark.common.CommonException;

public interface BaseDao {
	public Object save(Object obj) throws CommonException;
	public Object readById(int id) throws CommonException;
	public void update(Object obj) throws CommonException;
	public Object delete(Object obj) throws CommonException;
	
	public SessionFactory getSessionFactory();
}
