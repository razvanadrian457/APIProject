package com.fasttrackit.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product
{
    @Id
    @GeneratedValue(generator = "shop_generator")
    @SequenceGenerator(
            name = "shop_generator",
            sequenceName = "shop_sequence",
            initialValue = 1
    )
    private long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private double price;
    private String name;
    private String imagePath;



    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }


    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getPrice()
    {
        return price;
    }



    public void setPrice(double price)

    {
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("Id=").append(id);
        sb.append(", price=").append(price);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
