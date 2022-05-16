package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

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
	
	
	
	public void processUser(UserDto userDto) {
		
		if(userDto.getId() == null) {
			
			User user = new User();
			
			BeanUtils.copyProperties(userDto, user);
			
			
			userDao.save(user);
			
			
		}else {
			User user = new User();
			
			BeanUtils.copyProperties(userDto, user);
			
			
			userDao.save(user);
		}
		
		
		
		
	}



	public List<UserDto> findAllUsers() {
		
		
		List<User> users =  userDao.findAll();
		
		List<UserDto> userDtos = new ArrayList<>();
		
		/*
		 * for(User user : users) { UserDto userDto = new UserDto();
		 * 
		 * BeanUtils.copyProperties(user, userDto);
		 * 
		 * 
		 * userDtos.add(userDto); }
		 */
		
		
		users.forEach(obj -> {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(obj, userDto);
			userDtos.add(userDto);
		});
		
		
		
		return userDtos;
	}



	public UserDto getUserById(Integer id) {
		
		User user = userDao.getById(id);
		
		UserDto userDto = new UserDto();
		
		BeanUtils.copyProperties(user, userDto);
		
		
		return userDto;
	}
	
	

}
