package com.fasttrackit.dto;

import com.fasttrackit.domain.Product;
import com.fasttrackit.domain.User;

import java.util.ArrayList;
import java.util.List;

public class BasketDTO
{
    private long id;
    private double totalPrice;
    private User user;
    private List<Product> products = new ArrayList<>();



    public List<Product> getProducts()
    {
        return products;
    }

    public void setProducts(List<Product> products)
    {
        this.products = products;
    }

    public double getTotalPrice()
    {
        double totalPrice = 0;
        for(Product product: products)
        {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }


}
