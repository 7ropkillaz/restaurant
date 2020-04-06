package com.company.controller;

import com.company.model.Dish;
import com.company.model.Converter;
import com.company.repository.DishDataBaseImpl;
import com.company.repository.DishRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ServletController extends HttpServlet {
    DishRepository impl;

    @Override
    public void init() {
        impl = new DishDataBaseImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
            switch (action) {
                case "/add":
                    addDish(request, response);
                    break;
                case "/delete":
                    deleteDish(request, response);
                    break;
                case "/edit":
                    editDish(request, response);
                    break;
                case "/get":
                    getDish(request, response);
                    break;
            }
    }

    private void getDish(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Converter converter = new Converter();
        if(request.getPathInfo()!=null){
            response.getWriter().write(request.getPathInfo());
            int id = Integer.parseInt(request.getPathInfo());
            String json = Converter.objectToJson(impl.get(id));
            response.getWriter().write(json);
        }
        else {
            List<Dish> listDish = impl.getAll();
            for (Dish dish :
                    listDish) {
                String json = Converter.objectToJson(dish);
                response.getWriter().write(json + "\n");
            }
        }
    }

    private void addDish(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("AddDish.jsp").forward(request, response);
        String json = request.getParameter("dish");
        Dish newDish = (Dish) Converter.jsonToObject(json);
        impl.add(newDish);
        response.sendRedirect("list");
    }

    private void editDish(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("EditDish.jsp").forward(request, response);
        String json = request.getParameter("dish");
        Dish newDish = (Dish) Converter.jsonToObject(json);
        impl.edit(newDish.getId(),newDish);
        response.sendRedirect("list");
    }

    private void deleteDish(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("DeleteDish.jsp").forward(request, response);
        String json = request.getParameter("dish");
        Dish newDish = (Dish) Converter.jsonToObject(json);
        impl.remove(newDish.getId());
        response.sendRedirect("list");
    }
}
