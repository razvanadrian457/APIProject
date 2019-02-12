package com.fasttrackit.persistence;

import com.fasttrackit.domain.Basket;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BasketRepository extends PagingAndSortingRepository<Basket, Long>
{

}
