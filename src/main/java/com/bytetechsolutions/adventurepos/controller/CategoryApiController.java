package com.bytetechsolutions.adventurepos.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytetechsolutions.adventurepos.domain.CategoryRecord;
import com.bytetechsolutions.adventurepos.mappers.CategoryMapper;
import com.bytetechsolutions.adventurepos.repositories.CategoryRepository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoryApiController {
    
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryRecord>> getAllCategories() {
        log.info("getCategories called");
        var categories = categoryRepository.findAll().stream().map(categoryMapper::mapToCategoryRecord).toList();
        log.info("categories found: {}", categories);
        return ResponseEntity.ok(categories);
    }
}
