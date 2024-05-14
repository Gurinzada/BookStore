package com.emakersBookstore.BookStore.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record BookRequestDTO(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Author is required")
        String author,

        @NotBlank(message = "Date is required")
        LocalDate localDate
) {
}
