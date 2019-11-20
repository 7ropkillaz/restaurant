package com.company.repository;

import com.company.model.Restaurant;

import java.io.Reader;
import java.io.Writer;

public class FileRepos implements RestaurantRepository {

    @Override
    public void edit(String address, String name, int tables, String id) {

    }

    @Override
    public Restaurant[] getAll() {

        return null;
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public void add(Restaurant r) {

    }
}
