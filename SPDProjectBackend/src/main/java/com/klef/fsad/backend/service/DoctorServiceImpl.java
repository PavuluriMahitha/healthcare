package com.klef.fsad.backend.service;

import com.klef.fsad.backend.model.Doctor;
import com.klef.fsad.backend.model.DoctorAppointment;
import com.klef.fsad.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorAppointmentRepository appointmentRepository;

    @Override
    public Doctor checkDoctorLogin(String username, String password) {
        return doctorRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Doctor getDoctorProfile(String username) {
        return doctorRepository.findByUsername(username);
    }



    @Override
    public List<DoctorAppointment> getDoctorAppointments(String doctorUsername) {
        return appointmentRepository.findByDoctorUsername(doctorUsername);
    }
}
