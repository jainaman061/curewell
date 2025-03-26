package com.Amanjain.curewell.service.impl;

import com.Amanjain.curewell.entity.Doctor;
import com.Amanjain.curewell.entity.DoctorSpecialization;
import com.Amanjain.curewell.entity.Specialization;
import com.Amanjain.curewell.entity.Surgery;
import com.Amanjain.curewell.exception.ResourceNotFoundException;
import com.Amanjain.curewell.repository.DoctorRepository;
import com.Amanjain.curewell.repository.DoctorSpecializationRepository;
import com.Amanjain.curewell.repository.SpecializationRespository;
import com.Amanjain.curewell.repository.SurgeryRepository;
import com.Amanjain.curewell.service.DoctorService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorServiceimpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
@Autowired
    SurgeryRepository surgeryRepository;
@Autowired
    DoctorSpecializationRepository doctorSpecializationRepository;
@Autowired
    SpecializationRespository specializationRespository;
    @Override
    public List<Doctor> getALlDoctor() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor AddDoctor(Doctor doctor) {

        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor UpdateDoctor(Long id, Doctor doctor) {
        Doctor doctor1=doctorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Doctor","DoctorId",id));
        doctor1.setName(doctor.getName()) ;
        return doctorRepository.save(doctor1);
    }

    @Override
    public void deleteDoctor(Long id) {
        Doctor doctor=doctorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Doctor","DoctorId",id));
        List<Surgery> surgery=surgeryRepository.findByDoctorId(id);
        for (int i=0;i<surgery.size();i++){
            Surgery surgery1=surgery.get(i);
            surgeryRepository.delete(surgery1);
        }
        List<DoctorSpecialization> doctorSpecializations=doctorSpecializationRepository.findByDoctorId(id);
        for (int i=0;i<doctorSpecializations.size();i++){

            DoctorSpecialization doctorSpecialization=doctorSpecializations.get(i);
//                    .orElseThrow(()->new RuntimeException("this specizlization is not of  doctor"));
            doctorSpecializationRepository.delete(doctorSpecialization);

        }
        doctorRepository.delete(doctor);
    }
}
