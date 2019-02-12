package com.fasttrackit.dto;

import com.fasttrackit.domain.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopDTO extends Shop
{
    private long id;
    private String name;
    private String adress;
    private String description;

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private List<ProductDTO> firstElements = new ArrayList<>();

    @Override
    public long getId()
    {
        return id;
    }

    @Override
    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAdress()
    {
        return adress;
    }

    public void setAdress(String adress)
    {
        this.adress = adress;
    }

    public List<ProductDTO> getFirstElements()
    {
        return firstElements;
    }

    public void setFirstElements(List<ProductDTO> firstlements)
    {
        this.firstElements = firstlements;
    }


}

