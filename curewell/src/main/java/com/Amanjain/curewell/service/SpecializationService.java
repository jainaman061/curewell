package com.Amanjain.curewell.service;

import com.Amanjain.curewell.entity.Specialization;

import java.util.List;

public interface SpecializationService {
    List<Specialization> getAllSpecialization();
    Specialization AddSpecialization(Specialization specialization);
    Specialization updateSpecialization(String code,Specialization specialization);
    void deleteSpecialization(String id);
}
