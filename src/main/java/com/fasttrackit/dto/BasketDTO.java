package com.fasttrackit.dto;

import com.fasttrackit.domain.Product;
import com.fasttrackit.domain.User;

import java.util.ArrayList;
import java.util.List;

public class BasketDTO
{
    private long id;
    private int totalPrice;
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

    public int getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice)
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

    public double computeTotalPrice()
    {
        double total = 0;
        for (Product product : products)
        {
            total += product.getPrice();
        }
        return total;
    }


}
