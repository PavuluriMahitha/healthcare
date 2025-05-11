package com.klef.fsad.backend.controller;

import com.klef.fsad.backend.model.*;
import com.klef.fsad.backend.repository.*;
import com.klef.fsad.backend.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin("*")
public class PatientController {

    @Autowired private PatientRepository pr;
    @Autowired private AppointmentRepository ar;
    @Autowired private PatientService ps;

    @PostMapping("/registration")
    public ResponseEntity<String> register(@RequestBody Patient patient) {
        pr.save(patient);
        return ResponseEntity.ok("Patient registered successfully");
    }

    @PostMapping("/checkpatientlogin")
    public ResponseEntity<?> checkPatientLogin(@RequestBody Patient input) {
        Patient patient = ps.checkPatientLogin(input.getUsername(), input.getPassword());
        if (patient != null) {
            return ResponseEntity.ok(patient);  // Send patient object (including id)
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
    @GetMapping("/profile/{pid}")
    public ResponseEntity<?> getProfile(@PathVariable int pid) {
        return pr.findById(pid).map(ResponseEntity::ok).orElseThrow();
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<List<Appointment>> getAppointments(@PathVariable int id) {
        List<Appointment> appointments = ar.findByPatientId(id);
        return ResponseEntity.ok(appointments);
    }

    @PostMapping("/appointments")
    public ResponseEntity<?> requestAppointment(@RequestBody Appointment appointment) {
        ar.save(appointment);
        return ResponseEntity.ok("Appointment request sent!");
    }
}
