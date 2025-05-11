package com.klef.fsad.backend.service;

import com.klef.fsad.backend.model.Patient;
import com.klef.fsad.backend.model.Appointment;
import com.klef.fsad.backend.repository.PatientRepository;
import com.klef.fsad.backend.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public String registerPatient(Patient patient) {
        patientRepository.save(patient);
        return "Patient registered successfully";
    }

    @Override
    public Patient checkPatientLogin(String username, String password) {
        return patientRepository.findByUsernameAndPassword(username, password);  
    }


    @Override
    public Patient getPatientProfile(String username) {
        return patientRepository.findByUsername(username);
    }


    @Override
    public List<Appointment> getPatientAppointments(int patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    @Override
    public String requestAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
        return "Appointment request sent!";
    }
}
