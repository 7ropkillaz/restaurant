package com.company.model;

public class Restaurant {
    private String address;
    private String name;
    private int tables;
    private String id;


    public Restaurant(String address, String name, int tables, String id) {
        this.address = address;
        this.name = name;
        this.tables = tables;
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTables() {
        return tables;
    }

    public void setTables(int tables) {
        this.tables = tables;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
