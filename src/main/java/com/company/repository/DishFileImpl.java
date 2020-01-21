package com.company.repository;

import com.company.model.Dish;

import java.io.*;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;

public class DishFileImpl implements DishRepository {
    private File file;
    private String filename;

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
        try(FileWriter fileWriter = new FileWriter(file, true) ; BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
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
        try (FileWriter fileWriter = new FileWriter(file)){
            ArrayList<Dish> arr = new ArrayList<Dish>(getAll());
            File file = new File(filename);
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
        try (FileWriter fileWriter = new FileWriter(file)){
            ArrayList<Dish> arr = new ArrayList<Dish>(getAll());
            file = new File(filename);
            for (int i = 0; i < arr.size(); i++) {
                if (index == i) {
                    continue;
                } else
                    add(arr.get(i));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Dish object) {
        try (FileWriter fileWriter = new FileWriter(file)){
            ArrayList<Dish> arr = new ArrayList<Dish>(getAll());
            file = new File(filename);
            for (int i = 0; i < arr.size(); i++) {
                if ((arr.get(i).getId()==object.getId())&&(object.getCategory().equals(arr.get(i).getCategory())) && (object.getPrice() == arr.get(i).getPrice()) && object.getName().equals(arr.get(i).getName())) {
                    continue;
                } else
                    add(arr.get(i));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Dish> getAll() {
        List<Dish> arr = new ArrayList<Dish>();
        try (FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Dish dish = new Dish();
                dish.setName(line);
                dish.setPrice(Integer.parseInt(bufferedReader.readLine()));
                dish.setCategory(bufferedReader.readLine());
                bufferedReader.readLine();
                arr.add(dish);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return arr;
    }

    @Override
    public Dish get(int index) {
        Dish dish = new Dish();
        try (FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if(i==index) {
                    dish.setName(line);
                    dish.setPrice(Integer.parseInt(bufferedReader.readLine()));
                    dish.setCategory(bufferedReader.readLine());
                    bufferedReader.readLine();
                    break;
                }
                else i++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dish;
    }
}
