package com.referspark.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.referspark.api.response.GenericSuccessFailureResponse;
import com.referspark.service.business.CreateBusinessService;

@Controller
@RequestMapping("/business")
public class CreateBusinessController {
   @Autowired
   CreateBusinessService createBusinessService;
   
   @RequestMapping(value="/createBusiness", method = RequestMethod.GET)
   @ResponseBody
   public GenericSuccessFailureResponse createBusiness(HttpServletRequest req){
    	String businessName = req.getParameter("businessname");
		String mobile = req.getParameter("mobile");
		
		String firstName = req.getParameter("firstname");
		String lastName = req.getParameter("lastname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String city = req.getParameter("city");
		String industry = req.getParameter("industry");
	    String businessIdStr = req.getParameter("businessid");
	    
	    //is businessid an integer?
	    int businessId = -1;
	    try{
	    	businessId = Integer.parseInt(businessIdStr);
	    }catch(Exception e){
	    	businessId = -1;
	    }

		return createBusinessService.createBusiness(email, firstName, lastName, mobile, businessName, password, city, industry, businessId);
	}
   
   @RequestMapping(value="/createBusinessWithMinimumParams", method = RequestMethod.GET)
   @ResponseBody
   public GenericSuccessFailureResponse createBusinessWithMinimumParams(HttpServletRequest req){
    	String businessName = req.getParameter("businessname");
		String email = req.getParameter("email");		
		
		return createBusinessService.createBusinessWithMinimumParams(email, businessName);
	}
   
   @RequestMapping(value="/getExistingMiniBusiness", method = RequestMethod.GET)
   @ResponseBody
   public GenericSuccessFailureResponse getExistingMiniBusiness(HttpServletRequest req){
	   String businessIdStr = req.getParameter("businessid");
	   int businessId = -1;
	   try{
		   businessId = Integer.parseInt(businessIdStr);
	   }catch(NumberFormatException nfe){
		   businessId = -1;
	   }
	   
	   return createBusinessService.getExistingMiniBusiness(businessId);
   }
}
