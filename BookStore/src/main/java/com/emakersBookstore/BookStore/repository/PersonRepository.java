package com.emakersBookstore.BookStore.repository;

import com.emakersBookstore.BookStore.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
