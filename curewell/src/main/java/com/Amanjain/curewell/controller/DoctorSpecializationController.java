package com.Amanjain.curewell.controller;

import com.Amanjain.curewell.payload.DoctorSpecializationDto;
import com.Amanjain.curewell.entity.DoctorSpecialization;
import com.Amanjain.curewell.service.DoctorSpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/doctorSpecialization")
@RestController
public class DoctorSpecializationController {
    @Autowired
    DoctorSpecializationService docterSpecializationServiceimpl;
    @GetMapping
    public ResponseEntity<List<DoctorSpecialization>>getallSpecializationwithDoc(){
        var data = docterSpecializationServiceimpl.getAllSpecializationwithDoc();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<DoctorSpecialization>addDoctorSpz(@RequestBody DoctorSpecializationDto doctorSpecialization){
        System.out.println("Recived Dto" + doctorSpecialization);
        var data = docterSpecializationServiceimpl.addDoctorSpecialization(doctorSpecialization);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
    @DeleteMapping("/{id}/{code}")
    public ResponseEntity<Void> Deletedoctorspxz(@PathVariable("id") Long id,@PathVariable("code") String code){
        docterSpecializationServiceimpl.DeleteByDoctorid(id,code);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
