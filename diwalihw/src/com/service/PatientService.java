package com.service;

import com.dao.PatientDAO;
import com.entity.Patient;
import com.util.EmailUtil;
import com.util.Passwordutil;
import com.util.ValidationUtil;
import java.time.LocalDateTime;

public class PatientService {
    
    private PatientDAO dao = new PatientDAO();
    
    public String registerPatient(String name, String email, String password, 
                                   String contact, int age, String address) {
        
        if (!ValidationUtil.isValidEmail(email)) {
            return "Error: Invalid email format";
        }
        
        if (dao.findByEmail(email) != null) {
            return "Error: Email already exists";
        }
        
        if (!ValidationUtil.isValidContact(contact)) {
            return "Error: Contact must be 10 digits";
        }
        
        if (dao.findByContact(contact) != null) {
            return "Error: Contact already exists";
        }
        
        if (!ValidationUtil.isValidPassword(password)) {
            return "Error: Password must have min 8 chars, 1 uppercase, 1 number, 1 special char";
        }
        
        String passwordHash = Passwordutil.hashPassword(password);
        
        Patient patient = new Patient();
        patient.setName(name);
        patient.setEmail(email);
        patient.setPasswordHash(passwordHash);
        patient.setContactNumber(contact);
        patient.setAge(age);
        patient.setAddress(address);
        patient.setRegistrationDate(LocalDateTime.now());
        patient.setStatus("Active");
        
        dao.save(patient);
        
        String emailBody = "Welcome " + name + "!\n" +
                          "Patient ID: " + patient.getPatientId() + "\n" +
                          "Email: " + email + "\n" +
                          "You can now login and book appointments.";
        EmailUtil.sendEmail(email, "Registration Successful", emailBody);
        
        return "Success! Patient ID: " + patient.getPatientId();
    }
}
