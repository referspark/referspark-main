package com.referspark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.referspark.domain.Login;
import com.referspark.service.LoginService;

@Controller
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	LoginService loginService = null;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	@ResponseBody
	public Login getLogin() {  
		return loginService.getLogin();
   }  

}
