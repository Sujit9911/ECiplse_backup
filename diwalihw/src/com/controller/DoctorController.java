package com.controller;

import com.service.DoctorService;
import java.util.Scanner;

public class DoctorController {
    
    private DoctorService service = new DoctorService();
    
    public void registerDoctor() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n--- Doctor Registration ---");
        
        System.out.print("Name: ");
        String name = sc.nextLine();
        
        System.out.print("Email: ");
        String email = sc.nextLine();
        
        System.out.print("Specialization: ");
        String specialization = sc.nextLine();
        
        System.out.print("Consultation Fee (500-5000): ");
        double fee = sc.nextDouble();
        
        System.out.print("Experience (years): ");
        int experience = sc.nextInt();
        
        String result = service.registerDoctor(name, email, specialization, fee, experience);
        System.out.println("\n" + result);
    }
}