package com.klef.fsad.backend.controller;

import com.klef.fsad.backend.model.Doctor;
import com.klef.fsad.backend.model.DoctorAppointment;
import com.klef.fsad.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@CrossOrigin("*")  
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorAppointmentRepository appointmentRepository;

    @PostMapping("/checkdoctorlogin")
    public ResponseEntity<?> checkLogin(@RequestBody Doctor i) {
        Doctor doctor = doctorRepository.findByUsernameAndPassword(i.getUsername(), i.getPassword());
        if (doctor != null) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
    @GetMapping("/profile/{id}")
    public  ResponseEntity<?> getProfile(@PathVariable int id) {
        return doctorRepository.findById(id).map(ResponseEntity::ok).orElseThrow();
    }

    @GetMapping("/appointments/{username}")
    public ResponseEntity<?> getAppointments(@PathVariable String username) {
        List<DoctorAppointment> appointments = appointmentRepository.findByDoctorUsername(username);
        return ResponseEntity.ok(appointments);
    }
}
