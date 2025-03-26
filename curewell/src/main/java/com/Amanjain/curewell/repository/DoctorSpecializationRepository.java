package com.Amanjain.curewell.repository;

import com.Amanjain.curewell.entity.DoctorSpecialization;
import com.Amanjain.curewell.entity.DoctorSpecializationId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorSpecializationRepository extends JpaRepository<DoctorSpecialization, DoctorSpecializationId> {


    void deleteByDoctor_Id(Long doctorId);

    List<DoctorSpecialization> findByspecializationCode(String code);
    List<DoctorSpecialization> findByDoctorId(Long id);
}
