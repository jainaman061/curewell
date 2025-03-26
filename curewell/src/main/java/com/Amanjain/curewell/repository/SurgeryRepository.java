package com.Amanjain.curewell.repository;

import com.Amanjain.curewell.entity.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface SurgeryRepository extends JpaRepository<Surgery, Long> {

    List<Surgery> findBySurgeryDate(LocalDate surgeryDate);

    List<Surgery> findBySurgeryDateAndSpecializationCode(LocalDate surgeryDate, String specializationCode);

    @Query("SELECT s FROM Surgery s WHERE s.surgeryDate = :date AND (s.startTime < :endTime AND s.endTime > :startTime)")
    List<Surgery> findOverlapSurgery(
            @Param("date") LocalDate localDate,
            @Param("startTime") LocalTime startTime,
            @Param("endTime") LocalTime endTime
    );

    List<Surgery> findBySpecializationCode(String code);
    List<Surgery> findByDoctorId(Long id);

}
