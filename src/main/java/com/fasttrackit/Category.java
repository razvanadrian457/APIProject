package com.fasttrackit;

import java.util.ArrayList;
import java.util.List;

public class Category
{
    private String name;
    private String owner;

    private List<Product> products = new ArrayList<>();

    public Category(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return  name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getOwner()
    {
        return  owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public List<Product> getProducts()
    {
        return products;
    }

    public void setProducts(List<Product> products)
    {
        this.products = products;
    }



}
