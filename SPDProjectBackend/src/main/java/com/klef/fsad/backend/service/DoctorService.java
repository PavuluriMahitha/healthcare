package com.klef.fsad.backend.service;

import com.klef.fsad.backend.model.Doctor;
import com.klef.fsad.backend.model.DoctorAppointment;

import java.util.List;

public interface DoctorService {
    Doctor checkDoctorLogin(String username, String password);
//    Doctor getDoctorProfile(String username);
    List<DoctorAppointment> getDoctorAppointments(String doctorUsername);
	Doctor getDoctorProfile(String username);
}
