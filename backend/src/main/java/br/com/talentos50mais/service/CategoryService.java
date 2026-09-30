package br.com.talentos50mais.service;

import br.com.talentos50mais.dto.CategoryResponse;
import br.com.talentos50mais.repository.CategoryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public List<CategoryResponse> listar() {
        return categoryRepository.findAll(Sort.by("nome"))
                .stream()
                .map(categoria -> new CategoryResponse(
                        categoria.getId(),
                        categoria.getNome(),
                        categoria.getDescricao()))
                .toList();
    }
}