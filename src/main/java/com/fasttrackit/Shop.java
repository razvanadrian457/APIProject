package com.fasttrackit;

import java.util.HashSet;
import java.util.Set;

public class Shop
{
    private String name;
    private Set<Category> categories = new HashSet<>();

    public Shop(String name)
    {
        this.name = name;
    }

    public Shop(String name, Set<Category> categories)
    {
        this.name = name;
        this.categories = categories;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<Category> getCategories()
    {
        return  categories;
    }

    public void setCategories(Set<Category> categories)
    {
        this.categories = categories;
    }


}
