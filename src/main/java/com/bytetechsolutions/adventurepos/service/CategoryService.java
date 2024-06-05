package com.bytetechsolutions.adventurepos.service;

import java.util.List;
import java.util.Optional;

import com.bytetechsolutions.adventurepos.domain.CategoryCreateForm;
import com.bytetechsolutions.adventurepos.domain.CategoryRecord;
import com.bytetechsolutions.adventurepos.domain.CategoryUpdateForm;

public interface CategoryService {
    
    void updateCategory(CategoryUpdateForm form);

    List<CategoryRecord> findCategories();

    void deleteCategory(Integer id);

    Optional<CategoryRecord> findById(Integer id);

    void createCategory(CategoryCreateForm form);
}
