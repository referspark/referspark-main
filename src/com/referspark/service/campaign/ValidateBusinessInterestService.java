package com.referspark.service.campaign;

import org.springframework.transaction.annotation.Transactional;

import com.referspark.api.response.GenericSuccessFailureResponse;
import com.referspark.common.CommonException;
import com.referspark.dao.BusinessDao;
import com.referspark.dao.UserDao;
import com.referspark.domain.Business;
import com.referspark.domain.TrackEmail;
import com.referspark.domain.User;
import com.referspark.service.BaseService;

public class ValidateBusinessInterestService extends BaseService {
  
	private UserDao userDao;
	private BusinessDao businessDao;
	
	@Transactional
	public GenericSuccessFailureResponse savePotentialCustomerDetails(String email, String businessName, String mobile){
		GenericSuccessFailureResponse response = new GenericSuccessFailureResponse();
		
		//store business interest info
		User user = new User();
		user.setEmail(email);
		user.setMobile(mobile);
		try {
			int userid = (Integer)userDao.save(user);
			user = (User)userDao.readById(userid);
			Business business = new Business(); 
			business.setUser(user);
			business.setName(businessName);
			businessDao.save(business);
		} catch (CommonException e) {			
			e.printStackTrace();
			response.setSuccess(false);
		}
		return response;
	}
	
	@Transactional
	public GenericSuccessFailureResponse trackEmailViewedDetails(String ipAddress, String couponCode){
		GenericSuccessFailureResponse response = new GenericSuccessFailureResponse();
		
		TrackEmail trackEmail = new TrackEmail();
		trackEmail.setIpAddress(ipAddress);
		trackEmail.setTime(System.currentTimeMillis());
		trackEmail.setCouponCode(couponCode);
		try{
			//For now lets use businessdao, lets change it latter :)
			businessDao.save(trackEmail);
		} catch (CommonException e) {			
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

	public BusinessDao getBusinessDao() {
		return businessDao;
	}

	public void setBusinessDao(BusinessDao businessDao) {
		this.businessDao = businessDao;
	}
}
