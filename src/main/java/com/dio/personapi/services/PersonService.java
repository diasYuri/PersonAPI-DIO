package com.dio.personapi.services;

import com.dio.personapi.dto.mapper.PersonMapper;
import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.entities.Person;
import com.dio.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonRepository personRepository;
    PersonMapper mapper;


    public String save(PersonDTO dto) throws Exception {

        Person newPerson = mapper.toModel(dto);

        personRepository.save(newPerson);

        return "Tudo certo";
    }
}
