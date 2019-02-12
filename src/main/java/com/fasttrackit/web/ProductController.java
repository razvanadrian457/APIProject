package com.fasttrackit.web;

import com.fasttrackit.dto.ProductDTO;
import com.fasttrackit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController
{
    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/product/(id)", method = RequestMethod.GET)
    public ProductDTO getProduct(@PathVariable("id") long id)
    {
        return productService.getProductById(id);
    }

    @RequestMapping(path = "/product", method = RequestMethod.POST)
    public void saveProduct(@RequestBody ProductDTO productDTO)
    {

    }

//    @RequestMapping(path = "/product/(id)", method = RequestMethod.PUT)
//    public ProductDTO updateProduct(@PathVariable long id, @RequestBody ProductDTO dto)
//    {
//        //return ProductService.updateProduct(id, dto);
//    }
}
