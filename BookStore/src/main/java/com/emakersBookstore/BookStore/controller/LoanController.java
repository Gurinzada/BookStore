package com.emakersBookstore.BookStore.controller;

import com.emakersBookstore.BookStore.dto.request.LoanRequestDTO;
import com.emakersBookstore.BookStore.dto.response.LoanResponseDTO;
import com.emakersBookstore.BookStore.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/loan")
@RestController
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/all")
    public ResponseEntity<List<LoanResponseDTO>> getAllLoans() {
        return ResponseEntity.status(HttpStatus.OK).body(loanService.getAllLoans());
    }

    @GetMapping("/{idLoan}")
    public ResponseEntity<LoanResponseDTO> getLoanById(@PathVariable int idLoan) {
        return ResponseEntity.status(HttpStatus.OK).body(loanService.getLoanById(idLoan));
    }

    @PostMapping("/create")
    public ResponseEntity<LoanResponseDTO> createLoan(@RequestBody LoanRequestDTO loanRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.createLoan(loanRequestDTO));
    }

    @PutMapping("/update/{idLoan}")
    public ResponseEntity<LoanResponseDTO> updateLoan(@PathVariable Integer idLoan, @RequestBody LoanRequestDTO loanRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.updateLoan(idLoan,loanRequestDTO));
    }

    @DeleteMapping("/delete/{idLoan}")
    public ResponseEntity<String> deleteLoan(@PathVariable Integer idLoan){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.deleteLoan(idLoan));
    }
}
