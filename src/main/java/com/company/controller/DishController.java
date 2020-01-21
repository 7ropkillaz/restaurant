package com.company.controller;



import com.company.model.Dish;
import com.company.repository.DishRepository;

import java.io.IOException;
import java.util.List;

public class DishController {

    private DishRepository rep;
    public DishController(DishRepository impl)
    {
        rep =impl;
    }
    public void add(Dish dish)
    {
        rep.add(dish);
    }
    public void edit(int index, Dish dish) {
        try {
            rep.edit(index, dish);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void remove(int index) {
        try {
            rep.remove(index);
        }
       catch (Exception e){
            e.printStackTrace();
       }
    }
    public void remove(Dish dish) {
        try {
            rep.remove(dish);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<Dish> getAll()
    {
        return rep.getAll();
    }
    public Dish get(int id)
    {
        return rep.get(id);
    }
}

