package com.bytetechsolutions.adventurepos.domain;

public record CategoryUpdateForm (Integer id, String name, String description ) implements CategoryForm {
}
