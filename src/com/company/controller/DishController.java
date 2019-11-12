package com.company.controller;

import com.company.repository.Dishimpl;
import repository.Dishimpl;

public class DishController {
    Dishimpl _impl;
    DishController(Dishimpl impl)
    {
        _impl=impl;
    }
    public void add(int index, Object dish)
    {
       _impl.add(index,dish);
    }
    public void add(Object dish)
    {
        _impl.add(dish);
    }
    public void edit(int index, Object dish)
{
    _impl.edit(index,dish);
}
    public void remove(int index)
    {
        _impl.remove(index);
    }
    public void remove(Object dish)
    {
        _impl.remove(dish);
    }
    public Object getAll()
    {
        return _impl.getAll();
    }
}
