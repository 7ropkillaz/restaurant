package com.company.repository;

import com.company.model.Dish;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDataBaseImpl implements DishRepository {
    List<Dish> dishes = new ArrayList<>();
    Connection connection = null;

    public DishDataBaseImpl(){
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String pass = "dekabor230948";
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection(url, user, pass);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    @Override
    public void add(Dish dish){
        try {
            String sql = "INSERT INTO dishes (\"Id\", \"DishName\", \"Price\", \"Category\") " +
                    "VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,dish.getId());
            preparedStatement.setString(2,dish.getName());
            preparedStatement.setDouble(3,dish.getPrice());
            preparedStatement.setString(4,dish.getCategory());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(int id, Dish dish){
        try {
            String sql = "UPDATE dishes " +
                    "SET \"DishName\" = ?,\"Price\" = ?, \"Category\" = ? " +
                    "WHERE \"Id\" = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,dish.getName());
            preparedStatement.setDouble(2,dish.getPrice());
            preparedStatement.setString(3,dish.getCategory());
            preparedStatement.setInt(4,id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id){//УДАЛЕНИЕ ПО ID
        try {
            String sql = "DELETE FROM dishes WHERE \"Id\" = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Dish dish){
        try {
            String sql = "DELETE FROM dishes WHERE \"DishName\" = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,dish.getName());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Dish get(int id){
        Dish dish = new Dish();
        try {
            String sql = "select * from dishes where \"Id\" = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            dish = new Dish(resultSet.getInt("Id"),resultSet.getString("DishName") ,resultSet.getDouble("Price"),resultSet.getString("Category"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dish;
    }
    @Override
    public List<Dish> getAll() {
        try {
            String sql = "select * from dishes";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Dish dish = new Dish(resultSet.getInt("Id"),resultSet.getString("DishName") ,resultSet.getDouble("Price"),resultSet.getString("Category"));
                dishes.add(dish);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dishes;
    }
}
