package com.emakersBookstore.BookStore.dto.request;

import com.emakersBookstore.BookStore.data.entity.Book;
import com.emakersBookstore.BookStore.data.entity.Person;
import jakarta.validation.constraints.NotNull;

public record LoanRequestDTO(
        @NotNull(message = "Book is necessary")
        Book book,

        @NotNull(message = "Person is necessary")
        Person person
) {
}
