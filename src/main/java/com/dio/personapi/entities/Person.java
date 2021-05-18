package com.dio.personapi.entities;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
public class Person {

    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String cpf;

    private List<Phone> phones = new ArrayList<>();
}
