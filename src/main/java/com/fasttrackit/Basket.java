package com.fasttrackit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Basket implements Serializable
{
    private String customer;
    private List<Product> products = new ArrayList<>();

    public Basket(String customer)
    {
        this.customer = customer;
    }

    public List<Product> getProducts()
    {
        return products;
    }

    public void setProducts(List<Product> products)
    {
        this.products = products;
    }

    public String getCustomer()
    {
        return customer;
    }

    public void setCustomer(String customer)
    {
        this.customer = customer;
    }

    public void addProduct(Product product)
    {
        this.getProducts().add(product);
    }

    public int basketPrice()
    {
        int total = 0;
        for(Product product : products)
        {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }



}
