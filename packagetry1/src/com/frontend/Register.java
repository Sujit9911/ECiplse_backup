package com.frontend;

import com.controller.RegisterController;
import com.entity.User;

public class Register {

	public static void main(String[] args) {
   User user=new User();
   user.setName("john");
   user.setProfile("dec");
   user.setEmail("john@gmail.com");
   user.setSalary(510000);
   user.setAge(39);
   user.setExperience(27);
   RegisterController controller = new RegisterController();
	String msg = controller.doRegister(user);
	System.out.println(msg);
}
	}


