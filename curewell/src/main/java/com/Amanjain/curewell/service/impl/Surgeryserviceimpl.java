package com.Amanjain.curewell.service.impl;

import com.Amanjain.curewell.payload.SurgeryDto;
import com.Amanjain.curewell.entity.*;
import com.Amanjain.curewell.exception.ResourceNotFoundException;
import com.Amanjain.curewell.repository.DoctorRepository;
import com.Amanjain.curewell.repository.DoctorSpecializationRepository;
import com.Amanjain.curewell.repository.SpecializationRespository;
import com.Amanjain.curewell.repository.SurgeryRepository;
import com.Amanjain.curewell.service.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Service
public class Surgeryserviceimpl implements SurgeryService {

    @Autowired
    private SurgeryRepository surgeryRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private DoctorSpecializationRepository doctorSpecializationRepository;

    @Autowired
    private SpecializationRespository specializationRespository;
    @Override
    public List<Surgery> getAllSurgeryoftoday() {
        LocalDate localDate=LocalDate.now();

        return surgeryRepository.findBySurgeryDate(localDate);
    }

    @Override
    public List<Surgery> findBysurgeryoftodayAndspecializationcode(String specializationCode) {
        LocalDate date = LocalDate.now();
        List<Surgery> surgery = surgeryRepository.findBySurgeryDateAndSpecializationCode(date,specializationCode);

        return surgery ;
    }
    @Override
    public List<Surgery> AllSurgery(){
        return surgeryRepository.findAll();
    }

    @Override
    public Surgery addSurgery(SurgeryDto surgeryDto) {
        if (surgeryDto.getDoctorId() == null) {
            throw new IllegalArgumentException("Doctor ID cannot be null");
        }

        long doctorid=surgeryDto.getDoctorId();
        String spzcode=surgeryDto.getSurgeryCode().toUpperCase();
        Doctor doctor=doctorRepository.findById(doctorid)
                .orElseThrow(()-> new ResourceNotFoundException("Doctor","DoctorId",doctorid));
        Specialization specialization=specializationRespository.findById(spzcode)
                .orElseThrow(() -> new ResourceNotFoundException("Specialization ","SpecializationCode" , spzcode));
        DoctorSpecializationId doctorSpecializationId=new DoctorSpecializationId(surgeryDto.getDoctorId(),surgeryDto.getSurgeryCode());
        DoctorSpecialization doctorSpecialization=doctorSpecializationRepository.findById(doctorSpecializationId)
                .orElseThrow(()->new ResourceNotFoundException("Specialization",spzcode,"doctor",doctorid));

        List<Surgery> surgeries=surgeryRepository.findOverlapSurgery(surgeryDto.getSurgerydate(), LocalTime.parse(surgeryDto.getStarttime()),LocalTime.parse(surgeryDto.getEndtime()));
        if (!surgeries.isEmpty()) {
            throw new ResourceNotFoundException("Surgery",LocalTime.parse(surgeryDto.getStarttime()),LocalTime.parse(surgeryDto.getEndtime()));
        }
        Surgery surgery=new Surgery();
        surgery.setDoctor(doctor);
        surgery.setSpecialization(specialization);
        surgery.setStartTime(surgeryDto.getStarttime());
        surgery.setEndTime(surgeryDto.getEndtime());
        surgery.setSurgeryDate(surgeryDto.getSurgerydate());

        return surgeryRepository.save(surgery);
    }

    @Override
    public Surgery updateSurgery(Long id,Surgery surgery) {
        Surgery surgery1=surgeryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Surgery","SurgeryId",id));
        surgery1.setStartTime(surgery.getStartTime());
        surgery1.setEndTime(surgery.getEndTime());

        return surgeryRepository.save(surgery1);
    }

    @Override
    public void deleteSurgery(Long id) {
        Surgery surgery1=surgeryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Surgery","SurgeryId",id));

        surgeryRepository.delete(surgery1);

    }
}
