package com.company.repository;

import com.company.model.Dish;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DishFileImpl implements DishRepository {
    private File file;
    private String filename;
    private FileReader fileReader;
    private FileWriter fileWriter;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public DishFileImpl(String filename) {
        try {
            this.filename = filename;
            file = new File(filename);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void add(Dish object) {
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            fileWriter.write(object.getName() + "\n");
            fileWriter.write(object.getPrice() + "\n");
            fileWriter.write(object.getCategory() + "\n");
            fileWriter.write("\n");
            fileWriter.close(); // закрываем поток
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(int id, Dish object){
        try {
            ArrayList<Dish> arr = new ArrayList<Dish>(getAll());
            file = new File(filename);
            fileWriter = new FileWriter(file);
            for (int i = 0; i < arr.size(); i++) {
                if (id == i) {
                    add(object);
                } else {
                    add(arr.get(i));
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int index) {//удаление по индексу
        try {
            ArrayList<Dish> arr = new ArrayList<Dish>(getAll());
            file = new File(filename);
            fileWriter = new FileWriter(file);
            for (int i = 0; i < arr.size(); i++) {
                if (index == i) {
                    continue;
                } else {
                    add(arr.get(i));
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Dish object) {
        try {
            ArrayList<Dish> arr = new ArrayList<Dish>(getAll());
            file = new File(filename);
            fileWriter = new FileWriter(file);
            for (int i = 0; i < arr.size(); i++) {
                if ((arr.get(i).getId()==object.getId())&&(object.getCategory().equals(arr.get(i).getCategory())) && (object.getPrice() == arr.get(i).getPrice()) && object.getName().equals(arr.get(i).getName())) {
                    continue;
                } else {
                    add(arr.get(i));
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Dish> getAll() {
        List<Dish> arr = new ArrayList<Dish>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Dish dish = new Dish();
                dish.setName(line);
                dish.setPrice(Integer.parseInt(bufferedReader.readLine()));
                dish.setCategory(bufferedReader.readLine());
                bufferedReader.readLine();
                arr.add(dish);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
}
