package com.emakersBookstore.BookStore.service;

import com.emakersBookstore.BookStore.data.entity.Loan;
import com.emakersBookstore.BookStore.dto.request.LoanRequestDTO;
import com.emakersBookstore.BookStore.dto.response.LoanResponseDTO;
import com.emakersBookstore.BookStore.exception.NotFindError;
import com.emakersBookstore.BookStore.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    public List<LoanResponseDTO> getAllLoans(){
        List<Loan> loans = loanRepository.findAll();

        return loans.stream().map(LoanResponseDTO::new).collect(Collectors.toList());
    }

    public LoanResponseDTO getLoanById(Integer idLoan){
        Loan loan = loanRepository.findById(idLoan).orElseThrow(() -> new NotFindError(idLoan));

        return new LoanResponseDTO(loan);
    }

    public LoanResponseDTO createLoan(LoanRequestDTO loanResquestDTO){
        Loan loan = new Loan(loanResquestDTO);

        loanRepository.save(loan);

        return new LoanResponseDTO(loan);
    }

    public LoanResponseDTO updateLoan(Integer idLoan, LoanRequestDTO loanRequestDTO){
        Loan loan = loanRepository.findById(idLoan).orElseThrow(() -> new NotFindError(idLoan));

        loan.setPerson(loanRequestDTO.person());
        loan.setBook(loanRequestDTO.book());
        loanRepository.save(loan);

        return new LoanResponseDTO(loan);
    }

    public String deleteLoan(Integer idLoan){
        Loan loan = loanRepository.findById(idLoan).orElseThrow(() -> new NotFindError(idLoan));

        loanRepository.delete(loan);
        return "Emprestimo excluido!";
    }
}
