package com.Amanjain.curewell;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
public class CurewellApplication {

	public static void main(String[] args) {
		System.out.println(LocalDate.now());
		SpringApplication.run(CurewellApplication.class, args);


	}

}
