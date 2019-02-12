package com.fasttrackit.service;

import com.fasttrackit.domain.Product;
import com.fasttrackit.domain.Shop;
import com.fasttrackit.dto.ProductDTO;
import com.fasttrackit.dto.ShopDTO;
import com.fasttrackit.persistence.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ShopService
{
    @Autowired
    private ShopRepository shopRepository;

    @Transactional
    public void saveShop(Shop shop)
    {
        if (shop.getName() == null)
        {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (shop.getAdress() == null)
        {
            throw new IllegalArgumentException("Adress cannot be null");
        }
        try
        {
            //open transaction
            shopRepository.save(shop);
            //close
        } catch (Exception e)
        {
            System.out.println("Error when saving shop" + e);
        }
    }

    @Transactional
    public List<ShopDTO> getShops()
    {
        Iterator<Shop> iterator =
                shopRepository.findAll().iterator();


        List<ShopDTO> list = new ArrayList<>();

        while (iterator.hasNext())
        {
            Shop shop = iterator.next();

            ShopDTO shopDTO = new ShopDTO();
            shopDTO.setName(shop.getName());
            shopDTO.setId(shop.getId());


            List<Product> products = shop.getProducts();
            int nrOfProd = 0;
            while (nrOfProd < 5 && products.size() >= 5)
            {

                Product product = products.get(nrOfProd);
                ProductDTO productDTO = new ProductDTO();

                productDTO.setId(product.getId());
                productDTO.setName(product.getName());

                shopDTO.getFirstElements().add(productDTO);
                nrOfProd++;
            }

            list.add(shopDTO);
        }

        return list;
    }


    private ShopDTO convertToDto(Shop shop)
    {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setName(shop.getName());
        shopDTO.setId(shop.getId());
        shopDTO.setDescription((shopDTO.getDescription()));
        return shopDTO;
    }

    private Shop convert(ShopDTO shop)
    {
        Shop shop1 = new Shop();
        shop.setName(shop.getName());
        shop.setId(shop.getId());
        shop.setDescription((shop.getDescription()));
        return shop1;
    }

    public ShopDTO getShopById(long id)
    {

        Shop one = shopRepository.findOne(id);
        if(one == null)
        {
            throw new IllegalArgumentException("The id is not valid.");
        }

        return null;

    }

    public ShopDTO updateShop(long id, ShopDTO dto)
    {
        Shop shop = shopRepository.findOne(id);
        shop.setDescription(dto.getDescription());
        shop.setName(dto.getName());

        Shop save = shopRepository.save(shop);

        return convertToDto(save);
    }
}