package com.dio.personapi.services;

import com.dio.personapi.dto.mapper.PersonMapper;
import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.entities.Person;
import com.dio.personapi.exceptions.AlreadyExistsException;
import com.dio.personapi.exceptions.NoExistsException;
import com.dio.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonRepository personRepository;
    PersonMapper mapper;


    public String save(PersonDTO dto) throws Exception {

        if(alreadyExist(dto)){
            throw new AlreadyExistsException();
        }

        Person newPerson = mapper.toModel(dto);

        personRepository.save(newPerson);

        return "Tudo certo";
    }

    public boolean alreadyExist(PersonDTO dto){
        Optional<Person> person = personRepository.findByCpf(dto.getCpf());

        if(person.isPresent()){
            return true;
        }
        return false;
    }

    public List<PersonDTO> listAll(){

        List<Person> persons = personRepository.findAll();
        return persons.stream()
                .map((person) -> mapper.toDto(person))
                .collect(Collectors.toList());
    }

    public PersonDTO listById(Long id) throws NoExistsException {
        Optional<Person> person = personRepository.findById(id);

        if(person.isEmpty()){
            throw new NoExistsException(id);
        }

        return mapper.toDto(person.get());
    }
}
