package com.emakersBookstore.BookStore.controller;


import com.emakersBookstore.BookStore.dto.request.BookRequestDTO;
import com.emakersBookstore.BookStore.dto.request.PersonRequestDTO;
import com.emakersBookstore.BookStore.dto.response.BookResponseDTO;
import com.emakersBookstore.BookStore.dto.response.PersonResponseDTO;
import com.emakersBookstore.BookStore.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Person", description = "Endpoints relacionados à ao esquema de 'Person' ")
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Operation(summary = "Recupera uma lista de usuários .",
            description = "Aciona a recuperação de todos os usuários.",
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
    public ResponseEntity<List<PersonResponseDTO>> findAllPersons() {
        return ResponseEntity.status(HttpStatus.OK).body(personService.getAllPersons());
    }

    @Operation(summary = "Recupera o usuário  pelo ID.",
            description = "Aciona a recuperação de um usuário pelo ID passado.",
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
    @GetMapping(value = "/{idPerson}")
    public ResponseEntity<PersonResponseDTO> findPersonById(@PathVariable Integer idPerson) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.getById(idPerson));
    }

    @Operation(summary = "Envia um novo usuário  cadastrado ao sistema.",
            description = "Aciona o envio de um novo usuário para o nosso BD.",
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
    public ResponseEntity<PersonResponseDTO> createPerson(@RequestBody @Valid PersonRequestDTO personRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(personRequestDTO));
    }

    @Operation(summary = "Envia uma ataulização do usuário  cadastrado ao sistema.",
            description = "Aciona a atualização/edição de um usuário pelo ID.",
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
    @PutMapping("/update/{idPerson}")
    public ResponseEntity<PersonResponseDTO> updatePerson(@PathVariable Integer idPerson, @RequestBody PersonRequestDTO personRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.updatePerson(idPerson, personRequestDTO));
    }

    @Operation(summary = "Deleta/Remove um usuário pelo ID.",
            description = "Aciona a remoção de um usuário pelo ID passado.",
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
    @DeleteMapping("/delete/{idPerson}")
    public ResponseEntity<String> deletePerson(@PathVariable Integer idPerson) {
        return ResponseEntity.status(HttpStatus.OK).body(personService.deletePerson(idPerson));
    }
}
