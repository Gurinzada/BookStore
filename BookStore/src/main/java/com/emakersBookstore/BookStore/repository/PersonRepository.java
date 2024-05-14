package com.emakersBookstore.BookStore.repository;

import com.emakersBookstore.BookStore.data.entity.Person;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
