package com.fasttrackit.service;

import com.fasttrackit.domain.Cart;
import com.fasttrackit.domain.Product;
import com.fasttrackit.domain.User;
import com.fasttrackit.dto.CartDTO;
import com.fasttrackit.dto.ProductDTO;
import com.fasttrackit.dto.UserDTO;
import com.fasttrackit.persistence.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CartService
{
    @Autowired
    private CartRepository cartRepository;

   // @Transactional
    public void saveCart(CartDTO cartDTO)
    {
        if(cartDTO.getUser() == null)
        {
            throw new IllegalArgumentException("User cannot be null");
        }
        try {
            Cart cart = convertFromDTO(cartDTO);
            cartRepository.save(cart);
        }
        catch (Exception e)
        {
            System.out.println("Error when saving cart" + e);
        }
    }

    @Transactional
    public List<CartDTO> getCart()
    {
        Iterator<Cart> iterator = cartRepository.findAll().iterator();

        List<CartDTO> list = new ArrayList<>();

        while (iterator.hasNext())
        {
            Cart cart = iterator.next();

            CartDTO cartDTO = convertToDTO(cart);

            list.add(cartDTO);
        }
     return list;
    }

    private CartDTO convertToDTO(Cart cart)
    {
        CartDTO cartDTO = new CartDTO();

        UserDTO userDTO = convertToUserDTO(cart);

        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product: cart.getProducts())
        {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setImagePath(product.getImagePath());
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());

            productDTOS.add(productDTO);
        }

        cartDTO.setProducts(productDTOS);
        cartDTO.setUser(userDTO);
        cartDTO.setId(cart.getId());
        return cartDTO;
    }

    private UserDTO convertToUserDTO(Cart cart)
    {
        UserDTO userDTO = new UserDTO();

        userDTO.setPassword(cart.getUser().getPassword());
        userDTO.setEmail(cart.getUser().getEmail());
        userDTO.setId(cart.getUser().getId());

        return userDTO;
    }

    private Cart convertFromDTO(CartDTO cartDTO)
    {
        Cart cart = new Cart();

        User user = convertUserFromDTO(cartDTO);

       cart.setUser(user);
       cart.setId(cartDTO.getId());

        List<Product> products = new ArrayList<>();
        for(ProductDTO productDTO: cartDTO.getProducts())
        {
            Product product = new Product();

            product.setImagePath(productDTO.getImagePath());
            product.setPrice(productDTO.getPrice());
            product.setName(productDTO.getName());
            product.setId(productDTO.getId());
        }

        cart.setProducts(products);

        return cart;
    }

    private User convertUserFromDTO(CartDTO cartDTO)
    {
        User user = new User();

        user.setEmail(cartDTO.getUser().getEmail());
        user.setPassword(cartDTO.getUser().getPassword());
        user.setId(cartDTO.getUser().getId());

        return user;
    }

    public CartDTO getCartById(long id)
    {
        Cart one = cartRepository.findOne(id);

        if(one == null)
        {
            throw new IllegalArgumentException("This id is not vaild");
        }
        return null;
    }

    public CartDTO updateCart(long id, CartDTO dto)
    {
        Cart cart = cartRepository.findOne(id);
        User user = convertUserFromDTO(dto);

        cart.setUser(user);
        Cart save = cartRepository.save(cart);

        return convertToDTO(save);
    }

}
