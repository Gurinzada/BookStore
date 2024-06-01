package com.emakersBookstore.BookStore.dto.response;

import com.emakersBookstore.BookStore.data.entity.Book;

import java.time.LocalDate;

public record BookResponseDTO(
        Integer idBook,
        String name,
        String author,
        LocalDate localDate
) {
    public BookResponseDTO(Book book){
        this(book.getIdBook(), book.getName(), book.getAuthor(), book.getLocalDate());
    }
}
