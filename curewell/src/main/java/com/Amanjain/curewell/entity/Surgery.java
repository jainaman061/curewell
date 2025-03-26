package com.Amanjain.curewell.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "surgery")
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "surgeryid_sequence")
    @SequenceGenerator(name = "surgeryid_sequence", sequenceName = "surgeryid_sequence", initialValue = 5000, allocationSize = 1)
    private Long surgeryId;



    private LocalDate surgeryDate;

    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name="doctor_id", nullable = false)
    private Doctor doctor;

//    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "specializationcode",nullable = false)
    private Specialization specialization;

    public LocalDate getSurgeryDate() {
        return surgeryDate;
    }

    public void setSurgeryDate(LocalDate surgeryDate) {
        this.surgeryDate = surgeryDate;
    }

    public String getStartTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return startTime != null ? startTime.format(formatter) : null;
    }

    public void setStartTime(String startTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.startTime = LocalTime.parse(startTime, formatter);
    }

    public String getEndTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return endTime != null ? endTime.format(formatter) : null;
    }

    public void setEndTime(String endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.endTime = LocalTime.parse(endTime, formatter);
    }

}
