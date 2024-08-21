package com.springinaction.part1.chapter2.domain;

import java.util.List;

public record Taco(String name, List<Ingredient> ingredients) {
}
