package com.company.controller;

import com.company.model.Restaurant;
import com.company.repository.RestaurantRepository;

public class RestaurantController {

    private RestaurantRepository rest;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.rest = restaurantRepository;

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
