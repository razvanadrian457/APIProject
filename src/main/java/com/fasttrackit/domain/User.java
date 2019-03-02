package com.fasttrackit.domain;


import javax.persistence.*;

@Entity
@Table(name = "user_Id")
public class User {

    @Id
    @GeneratedValue(generator = "basket_generator")
    @SequenceGenerator(
            name = "basket_generator",
            sequenceName = "basket_sequence",
            initialValue = 1
    )
    private long id;

    private String username;
    private String name;
    private String firstName;
    private String password;
    private int age;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
}
