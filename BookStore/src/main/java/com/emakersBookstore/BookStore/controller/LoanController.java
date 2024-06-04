package com.emakersBookstore.BookStore.controller;

import com.emakersBookstore.BookStore.dto.request.BookRequestDTO;
import com.emakersBookstore.BookStore.dto.request.LoanRequestDTO;
import com.emakersBookstore.BookStore.dto.response.BookResponseDTO;
import com.emakersBookstore.BookStore.dto.response.LoanResponseDTO;
import com.emakersBookstore.BookStore.service.LoanService;
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

@Tag(name = "Loan", description = "Endpoints relacionados à ao esquema de 'Loan' ")
@RequestMapping("/loan")
@RestController
public class LoanController {

    @Autowired
    private LoanService loanService;

    @Operation(summary = "Recupera todos os emprestimos.",
            description = "Aciona a recuperação de todos os emprestimos cadastrados.",
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
    @GetMapping("/all")
    public ResponseEntity<List<LoanResponseDTO>> getAllLoans() {
        return ResponseEntity.status(HttpStatus.OK).body(loanService.getAllLoans());
    }

    @Operation(summary = "Recupera o emprestimo pelo ID.",
            description = "Aciona a recuperação de um emprestimo pelo ID.",
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
    @GetMapping("/{idLoan}")
    public ResponseEntity<LoanResponseDTO> getLoanById(@PathVariable int idLoan) {
        return ResponseEntity.status(HttpStatus.OK).body(loanService.getLoanById(idLoan));
    }

    @Operation(summary = "Envia um novo emprestimo realizado cadastrado ao sistema.",
            description = "Aciona o envio de um novo emprestimo para o nosso BD.",
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
    @PostMapping("/create")
    public ResponseEntity<LoanResponseDTO> createLoan(@RequestBody LoanRequestDTO loanRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.createLoan(loanRequestDTO));
    }

    @Operation(summary = "Atualiza o emprestimo pelo ID.",
            description = "Aciona a correção/edição de um emprestimo pelo ID passado.",
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
    @PutMapping("/update/{idLoan}")
    public ResponseEntity<LoanResponseDTO> updateLoan(@PathVariable Integer idLoan, @RequestBody LoanRequestDTO loanRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.updateLoan(idLoan,loanRequestDTO));
    }

    @Operation(summary = "Deleta/Devolve o emprestimo pelo ID.",
            description = "Aciona a devolução do emprestimo pelo ID.",
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
    @DeleteMapping("/delete/{idLoan}")
    public ResponseEntity<String> deleteLoan(@PathVariable Integer idLoan){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.deleteLoan(idLoan));
    }
}
