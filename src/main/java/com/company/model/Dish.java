package com.company.model;

public class Dish {
    private int id;
    private String name;
    private double price;
    private String category;

    public Dish() {
    }
    public Dish(int id, String name, double price, String category)
    {
        this.id = id;
        this.name =name;
        this.price =price;
        this.category =category;
    }

    public Dish (String name, double price, String category){
        this.name =name;
        this.price =price;
        this.category =category;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString()
    {
        StringBuffer stringBuffer = new StringBuffer("Id:"+id+" Dish:"+ name +" Price:"+ price +" Category:"+ category);
        return new String(stringBuffer);
    }
}

