package com.validation;

import java.util.HashSet;

public class Emailvalidation {
    private static HashSet<String> emails = new HashSet<>();

    public boolean validateEmail(String email) {
        if (email == null) {
            return false;
        }

        String lowerEmail = email.toLowerCase();

       
        if (!lowerEmail.endsWith("@gmail.com") || lowerEmail.equals("@gmail.com")) {
            System.out.println("❌ Invalid email: must be a Gmail address with username before @gmail.com");
            return false;
        }

        if (emails.contains(lowerEmail)) {
            System.out.println("❌ Duplicate email: already registered");
            return false;
        }

        
        emails.add(lowerEmail);
        System.out.println("✅ Email registered successfully");
        return true;
    }



}