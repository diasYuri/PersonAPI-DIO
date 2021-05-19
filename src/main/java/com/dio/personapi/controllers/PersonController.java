package com.dio.personapi.controllers;


import com.dio.personapi.dto.mapper.PersonMapper;
import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.entities.Person;
import com.dio.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {


    private final PersonRepository personRepository;

    @PostMapping("/person")
    public Person create(@RequestBody @Valid PersonDTO person){
        PersonMapper mapper = new PersonMapper();
        Person res = personRepository.save(mapper.toModel(person));
        return res;
    }

}
