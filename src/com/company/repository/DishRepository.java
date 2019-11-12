package com.company.repository;

public interface DishRepository {
    public void add(int index, Object object);
    public void add(Object object);
    public void edit(int index, Object object);
    public void remove(int index);
    public void remove(Object object);
    public Object getAll();
}
