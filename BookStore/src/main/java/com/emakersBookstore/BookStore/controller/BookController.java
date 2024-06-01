package com.emakersBookstore.BookStore.controller;

import com.emakersBookstore.BookStore.dto.request.BookRequestDTO;
import com.emakersBookstore.BookStore.dto.response.BookResponseDTO;
import com.emakersBookstore.BookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<BookResponseDTO>> getAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @GetMapping(value = "/{idBook}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Integer idBook){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(idBook));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<BookResponseDTO> createBook(@RequestBody BookRequestDTO bookRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(bookRequestDTO));
    }

    @PutMapping(value = "/update/{idBook}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Integer idBook, @RequestBody BookRequestDTO bookRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(idBook, bookRequestDTO));
    }

    @DeleteMapping(value = "/delete/{idBook}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer idBook){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.deleteBook(idBook));
    }
}
