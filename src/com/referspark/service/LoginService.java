package com.referspark.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.referspark.api.response.LoginResponse;
import com.referspark.dao.LoginDao;
import com.referspark.domain.Business;
import com.referspark.domain.Login;

public class LoginService {
	private LoginDao loginDao;
	
	@Transactional
	public LoginResponse getLoginResponse(String username, String password){
		String sql = "from Business b where b.username = :username and b.password = :password";
		
		@SuppressWarnings("unchecked")
		List<Business> business = loginDao.getSessionFactory().getCurrentSession().createQuery(sql)
				.setParameter("username", username)
				.setParameter("password", password)
				.list(); 
		LoginResponse response = new LoginResponse();
		if(business != null && business.size() > 0){
			response.setSuccess(true);
		}else{
			response.setSuccess(false);
		}
		return response;
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

}
