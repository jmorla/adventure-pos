package com.bytetechsolutions.adventurepos.service;


import com.bytetechsolutions.adventurepos.domain.PagedSearchRequest;
import com.bytetechsolutions.adventurepos.domain.PagedResponse;
import com.bytetechsolutions.adventurepos.domain.ProductRecord;

public interface ProductService {

    PagedResponse<ProductRecord> findProducts(PagedSearchRequest request);
    
}
