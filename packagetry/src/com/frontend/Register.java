package com.frontend;

import com.controller.RegisterController;
import com.entity.User;

public class Register {

	public static void main(String[] args) {

		User user = new User();
		user.setFname("SUJIT");
		user.setEmail("sujitgavali@gmail.com");
		user.setLname("kiranacademy");
		user.setLocation("pune");
		user.setMob(23456789);
		user.setPassword("Sakshi@123");
		user.setUsername("admin");

		RegisterController controller = new RegisterController();
		String msg = controller.doRegister(user);
		System.out.println(msg);
	}
}
