package com.Amanjain.curewell.controller;


import com.Amanjain.curewell.entity.Doctor;
import com.Amanjain.curewell.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/doctor")
@RestController
public class DoctorController {
    @Autowired
    DoctorService  doctorService;

    @GetMapping
public ResponseEntity<List<Doctor>> getAllDoctors(){
var data = doctorService.getALlDoctor();
return new ResponseEntity<>(data, HttpStatus.OK);}

    @PostMapping
    public ResponseEntity<Doctor> AddDoctor(@RequestBody Doctor doctor){
        var data=doctorService.AddDoctor(doctor);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> UpdateDoctor(@PathVariable("id") Long id,@RequestBody Doctor doctor){
        var data = doctorService.UpdateDoctor(id,doctor);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable("id") Long id){
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
