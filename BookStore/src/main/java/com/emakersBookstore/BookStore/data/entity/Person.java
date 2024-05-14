package com.emakersBookstore.BookStore.data.entity;


import com.emakersBookstore.BookStore.dto.request.PersonRequestDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPerson;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "cep", nullable = false, length = 9)
    private String cep;

    @Builder
    public Person(PersonRequestDTO personRequestDTO){
        this.name = personRequestDTO.name();
        this.cep = personRequestDTO.cep();
    }
}
