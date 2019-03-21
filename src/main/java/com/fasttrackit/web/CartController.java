package com.fasttrackit.web;

import com.fasttrackit.dto.CartDTO;
import com.fasttrackit.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController
{
    @Autowired
    private CartService cartService;

    @RequestMapping(path = "/cart/(id)", method = RequestMethod.GET)
    public CartDTO getBasket(@PathVariable("id") long id)
    {
        return cartService.getCartById(id);
    }

    @RequestMapping(path = "/cart", method = RequestMethod.POST)
    public void saveBasket(@RequestBody CartDTO cartDTO)
    {
       cartService.saveCart(cartDTO);
    }

    @RequestMapping(path = "/cart/(id)", method = RequestMethod.PUT)
    public CartDTO updateBasket(@PathVariable long id, @RequestBody CartDTO dto)
    {
        return cartService.updateCart(id, dto);
    }
}
