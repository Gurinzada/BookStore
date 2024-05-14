package com.emakersBookstore.BookStore.data.entity;

import com.emakersBookstore.BookStore.dto.request.LoanRequestDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLoan;

    @ManyToOne
    @JoinColumn(name = "idBook", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "idPerson", nullable = false)
    private Person person;

    @Builder
    public Loan(LoanRequestDTO loanRequestDTO){
        this.book = loanRequestDTO.book();
        this.person = loanRequestDTO.person();
    }
}
