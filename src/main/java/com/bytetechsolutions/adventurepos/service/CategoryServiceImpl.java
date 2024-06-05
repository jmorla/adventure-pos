package com.bytetechsolutions.adventurepos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bytetechsolutions.adventurepos.domain.CategoryRecord;
import com.bytetechsolutions.adventurepos.domain.CategoryUpdateForm;
import com.bytetechsolutions.adventurepos.exception.AdventureException;
import com.bytetechsolutions.adventurepos.mappers.CategoryMapper;
import com.bytetechsolutions.adventurepos.repositories.CategoryRepository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public void updateCategory(CategoryUpdateForm request) {
        var categoryToUpdate = categoryRepository.findById(request.id())
                .orElseThrow(() -> new AdventureException("Categoria no encontrada",
                        "La entidad solicitada %s no fue encontrada".formatted(request.name())));

        var category = categoryRepository.findByNameIgnoreCase(request.name());
        if (category.isPresent() && (category.get().getId() != request.id())) {
            throw new AdventureException("Error al actualizar",
                    "Ya existe una categoria con el mismo nombre");
        }

        categoryMapper.merge(categoryToUpdate, request);
        try {
            categoryRepository.save(categoryToUpdate);
        } catch (DataAccessException ex) {
            log.trace("An error ocurred while updating category", ex);
            throw new AdventureException();
        }
    }

    @Override
    public List<CategoryRecord> findCategories() {
        var categories = categoryRepository.findAll(
                Sort.by("id").ascending())
                .stream().map(categoryMapper::mapToCategoryRecord).toList();
        return categories;
    }

    @Override
    public void deleteCategory(Integer id) {
        try {
            categoryRepository.findById(id).ifPresent(category -> {
                var products = category.getProducts();
                products.stream().forEach(product -> {
                    product.setCategory(null);
                });
                categoryRepository.deleteById(id);
            });

        } catch (DataAccessException ex) {
            log.trace("An error ocurred while deleting category", ex);
            throw new AdventureException();
        }
    }

    @Override
    public Optional<CategoryRecord> findById(Integer id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::mapToCategoryRecord);
    }

}
