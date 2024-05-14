package com.emakersBookstore.BookStore.data.entity;

import com.emakersBookstore.BookStore.dto.request.BookRequestDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBook;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "author", nullable = false, length = 45)
    private String author;

    @Column(name = "launchDay", nullable = false)
    private LocalDate localDate;

    @Builder
    public Book(BookRequestDTO bookRequestDTO){
        this.name = bookRequestDTO.name();
        this.author = bookRequestDTO.author();
        this.localDate = bookRequestDTO.localDate();
    }
}
