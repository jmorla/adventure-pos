package com.bytetechsolutions.adventurepos.mappers;

import com.bytetechsolutions.adventurepos.domain.ProductRecord;
import com.bytetechsolutions.adventurepos.entitites.Product;

public interface ProductMapper {
    
    ProductRecord mapProductRecord(Product product);
}
