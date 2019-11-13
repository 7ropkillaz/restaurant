package com.company.repository;

import com.company.model.Dish;

public interface DishRepository {
    public void add(Dish object);
    public void edit(int id, Dish object);
    public void remove(int index);
    public void remove(Dish object);
    public Object getAll();
}
