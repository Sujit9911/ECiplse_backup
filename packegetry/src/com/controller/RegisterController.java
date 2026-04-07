package com.controller;

import com.entity.User;
import com.service.RegisterService;

public class RegisterController {
	public String doRegister(User user) {
		RegisterService service=new RegisterService();
		return service.doregister(user);
		
	}

}
