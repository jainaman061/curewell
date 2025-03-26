package com.Amanjain.curewell.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(

        name="specialization"
)
public class Specialization {

    @Id
    @Column(length = 3,nullable = false,unique = true)
    @Size(min = 3,max = 3,message = "code should be of 3 letters only")
    private String code;

    @Column(length = 20,nullable = false,unique = true)
    @Size(min = 3,max = 20,message = "name should be of atleast 3 letters.")
    private String Name;



//    private Set<Surgery> surgeries= new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "specialization",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<DoctorSpecialization> doctorSpecializations = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "specialization",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private Set<Surgery> surgery=new HashSet<>();

    public Set<Surgery> getSurgery() {
        return surgery;
    }

    public void setSurgery(Set<Surgery> surgery) {
        this.surgery = surgery;
    }


//getters and setters


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code.toUpperCase();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Set<DoctorSpecialization> getDoctorSpecializations() {
        return doctorSpecializations;
    }

    public void setDoctorSpecializations(Set<DoctorSpecialization> doctorSpecializations) {
        this.doctorSpecializations = doctorSpecializations;
    }
}
