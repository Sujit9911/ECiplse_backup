package com.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Validatepassword {

    // ✅ Check password strength
    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            System.out.println("❌ Weak password: make a strong password (min 8 characters).");
            return false;
        }
        System.out.println("✅ Strong password accepted.");
        return true;
    }

    // ✅ Encrypt password using SHA-256
    public static String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error: SHA-256 algorithm not found!", e);
        }
    }

    // ✅ Match raw password with encrypted one
    public static boolean matchPassword(String rawPassword, String encryptedPassword) {
        String hashedPassword = encryptPassword(rawPassword);
        return hashedPassword.equals(encryptedPassword);
    }
}
