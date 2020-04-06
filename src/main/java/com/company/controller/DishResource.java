package com.company.controller;

import com.company.model.Dish;
import com.company.repository.DishDataBaseImpl;
import com.company.repository.DishRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("dishes")
public class DishResource {
    DishRepository repo = new DishDataBaseImpl();

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Dish> getDishes(){
        System.out.println("getAlien called...");
        return repo.getAll();
    }

    @GET
    @Path("dish/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Dish getDish(@PathParam("id") int id){
        return repo.get(id);
    }

    @POST
    @Path("dish")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Dish createAlien(Dish dish){
        System.out.println(dish);
        repo.add(dish);
        return dish;
    }

    @PUT
    @Path("dish")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Dish updateDish(Dish dish){
        System.out.println(dish);
        if(repo.get(dish.getId()).getId()==0) {
            repo.add(dish);
        }
        else{
            repo.edit(dish.getId(),dish);
        }
        return dish;
    }

    @DELETE
    @Path("dish/{id}")
    public Dish deleteDish(@PathParam("id") int id){
        Dish dish = repo.get(id);
        if(dish.getId()!=0)
            repo.remove(id);
        return dish;
    }
}
