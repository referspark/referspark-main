package com.referspark.service.login;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.referspark.api.response.GenericSuccessFailureResponse;
import com.referspark.dao.UserDao;
import com.referspark.domain.Business;
import com.referspark.service.BaseService;

public class LoginService extends BaseService {
	private UserDao userDao;
	
	@Transactional
	public GenericSuccessFailureResponse getLoginResponse(String username, String password){
		String sql = "from User b where b.username = :username and b.password = :password";
		
		@SuppressWarnings("unchecked")
		List<Business> business = userDao.getSessionFactory().getCurrentSession().createQuery(sql)
				.setParameter("username", username)
				.setParameter("password", password)
				.list(); 
		GenericSuccessFailureResponse response = new GenericSuccessFailureResponse();
		if(business != null && business.size() > 0){
			response.setSuccess(true);
		}else{
			response.setSuccess(false);
		}
		return response;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
