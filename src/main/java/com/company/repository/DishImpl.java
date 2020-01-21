package com.company.repository;

import com.company.model.Dish;

import java.util.ArrayList;
import java.util.List;

public class DishImpl implements DishRepository {
    private ArrayList<Dish> arr;

    public DishImpl() {
        arr = new ArrayList<Dish>();
    }

    public DishImpl(int cnt) {
        arr = new ArrayList<Dish>(cnt);
    }

    @Override
    public void add(Dish dish) {
        arr.add((Dish) dish);
    }

    @Override
    public void edit(int index, Dish newDish) {
        Dish dish1 = arr.get(index);
        dish1.setCategory(newDish.getCategory());
        dish1.setName(newDish.getName());
        dish1.setPrice(newDish.getPrice());
    }

    @Override
    public void remove(int index) {
        arr.remove(index);
    }//удаление по индексу

    @Override
    public void remove(Dish dish) {
        arr.remove(dish);
    }

    @Override
    public List<Dish> getAll() {
        return arr;
    }

    @Override
    public Dish get(int index){
        return arr.get(index);
    }
}

