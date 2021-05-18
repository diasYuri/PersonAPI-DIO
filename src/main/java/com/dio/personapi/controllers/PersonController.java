package com.dio.personapi.controllers;


import com.dio.personapi.dto.request.PersonDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PersonController {


    @PostMapping("/person")
    public PersonDTO create(@RequestBody @Valid PersonDTO person){
        return person;
    }

}
