package com.Amanjain.curewell.controller;


import com.Amanjain.curewell.payload.SurgeryDto;
import com.Amanjain.curewell.entity.Surgery;
import com.Amanjain.curewell.service.SurgeryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/surgery")
@RestController
public class SurgeryController {
    @Autowired
    SurgeryService surgeryService;


    @GetMapping("/all")
    public ResponseEntity<List<Surgery>> Allsurgery(){
        var data = surgeryService.AllSurgery();
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Surgery>> getAllSurgeryOfToday(){
        var data = surgeryService.getAllSurgeryoftoday();
        return  new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Surgery> AddSurgery(@RequestBody SurgeryDto surgeryDto){
        System.out.println(surgeryDto.getDoctorId());
        var data = surgeryService.addSurgery(surgeryDto);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
    @GetMapping("/{code}")
    public ResponseEntity<List<Surgery>> findBysurgeryDateAndspecializationcode(@PathVariable("code") String code){
        var data=surgeryService.findBysurgeryoftodayAndspecializationcode(code);
        return new ResponseEntity<>(data,HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Surgery> update(@PathVariable ("id") Long id,@RequestBody Surgery surgery){
        var data=surgeryService.updateSurgery(id,surgery);
        return  new ResponseEntity<>(data,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> dlelete(@PathVariable("id") Long id){
        surgeryService.deleteSurgery(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
