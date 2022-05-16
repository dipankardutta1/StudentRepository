package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.UserDto;
import com.example.demo.service.LoginService;

@Controller
public class DashboardController {
	
	@Autowired
	private LoginService loginService;
	
	@InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
     SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
     dateFormat.setLenient(false);
     webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
     }
	
	
	@RequestMapping(value = "/processUser",method = RequestMethod.POST)
	public String processUserData(Model model,@ModelAttribute("formDto") UserDto userDto) {
		
		
		loginService.processUser(userDto);
		
		
		List<UserDto> users = loginService.findAllUsers();
		
		UserDto formDto = new UserDto();
		
		model.addAttribute("formDto", formDto);
		
		model.addAttribute("userList", users);
		
		return "dashboard.jsp"; // forward
		
		
		
		
	}
	
	
	
	@RequestMapping(value = "/editUser",method = RequestMethod.GET)
	public String editUser(Model model,@RequestParam("id") Integer id) {
		
		
		UserDto formDto = loginService.getUserById(id);
		
		
		List<UserDto> users = loginService.findAllUsers();
		
		
		
		model.addAttribute("formDto", formDto);
		
		model.addAttribute("userList", users);
		
		return "dashboard.jsp"; // forward
		
		
		
		
	}

}
