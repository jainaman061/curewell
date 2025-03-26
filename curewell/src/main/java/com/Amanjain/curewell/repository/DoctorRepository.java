package com.Amanjain.curewell.repository;

import com.Amanjain.curewell.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
