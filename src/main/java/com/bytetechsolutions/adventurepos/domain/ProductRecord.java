package com.bytetechsolutions.adventurepos.domain;

public record ProductRecord(
                String id,
                String sku,
                String imageUrl,
                String name,
                String price,
                int quantity,
                String cost,
                String category,
                String status,
                String uom
        ) {
}
