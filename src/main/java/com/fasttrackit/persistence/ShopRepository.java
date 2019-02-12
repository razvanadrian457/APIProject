package com.fasttrackit.persistence;

import com.fasttrackit.domain.Shop;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShopRepository extends PagingAndSortingRepository<Shop, Long>
{

}
