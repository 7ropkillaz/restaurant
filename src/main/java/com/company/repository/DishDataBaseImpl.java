package com.company.repository;

import com.company.model.Dish;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDataBaseImpl implements DishRepository {
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String pass = "dekabor230948";

    @Override
    public void add(Dish dish){
        Connection con = null;
        {
            try {
                con = DriverManager.getConnection(url, user, pass);
                Statement stat = con.createStatement();
                ResultSet resultSet = stat.executeQuery("INSERT INTO dishes (\"Id\",\"DishName\",\"Price\",\"Category\") " +
                        "VALUES ("+dish.getId()+",\'"+dish.getName()+"\',"+dish.getPrice()+",\'"+dish.getCategory()+"\')");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void edit(int id, Dish dish){
        Connection con = null;
        {
            try {
                con = DriverManager.getConnection(url, user, pass);
                Statement stat = con.createStatement();
                ResultSet resultSet = stat.executeQuery("UPDATE dishes SET \"DishName\"=\'"+dish.getName()+"\',\"Price\"="+dish.getPrice()+",\"Category\"=\'"+dish.getCategory()+"\' WHERE \"Id\"="+id);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void remove(int id){//УДАЛЕНИЕ ПО ID
        Connection con = null;
        {
            try {
                con = DriverManager.getConnection(url, user, pass);
                Statement stat = con.createStatement();
                ResultSet resultSet = stat.executeQuery("DELETE FROM dishes WHERE \"Id\" =" +id);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void remove(Dish dish){
        Connection con = null;
        {
            try {
                con = DriverManager.getConnection(url, user, pass);
                Statement stat = con.createStatement();
                ResultSet resultSet = stat.executeQuery("DELETE FROM dishes WHERE \"DishName\" = \'"+dish.getName()+"\'");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public List<Dish> getAll() {
        Connection con = null;
        ArrayList<Dish> arr = new ArrayList<Dish>();
        {
            try {
                con = DriverManager.getConnection(url, user, pass);
                Statement stat = con.createStatement();
                ResultSet result = stat.executeQuery("select * from dishes");
                while (result.next()) {
                    Dish dish = new Dish(result.getInt("Id"),result.getString("DishName") ,result.getDouble("Price"),result.getString("Category"));
                    arr.add(dish);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return arr;
    }
}
