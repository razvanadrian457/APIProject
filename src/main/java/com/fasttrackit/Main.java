package com.fasttrackit;


public class Main
{


    public static void main(String[] args)
    {
        //creating the shop
        Shop shop = new Shop("DogShop");

        //food and toy categories
        Category food = new Category("Food");
        Category toys = new Category("Toys");

        //creating the food products
        Product dryFood = new Product("Petkult", 210, 12, food);
        Product wetFood = new Product("Dog Patrol", 12, 1, food);
        Product treats = new Product("Enjoy Carnivore", 73, 3, food);




        //creating the toy products
        Product rubberToys = new Product("Ipts Frog", 28, 1, toys);
        Product rope = new Product("Ipts Rope", 17, 2, toys);


        //adding the created categories to shop
        shop.getCategories().add(food);
        shop.getCategories().add(toys);

        //building the baskets

        Basket basket = new Basket("Timmy");
        basket.addProduct(dryFood);
        basket.addProduct(wetFood);
        basket.addProduct(treats);

        Basket basket1 = new Basket("Ashley");
        basket1.addProduct(rubberToys);
        basket1.addProduct(rope);

        //output for the orders
        System.out.println(" " + basket.getCustomer());
        System.out.println("The basket contains " + basket.getProducts().size() + " products: ");
        System.out.println("The basket price is: " + basket.basketPrice());

        System.out.println(" " + basket1.getCustomer());
        System.out.println("The basket contains " + basket1.getProducts().size() + " products.");
        System.out.println("The basket price is: " + basket1.basketPrice());

    }
}

