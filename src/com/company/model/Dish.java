package com.company.model;

public class Dish {
    private String name;
    private int price;
    private String category;

    public Dish() {
    }

    public Dish(String name, int price, String category)
    {
        this.name =name;
        this.price =price;
        this.category =category;
    }


    public String getCategory() {
        return category;
    }

    public int getPrice() {
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

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString()
    {
        StringBuffer stringBuffer = new StringBuffer("Dish:"+ name +" Price:"+ price +" Category:"+ category);
        return new String(stringBuffer);
    }
}

