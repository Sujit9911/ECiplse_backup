
package com.service;

import com.validation.Emailvalidation;
import java.time.LocalDateTime;
import com.dao.RegisterDao;
import com.entity.User;
import com.security.Validatepassword;

public class RegisterService {

    public String doregister(User user) {
        RegisterDao dao = new RegisterDao();
        user.setDateOfCreation(LocalDateTime.now());
        user.setDateOfModification(LocalDateTime.now());
        
        Validatepassword validatePassword=new Validatepassword();
        
        if(!Validatepassword.isValidPassword(user.getPassword())) {
        	return "Password validation failed";}
        	else {
                  
                    String encryptedPass = Validatepassword.encryptPassword(user.getPassword());
                    user.setPassword(encryptedPass);
                }
        Emailvalidation emailValidation = new Emailvalidation();

        if (!emailValidation.validateEmail(user.getEmail())) {
            return "Email validation failed";
        }

        boolean isRegistered = dao.doregister(user);
        if (isRegistered) {
            return "Successful";
        } else {
            return "Failed";
        }
    }
}



