package com.bytetechsolutions.adventurepos.service;

import java.util.List;
import java.util.Optional;

import com.bytetechsolutions.adventurepos.domain.CategoryRecord;
import com.bytetechsolutions.adventurepos.domain.CategoryUpdateRequest;

public interface CategoryService {
    
    void updateCategory(CategoryUpdateRequest request);

    List<CategoryRecord> findCategories();

    void deleteCategory(Integer id);

    Optional<CategoryRecord> findById(Integer id);
}
