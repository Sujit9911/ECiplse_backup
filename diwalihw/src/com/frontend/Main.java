package com.frontend;

import com.controller.PatientController;
import com.controller.DoctorController;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientController patientController = new PatientController();
        DoctorController doctorController = new DoctorController();
        
        while (true) {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Register Patient");
            System.out.println("2. Register Doctor");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    patientController.registerPatient();
                    break;
                case 2:
                    doctorController.registerDoctor();
                    break;
                case 3:
                    System.out.println("Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}