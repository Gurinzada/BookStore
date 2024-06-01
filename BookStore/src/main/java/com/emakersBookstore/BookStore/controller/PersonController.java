package com.emakersBookstore.BookStore.controller;


import com.emakersBookstore.BookStore.dto.request.PersonRequestDTO;
import com.emakersBookstore.BookStore.dto.response.PersonResponseDTO;
import com.emakersBookstore.BookStore.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<PersonResponseDTO>> findAllPersons() {
        return ResponseEntity.status(HttpStatus.OK).body(personService.getAllPersons());
    }

    @GetMapping(value = "/{idPerson}")
    public ResponseEntity<PersonResponseDTO> findPersonById(@PathVariable Integer idPerson) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.getById(idPerson));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<PersonResponseDTO> createPerson(@RequestBody @Valid PersonRequestDTO personRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(personRequestDTO));
    }

    @PutMapping("/update/{idPerson}")
    public ResponseEntity<PersonResponseDTO> updatePerson(@PathVariable Integer idPerson, @RequestBody PersonRequestDTO personRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.updatePerson(idPerson, personRequestDTO));
    }

    @DeleteMapping("/delete/{idPerson}")
    public ResponseEntity<String> deletePerson(@PathVariable Integer idPerson) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.deletePerson(idPerson));
    }
}
