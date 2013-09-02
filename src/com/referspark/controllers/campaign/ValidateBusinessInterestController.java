package com.referspark.controllers.campaign;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.referspark.api.response.GenericSuccessFailureResponse;
import com.referspark.service.campaign.ValidateBusinessInterestService;

@Controller
@RequestMapping("/api")
public class ValidateBusinessInterestController {
	@Autowired
	ValidateBusinessInterestService businessInterestService = null;
	
	@RequestMapping(value="/addPotentialCustomer", method = RequestMethod.GET)
	@ResponseBody
	public GenericSuccessFailureResponse addPotentialCustomer(HttpServletRequest req){
		String email = req.getParameter("email");
		String businessName = req.getParameter("businessname");
		String mobile = req.getParameter("mobile");
		
		return businessInterestService.savePotentialCustomerDetails(email, businessName, mobile);
	}
}
