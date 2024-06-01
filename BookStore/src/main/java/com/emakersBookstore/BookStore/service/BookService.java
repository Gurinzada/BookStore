package com.emakersBookstore.BookStore.service;

import com.emakersBookstore.BookStore.data.entity.Book;
import com.emakersBookstore.BookStore.dto.request.BookRequestDTO;
import com.emakersBookstore.BookStore.dto.response.BookResponseDTO;
import com.emakersBookstore.BookStore.exception.NotFindError;
import com.emakersBookstore.BookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookResponseDTO> getAllBooks(){
        List<Book> books = bookRepository.findAll();
        return books.stream().map(BookResponseDTO::new).collect(Collectors.toList());
    }

    public BookResponseDTO getBookById(Integer idBook){
        Book book = bookRepository.findById(idBook).orElseThrow(() -> new NotFindError(idBook));

        return new BookResponseDTO(book);
    }

    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO){
        Book book = new Book(bookRequestDTO);
        bookRepository.save(book);

        return new BookResponseDTO(book);
    }

    public BookResponseDTO updateBook(Integer idBook, BookRequestDTO bookRequestDTO){
        Book book = bookRepository.findById(idBook).orElseThrow(() -> new NotFindError(idBook));

        book.setName(bookRequestDTO.name());
        book.setAuthor(bookRequestDTO.author());
        book.setLocalDate(bookRequestDTO.localDate());
        bookRepository.save(book);

        return new BookResponseDTO(book);
    }

    public String deleteBook(Integer idBook){
        Book book = bookRepository.findById(idBook).orElseThrow(()-> new NotFindError(idBook));

        bookRepository.delete(book);
        return "Livro " + book.getName() + " deletado com sucesso!";
    }
}
