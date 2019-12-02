package com.company.repository;


import com.company.model.Dish;

import java.io.IOException;
import java.util.List;

public interface DishRepository {
    public void add(Dish object);
    public void edit(int id, Dish object) throws IOException;
    public void remove(int index) throws IOException;
    public void remove(Dish object) throws IOException;
    public List<Dish> getAll();
}
