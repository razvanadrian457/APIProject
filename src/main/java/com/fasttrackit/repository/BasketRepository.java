package com.fasttrackit.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BasketRepository
{
    public static void createBasket(String username, String password) throws ClassNotFoundException, SQLException
    {
        //Defining connection parameters to DB
        final String URL = "jdbc:postgresql://54.93.65.6:5432/moldovanrazvan";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        //Obtaining a connection
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

        //Creating a query statement
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USERS (USERNAME, PASSWORD) VALUES (?,?)");
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);

        //Executing a prepared statement
        int Rowsinverted = preparedStatement.executeUpdate();

        //Closing the objects
        preparedStatement.close();
        connection.close();


    }

    public void updateBasket() throws ClassNotFoundException, SQLException
    {
        //Defining connection parameters to DB
        final String URL = "jdbc:postgresql://54.93.65.6:5432/moldovanrazvan";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        //Obtaining a connection
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

        //creating a query statement
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE USERS SET PASSWORD=? WHERE USERNAME=?");
        preparedStatement.setString(1, "data");
        preparedStatement.setString(2, "bases");

        //executing a prepared statement
        int rowsUpdated = preparedStatement.executeUpdate();

        //closing the objects
        preparedStatement.close();
        connection.close();
        
    }

    public void deleteBasket() throws  ClassNotFoundException, SQLException
    {
        //Defining connection parameters to DB
        final String URL = "jdbc:postgresql://54.93.65.6:5432/moldovanrazvan";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        //Obtaining a connection
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

        //Creating a query statement
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM USERS WHERE id=?");
        preparedStatement.setLong(1, 3);

        //Executing a prepared statement
        int rowsDeleted = preparedStatement.executeUpdate();
        System.out.println(rowsDeleted + " rows were deleted.");

        //Closing the objects
        preparedStatement.close();
        connection.close();
    }

    private static List findAllBasket() throws ClassNotFoundException, SQLException
    {
        //Defining connection parameters to DB
        final String URL = "jdbc:postgresql://54.93.65.6:5432/moldovanrazvan";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        //Obtaining a connection
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

        //Creating a query statement
        Statement statement = connection.createStatement();

        //Executing a query
        ResultSet resultSet = statement.executeQuery("SELECT username,password FROM users");

        //Iterating the result set and print the values
        List<User> list = new ArrayList<>();
        while (resultSet.next())
        {
            User user = new User();
            user.setUsername(resultSet.getString("username").trim());
            user.setPassword(resultSet.getString("password").trim());

            list.add(user);
        }

        //closing the objects
        resultSet.close();
        statement.close();
        connection.close();


        return list;
    }



}
