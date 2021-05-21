package com.dio.personapi.controllers;


import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.dto.response.MessageResponse;
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
@RequestMapping("/api/")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService personService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse create(@RequestBody @Valid PersonDTO person) throws Exception, AlreadyExistsException {
        return personService.save(person);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO listById(@PathVariable Long id) throws NoExistsException {
        return personService.listById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponse updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws NoExistsException {
        return personService.update(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponse deleteById(@PathVariable Long id) throws NoExistsException {
        return personService.delete(id);
    }

}
