package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Foodtray implements Cloneable {
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

    @Override
    public String toString(){
        String foodsString = "";
        int index =  0;
        for(Food food: foods){
            foodsString="{"+index+","+food.getDescription()+","+food.getQuantity()+"}";
            index+=1;
        }
        return "("+foodsString+")";
    }

    @Override
    public Object clone() {
        try {
            return (Foodtray) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
            return null;
        }
    }
}
