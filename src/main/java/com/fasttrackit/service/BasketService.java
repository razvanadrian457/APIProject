package com.fasttrackit.service;

import com.fasttrackit.domain.Basket;
import com.fasttrackit.domain.Product;
import com.fasttrackit.dto.BasketDTO;
import com.fasttrackit.dto.ProductDTO;
import com.fasttrackit.persistence.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BasketService
{
    @Autowired
    private BasketRepository basketRepository;

    @Transactional
    public void saveBasket(Basket basket)
    {
        if(basket.getUser() == null)
        {
            throw new IllegalArgumentException("User cannot be null");
        }
        try {
                basketRepository.save(basket);
        }catch (Exception e)
        {
            System.out.println("Error when saving basket" + e);
        }
    }

    @Transactional
    public List<BasketDTO> getBasket()
    {
        Iterator<Basket> iterator = basketRepository.findAll().iterator();

        List<BasketDTO> list = new ArrayList<>();

        while (iterator.hasNext())
        {
            Basket basket = iterator.next();

            BasketDTO basketDTO = new BasketDTO();
            basketDTO.setUser(basket.getUser());
            basketDTO.setId(basket.getId());

            List<Product> products = basket.getProducts();
            int numberOfProducts = 0;
            while(numberOfProducts < 5 && products.size() >= 5)
            {
                Product product = products.get(numberOfProducts);
                ProductDTO productDTO = new ProductDTO();

                productDTO.setId(product.getId());
                productDTO.setName(product.getName());

                numberOfProducts++;
            }
            list.add(basketDTO);
        }
     return list;
    }
    private BasketDTO convertToDTO(Basket basket)
    {
        BasketDTO basketDTO = new BasketDTO();
        basketDTO.setUser(basket.getUser());
        basketDTO.setId(basket.getId());
        return basketDTO;
    }

    private Basket basket(Basket basket)
    {
        Basket basket1 = new Basket();
        basket.setUser(basket.getUser());
        basket.setId(basket.getId());
        return basket1;
    }

    public BasketDTO getBasketById(long id)
    {
        Basket one = basketRepository.findOne(id);
        if(one == null)
        {
            throw new IllegalArgumentException("This id is not vaild");
        }
        return null;
    }

    public BasketDTO updateBasket(long id, BasketDTO dto)
    {
        Basket basket = basketRepository.findOne(id);
        basket.setUser(dto.getUser());
        Basket save = basketRepository.save(basket);

        return convertToDTO(save);
    }

}
