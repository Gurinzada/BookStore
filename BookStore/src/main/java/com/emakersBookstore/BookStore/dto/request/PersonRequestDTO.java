package com.emakersBookstore.BookStore.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record PersonRequestDTO(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "CEP is required")
        @Pattern(regexp = "^[0-9]{5}-[0-9]{3}$", message = "Model of CEP: XXXXX-XXX")
        String cep
) {
}
