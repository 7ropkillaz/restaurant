package com.company.controller;

import com.company.model.Restaurant;
import com.company.model.RestaurantRepository;
import com.company.model.RestaurantRepositoryImpl;

public class RestaurantController {

    private RestaurantRepository rest;

    public RestaurantController() {
        this.rest = new RestaurantRepositoryImpl() {
        };

    }

    public void edit(String address, String name, int tables, String id) {
        rest.edit(address,name,tables,id);
    }

    public Restaurant[] getAll() {
        return rest.getAll();
    }
    public void remove(String id){
        rest.remove(id);
    }
    public void add(String address, String name, int tables, String id) {
        rest.add(new Restaurant(address,name,tables,id));
    }

}
