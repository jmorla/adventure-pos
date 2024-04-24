package com.bytetechsolutions.adventurepos.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytetechsolutions.domain.PagedRequest;
import com.bytetechsolutions.domain.PagedResponse;
import com.bytetechsolutions.domain.ProductRecord;
import com.bytetechsolutions.service.ProductService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductsApiController {

    private final ProductService productService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagedResponse<ProductRecord>> fetchProducts(PagedRequest request) {
        return ResponseEntity.ok(productService.findProducts(request));
    }

}
