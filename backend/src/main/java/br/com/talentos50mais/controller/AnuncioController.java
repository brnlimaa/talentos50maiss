package br.com.talentos50mais.controller;

import br.com.talentos50mais.dto.AnuncioRequest;
import br.com.talentos50mais.dto.AnuncioResponse;
import br.com.talentos50mais.service.AnuncioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anuncios")
public class AnuncioController {

    private final AnuncioService anuncioService;

    public AnuncioController(AnuncioService anuncioService) {
        this.anuncioService = anuncioService;
    }

    @GetMapping
    public List<AnuncioResponse> listar() {
        return anuncioService.listar();
    }

    @PostMapping
    public AnuncioResponse criar(@Valid @RequestBody AnuncioRequest request) {
        return anuncioService.criar(request);
    }
}