package com.company;

import com.company.controller.DishController;
import com.company.model.Dish;
import com.company.repository.*;

public class Main {

    public static void main(String[] args) {
        Dish dish1 = new Dish(1,"Pasta", 30, "Italian");
        Dish dish2 = new Dish(2,"Ramen", 50, "Japanese");
        Dish dish3 = new Dish(3,"Pizza", 100, "Italian");
        Dish dish4 = new Dish(4,"Borsch", 70, "Russian");
        Dish dish5 = new Dish(5,"Pelmeni", 90, "Russian");
        DishRepository dishRep = new DishImpl();
        DishController controller = new DishController(dishRep);
        controller.add(dish1);
        controller.add(dish2);
        controller.add(dish3);
        controller.add(dish4);
        controller.add(dish5);
        System.out.println("\n"+controller.getAll());
        Dish dishex = new Dish(48,"Unagi",70,"Rolls");
        controller.edit(1,dishex);
        System.out.println("\n"+controller.getAll());
        controller.remove(dish2);
        System.out.println("\n"+controller.getAll());
        System.out.println("\n"+controller.get(5));
    }
}
