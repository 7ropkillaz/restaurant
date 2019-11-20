package com.company;

import com.company.controller.RestaurantController;
import com.company.model.Restaurant;
import com.company.repository.RestaurantRepository;
import com.company.repository.RestaurantRepositoryImpl;

public class Main {

    public static void main(String[] args) {
        RestaurantRepository restaurantRepository=new RestaurantRepositoryImpl();
        RestaurantController rest=new RestaurantController(restaurantRepository);
        rest.add("Dachnaya","Perchini1",4,"1333");

        Restaurant[] restaurants=rest.getAll();
        System.out.println("**"+restaurants[0].toString());
        rest.edit("Dachnaya","PerchiniHall",3,"1333");
        Restaurant[] restaurants1=rest.getAll();
        System.out.println(restaurants1[0].getName());

            rest.remove("1333");
            Restaurant[] restaurants2 = rest.getAll();
        if(restaurants2.length!=0) {
            System.out.println(restaurants2[0].getName());
        }
        else {
            System.out.println("Массив равен нулю");
        }

    }
}
