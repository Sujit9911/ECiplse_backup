package com.frontend;

import com.service.LoginService;

public class Login {
    public static void main(String[] args) {
        LoginService loginService = new LoginService();

        
        String email = "Rekha@gmail.com";
        String password = "rekha@451";

     
        String result = loginService.doLogin(email, password);

       
        System.out.println(result);
    }
}
