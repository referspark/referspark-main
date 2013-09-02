package com.referspark.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.referspark.api.response.GenericSuccessFailureResponse;
import com.referspark.service.LoginService;

@Controller
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	LoginService loginService = null;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	@ResponseBody
	public GenericSuccessFailureResponse getLogin(HttpServletRequest req) { 
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		return loginService.getLoginResponse(username, password);
   }  

}
