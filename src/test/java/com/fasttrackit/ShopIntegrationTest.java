package com.fasttrackit;

import com.fasttrackit.domain.Basket;
import com.fasttrackit.domain.Product;
import com.fasttrackit.domain.Shop;
import com.fasttrackit.dto.ShopDTO;
import com.fasttrackit.persistence.BasketRepository;
import com.fasttrackit.persistence.ShopRepository;
import com.fasttrackit.service.ShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = ShopApplication.class, loader = SpringApplicationContextLoader.class, initializers = ConfigFileApplicationContextInitializer.class)
    public class ShopIntegrationTest {


        @Autowired
        private ShopRepository repository;
        private BasketRepository basketRepository;


        @Test
        public void testSave()
        {

            Shop store = new Shop();
            store.setName("HamShop");
            store.setAdress("str. Nicolae Teclu, nr.20");

            List<Product> products = new ArrayList<>();
            Product product1 = new Product();
            product1.setName("Royal Canin");
            product1.setPrice(10.5);
            product1.setStock(4);
            products.add(product1);
            store.setProducts(products);
            repository.save(store);



            List<Product> products2 = new ArrayList<>();
            Product product = new Product();
            product.setName("Chappi");
            product.setPrice(35);
            product.setStock(17);
            products2.add(product);
            store.setProducts(products2);
            repository.save(store);

            List<Basket> totalPrice = new ArrayList<>();
            Basket basket = new Basket();
            basket.computeTotalPrice();
            totalPrice.add(basket);
            basketRepository.save(basket);

        }
}
