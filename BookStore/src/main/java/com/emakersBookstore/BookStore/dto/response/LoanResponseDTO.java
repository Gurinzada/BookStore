package com.emakersBookstore.BookStore.dto.response;

import com.emakersBookstore.BookStore.data.entity.Loan;

public record LoanResponseDTO(
        Integer idLoan,
        BookResponseDTO bookResponseDTO,
        PersonResponseDTO personResponseDTO
) {
    public LoanResponseDTO(Loan loan){
        this(loan.getIdLoan(), new BookResponseDTO(loan.getBook()), new PersonResponseDTO(loan.getPerson()));
    }
}
