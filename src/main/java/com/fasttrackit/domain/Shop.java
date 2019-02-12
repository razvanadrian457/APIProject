package com.fasttrackit.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "store")
public class Shop
{
    @Id
    @GeneratedValue(generator = "shop_generator")
    @SequenceGenerator(
            name = "shop_generator",
            sequenceName = "shop_sequence",
            initialValue = 1
    )

    private long id;
    private String name;
    private String adress;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="shop_Id")
    private List<Product> products = new ArrayList<>();

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public List<Product> getProducts()
    {
        return products;
    }

    public void setProducts(List<Product> products)
    {
        this.products = products;
    }

    public String getAdress()
    {
        return adress;
    }

    public void setAdress(String adress)
    {
        this.adress = adress;
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
        final StringBuilder sb = new StringBuilder("Shop{");
        sb.append("Id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", adress='").append(adress).append('\'');
        sb.append(", products=").append(products);
        sb.append('}');
        return sb.toString();
    }
}