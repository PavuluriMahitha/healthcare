package com.klef.fsad.backend.repository;

import com.klef.fsad.backend.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Patient findByUsernameAndPassword(String username, String password);
    Patient findByUsername(String username);
}


