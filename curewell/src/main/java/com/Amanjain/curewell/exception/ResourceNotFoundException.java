package com.Amanjain.curewell.exception;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ResourceNotFoundException extends RuntimeException{
private String resourcename;
private String feildname;
private Long feildvalue;
private String feildvalue2;
private LocalTime start;
private LocalTime end;
    public ResourceNotFoundException(String resourcename, String feildname, Long feildvalue) {
        super(String.format("%s not found with %s : %s",resourcename,feildname,feildvalue));
        this.resourcename = resourcename;
        this.feildname = feildname;
        this.feildvalue = feildvalue;
    }

    public ResourceNotFoundException(String resourcename, String feildname, String feildvalue2) {
        super(String.format("%s not found with %s : %s",resourcename,feildname,feildvalue2));

        this.resourcename = resourcename;
        this.feildname = feildname;
        this.feildvalue2 = feildvalue2;
    }

    public ResourceNotFoundException(String resourcename, String feildname, String feildvalue2,Long feildvalue) {
        super(String.format("%s: %s and %s: %s are not linked to each other",resourcename,feildname,feildvalue2,feildvalue));
        this.resourcename = resourcename;
        this.feildname = feildname;
        this.feildvalue = feildvalue;
        this.feildvalue2 = feildvalue2;
    }

    public ResourceNotFoundException(String resourcename, String feildname) {
        super(String.format("%s: %s already exists",resourcename,feildname));
        this.resourcename = resourcename;
        this.feildname = feildname;
    }

    public ResourceNotFoundException(String resourcename, LocalTime start, LocalTime end) {
        super(String.format("%s Already exists from %s to %s",resourcename,start,end));
        this.resourcename = resourcename;
        this.start = start;
        this.end = end;
    }
}
