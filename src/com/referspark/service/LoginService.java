package com.referspark.service;

import com.referspark.api.response.LoginResponse;
import com.referspark.domain.Login;

public class LoginService {
	
	public Login getLogin() {  
		Login l = new Login();

        try {
             l.setUserName("Siva");
             l.setPassword("****");
        } catch (Exception e) {  
               
        }          
        return l;
   }  
	
	public LoginResponse getLoginResponse(String username, String password){
		LoginResponse response = new LoginResponse();
		if("manas".equals(username) && "panda".equals(password)){
			response.setSuccess(true);
		}else{
			response.setSuccess(false);
		}
		return response;
	}

}
