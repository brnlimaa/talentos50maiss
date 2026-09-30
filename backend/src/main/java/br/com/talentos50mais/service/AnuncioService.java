package br.com.talentos50mais.service;

import br.com.talentos50mais.dto.AnuncioRequest;
import br.com.talentos50mais.dto.AnuncioResponse;
import br.com.talentos50mais.entity.Anuncio;
import br.com.talentos50mais.entity.Category;
import br.com.talentos50mais.repository.AnuncioRepository;
import br.com.talentos50mais.repository.CategoryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AnuncioService {

    private final AnuncioRepository anuncioRepository;
    private final CategoryRepository categoryRepository;

    public AnuncioService(
            AnuncioRepository anuncioRepository,
            CategoryRepository categoryRepository) {
        this.anuncioRepository = anuncioRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public List<AnuncioResponse> listar() {
        return anuncioRepository.findAll(Sort.by(Sort.Direction.DESC, "criadoEm"))
                .stream()
                .map(this::paraResponse)
                .toList();
    }

    @Transactional
    public AnuncioResponse criar(AnuncioRequest request) {
        Category categoria = categoryRepository.findById(request.categoriaId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Categoria não encontrada"));

        Anuncio anuncio = new Anuncio(
                request.titulo(),
                request.descricao(),
                request.municipio(),
                categoria
        );

        return paraResponse(anuncioRepository.save(anuncio));
    }

    private AnuncioResponse paraResponse(Anuncio anuncio) {
        return new AnuncioResponse(
                anuncio.getId(),
                anuncio.getTitulo(),
                anuncio.getDescricao(),
                anuncio.getMunicipio(),
                anuncio.isAtivo(),
                anuncio.getCriadoEm(),
                anuncio.getCategoria().getId(),
                anuncio.getCategoria().getNome()
        );
    }
}