package com.emakersBookstore.BookStore.controller;

import com.emakersBookstore.BookStore.dto.request.BookRequestDTO;
import com.emakersBookstore.BookStore.dto.response.BookResponseDTO;
import com.emakersBookstore.BookStore.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Book", description = "Endpoints relacionados à ao esquema de 'Book' ")
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Operation(summary = "Recupera todos os livros.",
            description = "Aciona a recuperação de todos os livros cadastrados.",
            tags = {"GET"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = BookResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @GetMapping(value = "/all")
    public ResponseEntity<List<BookResponseDTO>> getAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @Operation(summary = "Recupera um livro pelo ID.",
            description = "Aciona a recuperação de um livro pelo seu ID.",
            tags = {"GET"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = BookResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @GetMapping(value = "/{idBook}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Integer idBook){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(idBook));
    }

    @Operation(summary = "Envia um novo livro cadastrado ao sistema.",
            description = "Aciona o envio de um novo livro para o nosso BD.",
            tags = {"POST"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = BookRequestDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @PostMapping(value = "/create")
    public ResponseEntity<BookResponseDTO> createBook(@RequestBody BookRequestDTO bookRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(bookRequestDTO));
    }

    @Operation(summary = "Envia uma ataulização de um livro cadastrado.",
            description = "Aciona uma atualização por ID para trocar/corrigir informações de um livro.",
            tags = {"PUT"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = BookRequestDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @PutMapping(value = "/update/{idBook}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Integer idBook, @RequestBody BookRequestDTO bookRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(idBook, bookRequestDTO));
    }

    @Operation(summary = "Deleta um novo livro pelo ID.",
            description = "Aciona a remoção de um livro pelo ID passado.",
            tags = {"DELETE"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = BookResponseDTO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
            }
    )
    @DeleteMapping(value = "/delete/{idBook}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer idBook){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.deleteBook(idBook));
    }
}
