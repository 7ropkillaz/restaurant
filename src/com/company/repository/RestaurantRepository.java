package com.company.repository;

import com.company.model.Restaurant;

public interface RestaurantRepository {
    void edit(String address, String name, int tables, String id);
    Restaurant[] getAll();
    void remove(String id);
    void add(Restaurant r);
}

