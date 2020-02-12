package com.company.controller;

import com.company.model.Dish;
import com.company.repository.DishDataBaseImpl;
import com.company.repository.DishImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ServletController extends HttpServlet {
    DishImpl impl;

    @Override
    public void init() {
        //String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        //String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        //String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        //impl = new DishDataBaseImpl(jdbcURL,jdbcUsername,jdbcPassword);
        impl = new DishImpl();
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
                case "/new":

                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertDish(request, response);
                    break;
                case "/delete":
                    deleteDish(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateDish(request, response);
                    break;
                default:
                    listDish(request, response);
                    break;
            }
    }

    private void listDish(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Dish> listDish = impl.getAll();//пребразовать в json с помощью object mapper
        response.getWriter().write("Privet");
        //request.setAttribute("listDish", listDish);
        //RequestDispatcher dispatcher = request.getRequestDispatcher("DishList.jsp");
        //dispatcher.forward(request, response);
        response.getWriter().flush();
        response.getWriter().close();
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("DishForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Dish existingDish = impl.get(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("DishForm.jsp");
        request.setAttribute("dish", existingDish);
        dispatcher.forward(request, response);
    }

    private void insertDish(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        Dish newDish = new Dish(name,price,category);
        impl.add(newDish);
        response.sendRedirect("list");
    }

    private void updateDish(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        Dish newDish = new Dish(id,name,price,category);
        impl.edit(id,newDish);
        response.sendRedirect("list");
    }

    private void deleteDish(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        impl.remove(id);
        response.sendRedirect("list");
    }
}
