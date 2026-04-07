package com.util;

public class EmailUtil {
    
    public static void sendEmail(String to, String subject, String body) {
        System.out.println("\n--- EMAIL SENT ---");
        System.out.println("To: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
        System.out.println("------------------\n");
    }
}