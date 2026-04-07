package com.frontend;
import com.controller.RegisterController;
import com.entity.User;
public class Register {
public static void main(String[] args) {
	User user=new User();
	user.setName("Rekha");
	user.setEmail("rekha@gmail.com");
	user.setCity("mumbai");
	user.setPassword("rekha@451");
	 RegisterController controller = new RegisterController();
		String msg = controller.doRegister(user);
		System.out.println(msg);
	}



}

