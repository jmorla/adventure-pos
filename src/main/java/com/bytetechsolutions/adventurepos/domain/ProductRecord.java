package com.bytetechsolutions.adventurepos.domain;

public record ProductRecord(String id, String photoUrl, String name, double price, int quantity, double cost,
        String category, String status) {
}
