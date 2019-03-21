package com.fasttrackit.persistence;

import com.fasttrackit.domain.Cart;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CartRepository extends PagingAndSortingRepository<Cart, Long>
{

}
