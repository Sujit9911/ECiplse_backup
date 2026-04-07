package com.util;

public class ValidationUtil {
    
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
    
    public static boolean isValidPassword(String password) {
        return password != null && password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
    }
    
    public static boolean isValidContact(String contact) {
        return contact != null && contact.matches("^\\d{10}$");
    }
    
    public static boolean isValidFee(double fee) {
        return fee >= 500 && fee <= 5000;
    }
    
    public static boolean isValidExperience(int exp) {
        return exp >= 1;
    }
}
