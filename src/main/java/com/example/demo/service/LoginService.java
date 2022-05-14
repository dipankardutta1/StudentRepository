package com.example.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

@Service
public class LoginService {
	
	@Autowired
	private UserDao userDao;
	
	public UserDto getValidUserFromLogin(String username,String password) {
		
		User user = userDao.getUserByUsernameAndPasword(username, password);
		
		if(user == null ) {
			return null;
		}else {
			UserDto userDto = new UserDto();
			
			BeanUtils.copyProperties(user, userDto);
			
			
			return userDto;
		}
		
		
		
		
	}

}
