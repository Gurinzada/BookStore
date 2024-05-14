package com.emakersBookstore.BookStore.repository;

import com.emakersBookstore.BookStore.data.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
