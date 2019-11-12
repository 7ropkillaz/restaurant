package com.company.repository;

import com.company.model.Dish;

import java.util.ArrayList;

public class Dishimpl implements DishRepository {
    private ArrayList<Dish> _arr;
    public Dishimpl()
    {
        _arr = new ArrayList<Dish>();
    }
    public Dishimpl(int cnt)
    {
        _arr = new ArrayList<Dish>(cnt);
    }
    @Override
    public void add(int index, Object dish)
    {
        if(index<0||index>_arr.size()-1)
            throw new IndexOutOfBoundsException();
        _arr.add(index,(Dish)dish);
    }
    @Override
    public void add(Object dish)
    {
        _arr.add((Dish)dish);
    }
    @Override
    public void edit(int index, Object dish)
    {
        if(index<0||index>_arr.size()-1)
            throw new IndexOutOfBoundsException();
        _arr.remove(index);
        _arr.add(index,(Dish)dish);

    }
    @Override
    public void remove(int index)
    {
        if(index<0||index>_arr.size()-1)
            throw new IndexOutOfBoundsException();
        _arr.remove(index);
    }
    @Override
    public void remove(Object dish)
    {
        _arr.remove(dish);
    }
    @Override
    public Object getAll()
    {
        return _arr;
    }
}
