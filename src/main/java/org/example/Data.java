package org.example;

import org.example.models.Food;
import org.example.models.Foodtray;
import org.example.models.Menu;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Menu> getData() {
        List<Menu> menus = new ArrayList<>();

        Menu newMenu = new Menu("A1");
        Foodtray newFoodtray = new Foodtray("maki x8");
        newFoodtray.addFoods(new Food("Maki", 8));
        newMenu.addFoodtrays(newFoodtray);
        menus.add(newMenu);

        newMenu = new Menu("A2");
        newFoodtray = new Foodtray("sushi x4");
        newFoodtray.addFoods(new Food("Sushi", 4));
        newMenu.addFoodtrays(newFoodtray);
        menus.add(newMenu);

        newMenu = new Menu("A3");
        newFoodtray = new Foodtray("Donburi x1");
        newFoodtray.addFoods(new Food("Donburi", 1));
        newMenu.addFoodtrays(newFoodtray);
        menus.add(newMenu);

        newMenu = new Menu("A4");
        newFoodtray = new Foodtray("Soba x1");
        newFoodtray.addFoods(new Food("Soba", 1));
        newMenu.addFoodtrays(newFoodtray);
        menus.add(newMenu);

        return menus;

    }
}
