package com.klef.fsad.backend.repository;

import com.klef.fsad.backend.model.DoctorAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DoctorAppointmentRepository extends JpaRepository<DoctorAppointment, Integer> {
    List<DoctorAppointment> findByDoctorUsername(String doctorUsername);
}
