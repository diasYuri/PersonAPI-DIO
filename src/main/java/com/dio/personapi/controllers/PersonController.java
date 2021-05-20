package com.dio.personapi.controllers;


import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.exceptions.AlreadyExistsException;
import com.dio.personapi.exceptions.NoExistsException;
import com.dio.personapi.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService personService;

    @PostMapping("/person")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody @Valid PersonDTO person) throws Exception, AlreadyExistsException {
        return personService.save(person);
    }

    @GetMapping("/")
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO listById(@PathVariable Long id) throws NoExistsException {
        return personService.listById(id);
    }


}
