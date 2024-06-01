package com.emakersBookstore.BookStore.dto.response;

import com.emakersBookstore.BookStore.data.entity.Person;

public record PersonResponseDTO(
        Integer idPerson,
        String name,
        String cep
) {
    public PersonResponseDTO(Person person){
        this(person.getIdPerson(), person.getName(), person.getCep());
    }
}
