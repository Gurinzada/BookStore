package com.emakersBookstore.BookStore.service;

import com.emakersBookstore.BookStore.data.entity.Person;
import com.emakersBookstore.BookStore.dto.request.PersonRequestDTO;
import com.emakersBookstore.BookStore.dto.response.PersonResponseDTO;
import com.emakersBookstore.BookStore.exception.NotFindError;
import com.emakersBookstore.BookStore.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<PersonResponseDTO> getAllPersons(){
        List<Person> person = personRepository.findAll();

        return person.stream().map(PersonResponseDTO::new).collect(Collectors.toList());
    }

    public PersonResponseDTO getById(Integer idPerson){
        Person person = personRepository.findById(idPerson).orElseThrow(() -> new NotFindError(idPerson));

        return new PersonResponseDTO(person);
    }

    public PersonResponseDTO createPerson(PersonRequestDTO personRequestDTO){
        Person person = new Person(personRequestDTO);

        personRepository.save(person);

        return new PersonResponseDTO(person);
    }

    public PersonResponseDTO updatePerson(Integer idPerson, PersonRequestDTO personRequestDTO){
        Person person = personRepository.findById(idPerson).orElseThrow(() -> new NotFindError(idPerson));

        person.setName(personRequestDTO.name());
        person.setCep(personRequestDTO.cep());
        personRepository.save(person);

        return new PersonResponseDTO(person);
    }

    public String deletePerson(Integer idPerson){
        Person person = personRepository.findById(idPerson).orElseThrow(() -> new NotFindError(idPerson));

        personRepository.delete(person);
        return "User " + person.getName() + " deletado com sucesso!";
    }
}
