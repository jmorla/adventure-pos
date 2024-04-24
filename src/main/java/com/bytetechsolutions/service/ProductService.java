package com.bytetechsolutions.service;


import com.bytetechsolutions.domain.PagedRequest;
import com.bytetechsolutions.domain.PagedResponse;
import com.bytetechsolutions.domain.ProductRecord;

public interface ProductService {

    PagedResponse<ProductRecord> findProducts(PagedRequest request);
    
}
