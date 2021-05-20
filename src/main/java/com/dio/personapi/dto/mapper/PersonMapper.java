package com.dio.personapi.dto.mapper;


import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.entities.Person;
import com.sun.el.stream.Stream;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class PersonMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public Person toModel(PersonDTO dto){

        Person p = modelMapper.map(dto, Person.class);
        p.setBirthDate(convertDate(dto.getBirthDate()));

        return p;
    }

    public PersonDTO toDto(Person person){

        PersonDTO dto = modelMapper.map(person, PersonDTO.class);

        return dto;
    }

    private LocalDate convertDate(String date){
        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateConverted = LocalDate.parse(date, form);

        return dateConverted;
    }
}