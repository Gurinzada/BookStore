package com.emakersBookstore.BookStore.repository;

import com.emakersBookstore.BookStore.data.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
