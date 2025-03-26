package com.Amanjain.curewell.controller;

import com.Amanjain.curewell.entity.Specialization;
import com.Amanjain.curewell.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/specialization")
@RestController
public class SpecializationController {
@Autowired
    SpecializationService specializationService;
    @GetMapping
    public ResponseEntity<List<Specialization>> getAllSpecialization(){
        var data = specializationService.getAllSpecialization();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Specialization> addSpecialization(@RequestBody Specialization specialization){
        var data = specializationService.AddSpecialization(specialization);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @PutMapping("/{code}")
    public ResponseEntity<Specialization> updateSpecialization(@PathVariable("code") String code,@RequestBody Specialization specialization){
        var data = specializationService.updateSpecialization(code,specialization);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteSpz(@PathVariable("id") String code){
        specializationService.deleteSpecialization(code.toUpperCase());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
