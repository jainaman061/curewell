package com.Amanjain.curewell.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DoctorSpecializationId implements Serializable{
    @Column(nullable = false)
    private Long doctorId;

    @Column(length = 3,nullable = false)
    private String specializationCode;

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
    public String getSpecializationCode() {
        return specializationCode;
    }

    public void setSpecializationCode(String specializationCode) {
        this.specializationCode = specializationCode;
    }

    public DoctorSpecializationId(Long doctorId, String specializationCode) {
        this.doctorId = doctorId;
        this.specializationCode = specializationCode;
    }

    public DoctorSpecializationId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorSpecializationId that = (DoctorSpecializationId) o;
        return Objects.equals(doctorId, that.doctorId) &&
                Objects.equals(specializationCode, that.specializationCode); // ✅ Updated field name
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId, specializationCode); // ✅ Updated field name
    }

}
