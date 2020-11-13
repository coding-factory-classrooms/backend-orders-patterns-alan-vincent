package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String title;
    private List<Foodtray> foodtrays;

    public Menu(String title) {
        this.title = title;
        this.foodtrays = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Foodtray> getFoodtrays() {
        return foodtrays;
    }

    public void setFoodtrays(List<Foodtray> foodrays) {
        this.foodtrays = foodtrays;
    }

    public void addFoodtrays(Foodtray foodtray) {
        this.foodtrays.add(foodtray);
    }
}
