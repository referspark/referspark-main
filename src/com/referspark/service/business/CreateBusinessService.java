package com.referspark.service.business;

import java.text.DateFormat;

import org.springframework.transaction.annotation.Transactional;

import com.referspark.api.response.CreateBusinessResponse;
import com.referspark.api.response.GetExistingMiniBusinessResponse;
import com.referspark.common.CommonException;
import com.referspark.dao.BusinessDao;
import com.referspark.dao.UserDao;
import com.referspark.domain.Business;
import com.referspark.domain.User;

public class CreateBusinessService {
    
	private UserDao userDao;
	private BusinessDao businessDao;
	
	@Transactional
	public CreateBusinessResponse createBusiness(String email, String firstName, String lastName,
			                                      String mobile, String businessName, String password, String city,
			                                      String industry,int businessId){
		CreateBusinessResponse response = new CreateBusinessResponse();
		response.setSuccess(true);
		
		Business business = new Business();
		User user = new User();
			
		try{
	       //If this business id already exists
	       if(businessId != -1){
		        business = (Business)businessDao.readById(businessId);
		        user = business.getUser();
		       //TODO: refactor the common things, if have time!
		        business.setCity(city);
				business.setIndustry(industry);
				business.setPassword(password);
				business.setHasfullinfo(1);
				business.setFullinfoenterdate(new java.sql.Date(new java.util.Date().getTime()));
			    business.setBusinessname(businessName);	//Lets allow changing this fields for the existing business as well			    
				user.setEmail(email); //Lets allow changing this fields for the existing business as well		
				user.setFirstname(firstName);
				user.setLastname(lastName);
				user.setMobile(mobile);					
				
				userDao.update(user);
				businessDao.update(business);
				response.setGeneratedBusinessId(businessId);
	       }else{ 
	    	  business.setCity(city);
	   		  business.setIndustry(industry);
	  		  business.setHasfullinfo(1);
	   		  user.setFirstname(firstName);
	   		  user.setLastname(lastName);
	   		  user.setMobile(mobile); 
	   		
		      user.setEmail(email);		
		      business.setBusinessname(businessName);	
		      business.setPassword(password);
			  business.setOnboarddate(new java.sql.Date(new java.util.Date().getTime())); //only if business does not exist
			  business.setFullinfoenterdate(new java.sql.Date(new java.util.Date().getTime()));
			
		      int userid = (Integer)userDao.save(user);
			  user = (User)userDao.readById(userid);
			  business.setUser(user);
			  businessId = (Integer)businessDao.save(business);
			  response.setGeneratedBusinessId(businessId);
	       }
		} catch (CommonException e) {			
			e.printStackTrace();
			response.setSuccess(false);
		}
		return response;
	}
	
	@Transactional
	public CreateBusinessResponse createBusinessWithMinimumParams(String email, String businessName){
		CreateBusinessResponse response = new CreateBusinessResponse();
		response.setSuccess(true);
		
		Business business = new Business();
		User user = new User();
		
		business.setBusinessname(businessName);
		business.setHasfullinfo(0);
		business.setOnboarddate(new java.sql.Date(new java.util.Date().getTime()));
		user.setEmail(email);	
		
		try {
			int userid = (Integer)userDao.save(user);
			user = (User)userDao.readById(userid);
			business.setUser(user);
			int businessId = (Integer)businessDao.save(business);
			response.setGeneratedBusinessId(businessId);
		} catch (CommonException e) {			
			e.printStackTrace();
			response.setSuccess(false);
		}
		return response;
	}
	
	@Transactional
	public GetExistingMiniBusinessResponse getExistingMiniBusiness(int businessId){
		GetExistingMiniBusinessResponse response = new GetExistingMiniBusinessResponse();
		
		if(businessId == -1){
			response.setGeneratedBusinessId(-1);
			response.setSuccess(false);
			return response;
		}
		try {
			Business business = (Business)businessDao.readById(businessId);
			if(business == null){
				response.setSuccess(false);
			}else{
				response.setGeneratedBusinessId(businessId);
		    	response.setBusinessname(business.getBusinessname());
			    response.setEmail(business.getUser().getEmail());
			    response.setSuccess(true);
			}
		} catch (CommonException e) {
			response.setSuccess(false);
			response.setGeneratedBusinessId(-1);
			e.printStackTrace();
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
