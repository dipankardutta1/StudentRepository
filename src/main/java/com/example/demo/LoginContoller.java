package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.UserDto;
import com.example.demo.service.LoginService;

@Controller
public class LoginContoller { // login
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String goToLoginPage() {
		
		
		// code
		
		
		
		return "login.jsp";
		
	}
	
	
	
	
	@RequestMapping(value = "/dologin",method = RequestMethod.POST)
	public String validateUser(Model model,@RequestParam("username") String username,@RequestParam("password") String password) {
		
		
		UserDto userDto = loginService.getValidUserFromLogin(username, password);
		
		if(userDto != null) {
			
			UserDto formDto = new UserDto();
			
			List<UserDto> users = loginService.findAllUsers();
			
			
			model.addAttribute("formDto", formDto);
			
			model.addAttribute("userList", users);
			
			
			
			
			
			return "dashboard.jsp"; // forward
		}else {
			return "redirect:login"; // sendredirect
		}
		
		
		
		
		
	}

}
