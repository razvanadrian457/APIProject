package com.fasttrackit.domain;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User
{

    @Id
    @GeneratedValue(generator = "basket_generator")
    @SequenceGenerator(
            name = "basket_generator",
            sequenceName = "basket_sequence",
            initialValue = 1
    )

    private long id;


    private String email;
    private String password;

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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }


}
