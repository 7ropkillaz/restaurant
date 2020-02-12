package com.company;

import com.company.controller.DishController;
import com.company.model.Dish;
import com.company.model.Restaurant;
import com.company.repository.DishDataBaseImpl;
import com.company.repository.DishFileImpl;
import com.company.repository.DishImpl;
import com.company.repository.FileRepos;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        //    RestaurantRepository restaurantRepository=new RestaurantRepositoryImpl();
        //    RestaurantController rest=new RestaurantController(restaurantRepository);
        //    rest.add("Dachnaya","Perchini1",4,"1333");
//
        //    Restaurant[] restaurants=rest.getAll();
        //    System.out.println("**"+restaurants[0].toString());
        //    rest.edit("Dachnaya","PerchiniHall",3,"1333");
        //    Restaurant[] restaurants1=rest.getAll();
        //    System.out.println(restaurants1[0].getName());
//
        //        rest.remove("1333");
        //        Restaurant[] restaurants2 = rest.getAll();
        //    if(restaurants2.length!=0) {
        //        System.out.println(restaurants2[0].getName());
        //    }
        //    else {
        //        System.out.println("Массив равен нулю");
        //    }
        Restaurant r = new Restaurant("Dachnaya", "Stud123", 4, "1333");
        Restaurant d = new Restaurant("Dachnaya2", "Perchini", 4, "13334");
        FileRepos fileRepos = new FileRepos();
        fileRepos.add(r);
        fileRepos.add(d);
        Restaurant[] rest = fileRepos.getAll();
        if (rest.length != 0) {
            System.out.println(rest[0].getName());
        }
        fileRepos.remove("1333");
        fileRepos.edit("WQeqwe", "Perchini", 4, "13334");

        Dish dish1 = new Dish(1,"Pasta", 30, "Italian");
        Dish dish2 = new Dish(2,"Ramen", 50, "Japanese");
        Dish dish3 = new Dish(3,"Pizza", 100, "Italian");
        Dish dish4 = new Dish(4,"Borsch", 70, "Russian");
        Dish dish5 = new Dish(5,"Pelmeni", 90, "Russian");

        //DishDataBaseImpl dishDataBase = new DishDataBaseImpl("jdbc:postgresql://localhost:5432/postgres","postgres","dekabor230948");
        /*
        DishController controller = new DishController(dishDataBase);
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

         */

    }
}
