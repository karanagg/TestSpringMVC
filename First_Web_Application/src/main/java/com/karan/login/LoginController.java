package com.karan.login;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {
	
/*	@Autowired
	LoginService logService;
	*/
	@RequestMapping (value = "/", method = RequestMethod.GET)
     public String showLogin(ModelMap model){
		System.out.println("inside show login ");
		model.addAttribute("name","Karan");
    	 return "welcome";
     }
	
/*	@RequestMapping (value = "/login", method = RequestMethod.POST)
    public String showLoginPost(ModelMap model, @Valid Login login, BindingResult result ){
		
	
		if(logService.validateUser(login.getUser(), login.getPassword())){
		model.put("name",login.getUser());
		model.put("password",login.getPassword());
   	 		return "welcome";
		}else{
			model.put("errorMessage","Invalid Credentials");
			return "login";
		}
    }*/

}
