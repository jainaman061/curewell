package com.Amanjain.curewell.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(
        name = "doctor_specialization"
)
public class DoctorSpecialization {

    @EmbeddedId
    private  DoctorSpecializationId id;



    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("doctorId")
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonIgnore
    private Doctor doctor ;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("specializationCode")
    @JoinColumn(name = "specialization_code", nullable = false)
    @JsonIgnore
    private Specialization specialization;

    private LocalDate localDate ;

    public DoctorSpecializationId getId() {
        return id;
    }

    public void setId(DoctorSpecializationId id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
