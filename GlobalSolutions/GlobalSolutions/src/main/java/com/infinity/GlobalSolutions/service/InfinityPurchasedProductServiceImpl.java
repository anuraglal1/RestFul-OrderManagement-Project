package com.infinity.GlobalSolutions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinity.GlobalSolutions.model.InfinityOrder;
import com.infinity.GlobalSolutions.model.InfinityPurchasedProduct;
import com.infinity.GlobalSolutions.repository.InfinityOrderRepository;
import com.infinity.GlobalSolutions.repository.InfinityPurchasedProductRepository;

@Service
public class InfinityPurchasedProductServiceImpl implements InfinityPurchasedProductService{
	
	@Autowired
	private InfinityPurchasedProductRepository purchasedProductRepo;

	@Override
	public List<InfinityPurchasedProduct> findPurchasedProductsByOrderId(Integer id) {
		
		List<InfinityPurchasedProduct> li = purchasedProductRepo.findByOrderId(id);
		return li;
		
	}

}
