package com.company.controller;

import com.company.repository.DishDataBaseImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletController extends HttpServlet {
    DishDataBaseImpl impl;
    ServletController(DishDataBaseImpl impl){
        this.impl = impl;
    }
    public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        int id=0;//здесь должен получаться каким=то образом id
        PrintWriter writer = response.getWriter();
        try {
            writer.println(impl.get(id));
        }
        finally {
            writer.close();
        }
    }
    public void put(){

    }
    public void post(){

    }
    public void delete(){

    }
    public void head(){

    }
    public void options(){

    }

}
