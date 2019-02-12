package com.fasttrackit.service;

import com.fasttrackit.domain.Product;
import com.fasttrackit.domain.Shop;
import com.fasttrackit.dto.ProductDTO;
import com.fasttrackit.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductService
{

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public  void saveProduct(Product product)
    {
        if(product.getName() == null)
        {
            throw new IllegalArgumentException(("Product name cannot be null"));
        }
        try
        {
            productRepository.save(product);
        }
        catch (Exception e)
        {
            System.out.println("Error when saving product" + e);
        }
    }

    @Transactional
    public List<ProductDTO> getProducts()
    {
        Iterator<Product> iterator = productRepository.findAll().iterator();

        List<ProductDTO> list = new ArrayList<>();

        while ((iterator.hasNext()))
        {
            Product product = iterator.next();

            ProductDTO productDTO = new ProductDTO();
            productDTO.setName(product.getName());
            productDTO.setId(product.getId());
            productDTO.setStock(product.getStock());

            int nrOfProd = 0;

            list.add(productDTO);

        }
        return list;


    }

    private ProductDTO convertToDto(Product product)
    {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setId(product.getId());
        productDTO.setPrice(productDTO.getPrice());
        productDTO.setStock(productDTO.getStock());
        return productDTO;
    }

    private Product convert(ProductDTO productDTO)
    {
        Product product1 = new Product();
        product1.setName(product1.getName());
        product1.setPrice(product1.getPrice());
        product1.setId(product1.getId());
        product1.setStock(product1.getStock());
        return product1;
    }

    public ProductDTO updateProduct(long id, ProductDTO dto)
    {
        Product product1 = productRepository.findOne(id);
        product1.setPrice(dto.getPrice());
        product1.setStock(dto.getStock());
        product1.setName(dto.getName());

        Product save = productRepository.save(product1);

        return  convertToDto(save);
    }

    public ProductDTO getProductById(long id)
    {
        Product product = productRepository.findOne(id);
        if(product == null)
        {
            throw new IllegalArgumentException("The id is not valid.");
        }
        return  null;
    }
}
