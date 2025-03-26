package com.Amanjain.curewell.service;

import com.Amanjain.curewell.entity.Doctor;

import javax.print.Doc;
import java.util.List;

public interface DoctorService {
    List<Doctor>  getALlDoctor();
    Doctor AddDoctor(Doctor doctor);
    Doctor UpdateDoctor(Long id,Doctor doctor);
void deleteDoctor(Long id);
}
