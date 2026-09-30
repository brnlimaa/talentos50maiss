package br.com.talentos50mais.dto;

import java.time.LocalDateTime;

public record AnuncioResponse(
        Long id,
        String titulo,
        String descricao,
        String municipio,
        boolean ativo,
        LocalDateTime criadoEm,
        Long categoriaId,
        String categoriaNome
) {}