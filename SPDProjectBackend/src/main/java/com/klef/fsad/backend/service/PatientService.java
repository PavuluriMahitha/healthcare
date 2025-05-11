package com.klef.fsad.backend.service;

import com.klef.fsad.backend.model.Patient;
import com.klef.fsad.backend.model.Appointment;
import java.util.List;

public interface PatientService {
    String registerPatient(Patient patient);
    Patient checkPatientLogin(String username, String password);
    Patient getPatientProfile(String username);
    List<Appointment> getPatientAppointments(int patientId);
    String requestAppointment(Appointment appointment);
}
