package com.fasttrackit.web;

import com.fasttrackit.dto.BasketDTO;
import com.fasttrackit.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BasketController
{
    @Autowired
    private BasketService basketService;

    @RequestMapping(path = "/basket/(id)", method = RequestMethod.GET)
    public BasketDTO getBasket(@PathVariable("id") long id)
    {
        return basketService.getBasketById(id);
    }

    @RequestMapping(path = "/basket", method = RequestMethod.POST)
    public void saveBasket(@RequestBody BasketDTO basketDTO)
    {
       // basketService.saveBasket(basketDTO);
    }

    @RequestMapping(path = "/basket/(id)", method = RequestMethod.PUT)
    public BasketDTO updateBasket(@PathVariable long id, @RequestBody BasketDTO dto)
    {
        return basketService.updateBasket(id, dto);
    }
}
