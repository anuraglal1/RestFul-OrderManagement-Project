package com.infinity.GlobalSolutions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infinity.GlobalSolutions.model.InfinityPurchasedProduct;

public interface InfinityPurchasedProductRepository extends JpaRepository<InfinityPurchasedProduct, Integer>{

	public List<InfinityPurchasedProduct> findByOrderId(Integer id);
}
