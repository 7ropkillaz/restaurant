package com.company.repository;

import com.company.model.Dish;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class FileRepos implements DishRepository {
    InputStream inputStream;
    OutputStream outputStream;

    @Override
    public void add(Dish object) {
        outputStream.write(object);
        outputStream.write("\n");
    }

    @Override
    public void edit(int id, Dish object) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void remove(Dish object) {

    }

    @Override
    public List<Dish> getAll() {

        return null;
    }
}
