package com.bytetechsolutions.adventurepos.mappers;

import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.bytetechsolutions.adventurepos.domain.ProductRecord;
import com.bytetechsolutions.adventurepos.entitites.Product;

@Component
public class ProductMapperImpl implements ProductMapper {

    private final NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.of("es", "DO"));

    @Override
    public ProductRecord mapProductRecord(Product product) {
        var category = product.getCategory();

        return new ProductRecord(
                product.getId().toString(),
                product.getSku(),
                product.getImageUrl(),
                product.getName(), formatter.format(product.getPrice()),
                product.getQuantity(),
                formatter.format(product.getCost()), category != null ? category.getName() : "<N/A>",
                        product.getStatus().name(), product.getUom());
    }

}