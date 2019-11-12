package com.company.model;

import java.util.ArrayList;

public class RestaurantRepositoryImpl implements RestaurantRepository {
    private ArrayList<Restaurant> rest;


    public RestaurantRepositoryImpl() {
        this.rest = new ArrayList<Restaurant>();
    }

    @Override
    public void edit(String address, String name, int tables, String id) {
        Restaurant r = restaur(id);
        if (r != null) {
            if (address != null) {
                r.setAddress(address);
            }
            if (name != null) {
                r.setName(name);
            }
            if (tables != 0) {
                r.setTables(tables);
            }

        }
    }

    @Override
    public Restaurant[] getAll() {
        return rest.toArray(new Restaurant[rest.size()]);
    }

    @Override
    public void remove(String id) {
        Restaurant r;
        if (id != null) {
            for (int i = 0; i < rest.size(); i++) {
                r = rest.get(i);
                if (r.getId().equals(id)) {
                    rest.remove(i);
                }
            }
        }
    }

    @Override
    public void add(Restaurant r) {
        this.rest.add(r);
    }

    private Restaurant restaur(String id) {
        Restaurant r;
        if (id != null) {
            for (int i = 0; i < rest.size(); i++) {
                r = rest.get(i);
                if (r.getId().equals(id)) {
                    return r;
                }
            }
        }
        return null;
    }
}
