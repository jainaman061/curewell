package com.Amanjain.curewell.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name="Doctors"
)
public class Doctor {
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
            generator = "doctorid_sequence"
    )
    @SequenceGenerator(
            name="doctorid_sequence",
            sequenceName = "doctorid_sequence",
            initialValue = 1001,
            allocationSize = 1
    )
    private Long id;
    @Column(length = 25,nullable = false)
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<DoctorSpecialization> doctorSpecializations = new HashSet<>();
//    private Set<Surgery> surgeries=new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Surgery> surgeries = new HashSet<>();


//    private Set<DoctorSpecialization> doctorSpecializations=new HashSet<>();


}
