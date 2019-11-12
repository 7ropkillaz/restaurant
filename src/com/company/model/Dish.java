package com.company.model;

public class Dish {
    private String _name;
    private int _price;
    private Category _category;

    public Dish(String name, int price, Category category)
    {
        _name=name;
        _price=price;
        _category=category;
    }

    public Dish(Dish dish)
    {
        _name = new String(dish._name);
        _category = new Category(dish._category);
        _price = dish._price;
    }

    public Category getCategory() {
        return _category;
    }

    public int getPrice() {
        return _price;
    }

    public String getName() {
        return _name;
    }

    public void setCategory(Category _category) {
        this._category = _category;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public void setPrice(int _price) {
        this._price = _price;
    }

    public Object clone()throws CloneNotSupportedException
    {
        Object res = super.clone();
        return res;
    }

    public String toString()
    {
        StringBuffer stringBuffer = new StringBuffer("Dish:"+_name+" Price:"+_price+" Category:"+_category);
        return new String(stringBuffer);
    }
}
