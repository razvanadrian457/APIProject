package com.fasttrackit;

import com.fasttrackit.domain.Basket;
import com.fasttrackit.domain.Product;
import com.fasttrackit.domain.Shop;
import com.fasttrackit.domain.User;
import com.fasttrackit.dto.ShopDTO;
import com.fasttrackit.persistence.BasketRepository;
import com.fasttrackit.persistence.ProductRepository;
import com.fasttrackit.persistence.ShopRepository;
import com.fasttrackit.persistence.UserRepository;
import com.fasttrackit.service.ShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = ShopApplication.class, loader = SpringApplicationContextLoader.class, initializers = ConfigFileApplicationContextInitializer.class)
    public class ShopIntegrationTest {


        @Autowired
        private ProductRepository productRepository;
        @Autowired
        private ShopRepository repository;
        @Autowired
        private BasketRepository basketRepository;
        @Autowired
        private UserRepository userRepository;


        @Test
        public void testSave()
        {
            Shop store = new Shop();
            store.setName("HamShop");
            store.setAdress("str. Nicolae Teclu, nr.20");

            List<Product> products = new ArrayList<>();
            Product product1 = new Product();
            product1.setName("Pedigree vital protection");
            product1.setPrice(24.99);
            product1.setStock(4);
            product1.setImagePath("img/food/pedigree.png");
            products.add(product1);
            store.setProducts(products);

            Product product2 = new Product();
            product2.setName("Pedigree puppy");
            product2.setPrice(20.99);
            product2.setStock(79);
            product2.setImagePath("img/food/pedigree-puppy.png");
            products.add(product2);
            store.setProducts(products);

            Product product3 = new Product();
            product3.setName("Purina healthy weight");
            product3.setPrice(35);
            product3.setStock(17);
            product3.setImagePath("img/food/purina.jpg");
            products.add(product3);
            store.setProducts(products);

            Product product4 = new Product();
            product4.setName("Purina dog chow");
            product4.setPrice(27.99);
            product4.setStock(11);
            product4.setImagePath("img/food/purina2.jpg");
            products.add(product4);
            store.setProducts(products);

            Product product5 = new Product();
            product5.setName("Nudges grillers");
            product5.setPrice(12.99);
            product5.setStock(4);
            product5.setImagePath("img/treats/treat1.png");
            products.add(product5);
            store.setProducts(products);

            Product product6 = new Product();
            product6.setName("Purina baked delights");
            product6.setPrice(14.99);
            product6.setStock(14);
            product6.setImagePath("img/treats/treat2.jpg");
            products.add(product6);
            store.setProducts(products);

            Product product7 = new Product();
            product7.setName("Pedigree markies");
            product7.setPrice(11.99);
            product7.setStock(12);
            product7.setImagePath("img/treats/markies.jpg");
            products.add(product7);
            store.setProducts(products);

            Product product8 = new Product();
            product8.setName("Pedigree tasty bites");
            product8.setPrice(15.99);
            product8.setStock(8);
            product8.setImagePath("img/treats/markies.jpg");
            products.add(product8);
            store.setProducts(products);
            repository.save(store);


            User user = new User();
            user.setAge(34);
            user.setFirstName("Razvan");
            user.setName("Adrian");
            user.setUsername("razvan78");
            user.setPassword("polad");
            userRepository.save(user);

            Basket basket = new Basket();
            basket.setProducts(products);
            basket.setTotalPrice(basket.getTotalPrice());
            basketRepository.save(basket);
        }


}
