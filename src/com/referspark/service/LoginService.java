package com.referspark.service;

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

}
