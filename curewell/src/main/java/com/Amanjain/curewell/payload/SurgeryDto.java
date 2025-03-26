package com.Amanjain.curewell.payload;

import java.time.LocalDate;

public class SurgeryDto {
    private LocalDate surgerydate;
    private String starttime;
    private String endtime;
    private Long doctorId;
    private String surgeryCode;

    public LocalDate getSurgerydate() {
        return surgerydate;
    }

    public void setSurgerydate(LocalDate surgerydate) {
        this.surgerydate = surgerydate;
    }


    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getSurgeryCode() {
        return surgeryCode;
    }

    public void setSurgeryCode(String surgeryCode) {
        this.surgeryCode = surgeryCode.toUpperCase();
    }
}
