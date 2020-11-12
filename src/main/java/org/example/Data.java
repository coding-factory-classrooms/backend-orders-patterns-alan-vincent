package org.example;

import org.example.models.Food;
import org.example.models.Foodtray;
import org.example.models.Menu;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static void getData() {
        List<Menu> Menus = new ArrayList<>();
        Menu newMenu = new Menu();

        newMenu.setTitle("A1");
        Foodtray newFoodtray = new Foodtray();
        newFoodtray.setDescription("maki x8");
        newFoodtray.addFoods(new Food("Maki", 8));
        newMenu.addFoodtrays(newFoodtray);

        newMenu.setTitle("A2");
        newFoodtray = new Foodtray();
        newFoodtray.setDescription("sushi x4");
        newFoodtray.addFoods(new Food("Sushi", 4));
        newMenu.addFoodtrays(newFoodtray);

        newMenu.setTitle("A3");
        newFoodtray = new Foodtray();
        newFoodtray.setDescription("Donburi x1");
        newFoodtray.addFoods(new Food("Donburi", 1));
        newMenu.addFoodtrays(newFoodtray);

        newMenu.setTitle("A4");
        newFoodtray = new Foodtray();
        newFoodtray.setDescription("Soba x1");
        newFoodtray.addFoods(new Food("Soba", 1));
        newMenu.addFoodtrays(newFoodtray);
    }
}
