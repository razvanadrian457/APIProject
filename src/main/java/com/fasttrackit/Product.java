package com.fasttrackit;


public class Product
{
    private int price;
    private int quantity;
    private String name;
    private Category category;

    public Product(String name, int price, int quantity, Category category)
    {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }


    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Category getCategory()
    {
        return category;
    }
    public void setCategory(Category category)
    {
        this.category = category;
    }


}
