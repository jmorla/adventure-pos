package com.bytetechsolutions.adventurepos.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bytetechsolutions.adventurepos.domain.PagedSearchRequest;
import com.bytetechsolutions.adventurepos.domain.PagedResponse;
import com.bytetechsolutions.adventurepos.domain.ProductRecord;
import com.bytetechsolutions.adventurepos.entitites.Product;
import com.bytetechsolutions.adventurepos.repositories.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public PagedResponse<ProductRecord> findProducts(PagedSearchRequest request) {
        log.info("search products: {}", request);
        return PagedResponse.from(productRepository.findAll(PageRequest.of(request.page(), request.size()))
        .map(this::mapProductRecord));
    }

    private ProductRecord mapProductRecord(Product product) {
        return new ProductRecord(product.getId().toString(), null, 
        product.getName(), product.getPrice(), product.getQuantity(), 
                product.getCost(), product.getCategory().getName(), product.getStatus().name());
    }

}
