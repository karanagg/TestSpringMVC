package com.karan.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.karan.login.LoginService;


@Controller
public class LoginController {
	
	@Autowired
	LoginService logService;
	
	@RequestMapping (value = "/login", method = RequestMethod.GET)
     public String showLogin(){
		System.out.println("inside show login ");
    	 return "login";
     }
	
	@RequestMapping (value = "/login", method = RequestMethod.POST)
    public String showLoginPost(@RequestParam String name, String password, ModelMap model){
		System.out.println(name);
		if(logService.validateUser(name, password)){
		model.put("name",name);
		model.put("password",password);
   	 		return "welcome";
		}else{
			model.put("errorMessage","Invalid Credentials");
			return "login";
		}
    }

}
