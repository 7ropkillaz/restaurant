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
    public void edit(int index, Dish dish) throws IOException {
        rep.edit(index,dish);
    }
    public void remove(int index) throws IOException {
        rep.remove(index);
    }
    public void remove(Dish dish) throws IOException {
        rep.remove(dish);
    }
    public List<Dish> getAll()
    {
        return rep.getAll();
    }
}

