package com.bytetechsolutions.adventurepos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bytetechsolutions.adventurepos.domain.CategoryRecord;
import com.bytetechsolutions.adventurepos.domain.CategoryRequest;
import com.bytetechsolutions.adventurepos.mappers.CategoryMapper;
import com.bytetechsolutions.adventurepos.repositories.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public void updateCategory(Integer id, CategoryRequest request) {
        var category = categoryMapper.map(request);
        category.setId(id);
        categoryRepository.save(category);
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
            System.out.println("Hello world");
        }
    }

    @Override
    public Optional<CategoryRecord> findById(Integer id) {
        return categoryRepository.findById(id)
            .map(categoryMapper::mapToCategoryRecord);
    }

}
