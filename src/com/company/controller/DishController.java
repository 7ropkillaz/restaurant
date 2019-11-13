package com.company.controller;

import com.company.model.Dish;
import com.company.repository.DishRepository;
import com.company.repository.Dishimpl;

public class DishController {
    private DishRepository _rep;
    DishController(Dishimpl impl)
    {
        _rep =impl;
    }
    public void add(Dish dish)
    {
        _rep.add(dish);
    }
    public void edit(int index, Dish dish)
{
    _rep.edit(index,dish);
}
    public void remove(int index)
    {
        _rep.remove(index);
    }
    public void remove(Dish dish)
    {
        _rep.remove(dish);
    }
    public Object getAll()
    {
        return _rep.getAll();
    }
}
