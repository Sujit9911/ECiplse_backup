package com.service;


import java.time.LocalDateTime;

import com.dao.RegisterDao;
import com.entity.User;

public class RegisterService {

	public String doRegister(User user) {
		RegisterDao dao=new RegisterDao();
		user.setDateOfCreation(LocalDateTime.now());
		user.setDateOfModification(LocalDateTime.now());
		boolean isRegistered=dao.doRegister(user);
		if(isRegistered) {
			return "Successfulllll";
		}else {
			return "failed";
		}
		
		
		
	}
}
