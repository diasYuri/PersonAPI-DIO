package com.dio.personapi.dto.mapper;


import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.entities.Person;
import com.sun.el.stream.Stream;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonMapper {


    private ModelMapper modelMapper = new ModelMapper();

    public Person toModel(PersonDTO dto){

        Person p = modelMapper.map(dto, Person.class);
        p.setBirthDate(convertDate(dto.getBirthDate()));

        return p;
    }

    private LocalDate convertDate(String date){
        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateConverted = LocalDate.parse(date, form);

        return dateConverted;
    }
}