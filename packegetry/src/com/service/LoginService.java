package com.service;

import com.dao.RegisterDao;
import com.entity.User;

public class LoginService {

    private RegisterDao dao = new RegisterDao();

    public String doLogin(String email, String password) {

        User user = dao.getUserByEmailAndPassword(email, password);

        if (user == null) {
            return "❌ Invalid email or password. Please try again.";
        }

        return "✅ Login successful! Welcome, " + user.getName();
    }
}
