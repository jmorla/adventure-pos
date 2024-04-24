package com.bytetechsolutions.adventurepos.service;


import com.bytetechsolutions.adventurepos.domain.PagedRequest;
import com.bytetechsolutions.adventurepos.domain.PagedResponse;
import com.bytetechsolutions.adventurepos.domain.ProductRecord;

public interface ProductService {

    PagedResponse<ProductRecord> findProducts(PagedRequest request);
    
}
