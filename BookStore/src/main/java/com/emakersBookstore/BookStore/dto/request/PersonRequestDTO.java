package com.emakersBookstore.BookStore.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PersonRequestDTO(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "CEP is required")
        String cep
) {
}
