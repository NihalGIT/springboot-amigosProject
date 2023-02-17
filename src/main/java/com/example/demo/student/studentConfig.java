package com.example.demo.student;

import java.time.*;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class studentConfig {

    @Bean
    CommandLineRunner commandLineRunner(studentrepository repository) {
        return args -> {
            student james = new student(
                    "James Bond",
                    LocalDate.of(2000, Month.JUNE, 5),
                    "James@emailcom");
            student alex = new student(
                    "Alex",
                    LocalDate.of(2020, Month.JULY, 30),
                    "alex@email.com");
            repository.saveAll(
                    List.of(james, alex));

        };

    }
}
