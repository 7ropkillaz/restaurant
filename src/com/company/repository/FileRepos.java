package com.company.repository;

import com.company.model.Restaurant;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileRepos implements RestaurantRepository {

    @Override
    public void edit(String address, String name, int tables, String id) {
        Restaurant[] restaurants = getAll();
        ArrayList<Restaurant> rest = new ArrayList<>(Arrays.asList(restaurants));
        Restaurant r;
        try {
            if (id != null) {
                for (int i = 0; i < rest.size(); i++) {
                    r = rest.get(i);

                    if (r.getId().equals(id)) {
                        r.setAddress(address);
                        r.setName(name);
                        r.setTables(tables);
                        BufferedWriter bw = new BufferedWriter(new FileWriter("text.txt", false));
                        bw.write("");
                        bw.close();

                    }

                }
            }
            for (int i = 0; i < rest.size(); i++) {
                r = rest.get(i);
                add(r);


            }
        } catch (IOException e) {
        }


    }

    @Override
    public Restaurant[] getAll() {
        ArrayList<Restaurant> rest = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\kusai\\IdeaProjects\\restaurant-3\\text.txt"))) {

            String s;
            String address = "";
            String name = "";
            int tables = 0;
            String id = "";
            while ((s = br.readLine()) != null) {
                address = new String(s);
                if ((s = br.readLine()) != null) {
                    name = new String(s);
                }
                if ((s = br.readLine()) != null) {
                    tables = Integer.parseInt(s);
                }
                if ((s = br.readLine()) != null) {
                    id = new String(s);
                }
                rest.add(new Restaurant(address, name, tables, id));
            }
        } catch (IOException e) {
        }
        return rest.toArray(new Restaurant[rest.size()]);

    }

    @Override
    public void remove(String id) {
        FileRepos fileRepos = new FileRepos();
        Restaurant[] restaurants = fileRepos.getAll();
        ArrayList<Restaurant> rest = new ArrayList<>(Arrays.asList(restaurants));
        Restaurant r;
        try {
            if (id != null) {
                for (int i = 0; i < rest.size(); i++) {
                    r = rest.get(i);

                    if (r.getId().equals(id)) {
                        rest.remove(i);
                        BufferedWriter bw = new BufferedWriter(new FileWriter("text.txt", false));
                        bw.write("");
                        bw.close();

                    }

                }
            }
            for (int i = 0; i < rest.size(); i++) {
                r = rest.get(i);
                fileRepos.add(r);


            }
        } catch (IOException e) {
        }


    }

    @Override
    public void add(Restaurant r) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\kusai\\IdeaProjects\\restaurant-3\\text.txt", true))) {


            bw.write(r.getAddress());
            bw.newLine();
            bw.write(r.getName());
            bw.newLine();
            bw.write(Integer.toString(r.getTables()));
            bw.newLine();
            bw.write(r.getId());
            bw.newLine();
            bw.close();

        } catch (IOException e) {
        }

    }
}
