package com.service;

import java.time.LocalDateTime;

import com.dao.Registerdao;
import com.entity.User;

public class RegisterService {

	public String doRegister(User user) {
		Registerdao dao=new Registerdao();
		user.setDateOfCreation(LocalDateTime.now());
		
		boolean isRegistered=dao.doRegister(user);
		if(isRegistered) {
			return "Successfulllll";
		}else {
			return "failed";
		}
		
		
		
	}
}

