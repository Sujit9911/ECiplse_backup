package com.controller;

import com.service.PatientService;
import java.util.Scanner;

public class PatientController {
    
    private PatientService service = new PatientService();
    
    public void registerPatient() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n--- Patient Registration ---");
        
        System.out.print("Name: ");
        String name = sc.nextLine();
        
        System.out.print("Email: ");
        String email = sc.nextLine();
        
        System.out.print("Password: ");
        String password = sc.nextLine();
        
        System.out.print("Contact (10 digits): ");
        String contact = sc.nextLine();
        
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Address: ");
        String address = sc.nextLine();
        
        String result = service.registerPatient(name, email, password, contact, age, address);
        System.out.println("\n" + result);
    }
}
