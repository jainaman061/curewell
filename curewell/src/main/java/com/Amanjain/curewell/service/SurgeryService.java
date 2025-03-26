package com.Amanjain.curewell.service;

import com.Amanjain.curewell.payload.SurgeryDto;
import com.Amanjain.curewell.entity.Surgery;

import java.util.List;

public interface SurgeryService {
    List<Surgery> getAllSurgeryoftoday();
    List<Surgery> findBysurgeryoftodayAndspecializationcode(String SpecializationCode);
    Surgery addSurgery(SurgeryDto surgeryDto);
    Surgery updateSurgery(Long id,Surgery surgery);
    void deleteSurgery(Long id);
    List<Surgery> AllSurgery();
}
