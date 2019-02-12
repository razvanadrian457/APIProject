package com.fasttrackit.web;

import com.fasttrackit.domain.Shop;
import com.fasttrackit.dto.ShopDTO;
import com.fasttrackit.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShopController
{
    @Autowired
    private ShopService shopService;

    @RequestMapping(path = "/shop/(id)", method = RequestMethod.GET)
    public ShopDTO getShop(@PathVariable("id") long id)
    {
        return shopService.getShopById(id);
    }

    @RequestMapping(path = "/shop", method = RequestMethod.POST)
    public void saveShop(@RequestBody ShopDTO shop)
    {
        //shopService.saveShop(shop);
    }

    @RequestMapping(path = "/shop/(id)", method = RequestMethod.PUT)
    public ShopDTO updateShop(@PathVariable long id, @RequestBody ShopDTO dto)
    {
        return shopService.updateShop(id, dto);
    }

}
