package br.com.talentos50mais.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record AnuncioRequest(
        @NotBlank @Size(max = 100) String titulo,
        @NotBlank @Size(max = 1000) String descricao,
        @NotBlank @Size(max = 100) String municipio,
        @NotNull @Positive Long categoriaId
) {
} 