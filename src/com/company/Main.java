package com.company;

import com.company.controller.DishController;
import com.company.model.Dish;
import com.company.model.Restaurant;
import com.company.repository.DishFileImpl;
import com.company.repository.DishImpl;
import com.company.repository.FileRepos;

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

        Dish dish1 = new Dish("Pasta", 30, "Italian");
        Dish dish2 = new Dish("Ramen", 50, "Japanese");
        /*
        DishImpl impl = new DishImpl();
        DishController controller = new DishController(impl);
        controller.add(dish1);
        System.out.println(controller.getAll());
        controller.edit(0,dish2);
        System.out.println(controller.getAll());
        controller.remove(0);
        System.out.println(controller.getAll());
         */
        try {


            DishFileImpl fileimpl = new DishFileImpl("file.txt");
            DishImpl dishimpl = new DishImpl();
            DishController controller = new DishController(dishimpl);
            controller.add(dish1);
            controller.add(dish2);
            System.out.println(controller.getAll());
            Dish dish3 = new Dish("Pizza", 100, "Italian");
            controller.edit(0, dish3);
            System.out.println(controller.getAll());
            Dish dish4 = new Dish("Borsch", 70, "Russian");
            controller.add(dish4);
            System.out.println(controller.getAll());
            controller.remove(dish3);
            System.out.println(controller.getAll());
            Dish dish5 = new Dish("Pelmeni", 90, "Russian");
            controller.add(dish5);
            System.out.println(controller.getAll());
            controller.remove(1);
            System.out.println(controller.getAll());
        } catch (Exception e){

        }
    }
}
