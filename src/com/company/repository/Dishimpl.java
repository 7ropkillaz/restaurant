package com.company.repository;

import com.company.model.Dish;

import java.util.ArrayList;
import java.util.List;

public class Dishimpl implements DishRepository {
    private ArrayList<Dish> _arr;

    public Dishimpl() {
        _arr = new ArrayList<Dish>();
    }

    public Dishimpl(int cnt) {
        _arr = new ArrayList<Dish>(cnt);
    }

    @Override
    public void add(Dish dish) {
        _arr.add((Dish) dish);
    }

    @Override
    public void edit(int index, Dish newDish) {
       Dish dish1 = _arr.get(index);
       dish1.setCategory(newDish.getCategory());
       dish1.setName(newDish.getName());
       dish1.setPrice(newDish.getPrice());
    }

    @Override
    public void remove(int index) {
        _arr.remove(index);
    }

    @Override
    public void remove(Dish dish) {
        _arr.remove(dish);
    }

    @Override
    public List<Dish> getAll() {
        return _arr;
    }
}
