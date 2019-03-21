package com.fasttrackit.dto;

import com.fasttrackit.domain.Product;
import com.fasttrackit.domain.User;

import java.util.ArrayList;
import java.util.List;

public class CartDTO
{
    private long id;
    private UserDTO user;
    private List<ProductDTO> products = new ArrayList<>();



    public List<ProductDTO> getProducts()
    {
        return products;
    }



    public double getTotalPrice()
    {
        double totalPrice = 0;
        for(ProductDTO product: products)
        {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public UserDTO getUser()
    {
        return user;
    }

    public void setUser(UserDTO user)
    {
        this.user = user;
    }

    public void setProducts(List<ProductDTO> products)
    {
         this.products = products;
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
