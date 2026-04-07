package com.service;

import com.dao.DoctorDAO;
import com.entity.Doctor;
import com.util.EmailUtil;
import com.util.ValidationUtil;

public class DoctorService {
    
    private DoctorDAO dao = new DoctorDAO();
    
    public String registerDoctor(String name, String email, String specialization, 
                                  double fee, int experience) {
        
        if (email == null || email.trim().isEmpty()) {
            return "Error: Email cannot be blank";
        }
        
        if (!ValidationUtil.isValidEmail(email)) {
            return "Error: Invalid email format";
        }
        
        if (dao.findByEmail(email) != null) {
            return "Error: Email already exists";
        }
        
        if (!ValidationUtil.isValidFee(fee)) {
            return "Error: Fee must be between 500-5000";
        }
        
        if (!ValidationUtil.isValidExperience(experience)) {
            return "Error: Experience must be at least 1 year";
        }
        
        String capSpecialization = specialization.substring(0, 1).toUpperCase() + 
                                   specialization.substring(1).toLowerCase();
        
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setEmail(email);
        doctor.setSpecialization(capSpecialization);
        doctor.setConsultationFee(fee);
        doctor.setExperience(experience);
        doctor.setStatus("Available");
        
        dao.save(doctor);
        
        String emailBody = "Welcome Dr. " + name + "!\n" +
                          "Doctor ID: " + doctor.getDoctorId() + "\n" +
                          "Specialization: " + capSpecialization + "\n" +
                          "Consultation Fee: Rs." + fee;
        EmailUtil.sendEmail(email, "Doctor Registration Successful", emailBody);
        
        return "Success! Doctor ID: " + doctor.getDoctorId();
    }
}
