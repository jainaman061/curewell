package com.Amanjain.curewell.payload;

public class DoctorSpecializationDto {
    private Long doctorId;
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
        this.specializationCode = specializationCode.toUpperCase();
    }
}
