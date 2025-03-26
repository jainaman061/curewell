package com.Amanjain.curewell.service;

import com.Amanjain.curewell.payload.DoctorSpecializationDto;
import com.Amanjain.curewell.entity.DoctorSpecialization;

import java.util.List;

public interface DoctorSpecializationService {
    List<DoctorSpecialization> getAllSpecializationwithDoc();
    DoctorSpecialization addDoctorSpecialization(DoctorSpecializationDto doctorSpecialization);
    void DeleteByDoctorid(Long id,String code);


}
