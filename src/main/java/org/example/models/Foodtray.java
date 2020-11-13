package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Foodtray {
    private String description;
    private List<Food> foods;

    public Foodtray(String description) {
        this.description = description;
        this.foods = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public void addFoods(Food food) {
        this.foods.add(food);
    }
}
