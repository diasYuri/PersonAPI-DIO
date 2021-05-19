package com.dio.personapi.controllers;


import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;


    @PostMapping("/person")
    public PersonDTO create(@RequestBody @Valid PersonDTO person){
        personRepository.save();
        return person;
    }

}
