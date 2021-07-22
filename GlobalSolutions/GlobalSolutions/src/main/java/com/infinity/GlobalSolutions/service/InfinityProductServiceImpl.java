package com.infinity.GlobalSolutions.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinity.GlobalSolutions.model.InfinityProduct;
import com.infinity.GlobalSolutions.repository.InfinityProductRepository;

@Service
public class InfinityProductServiceImpl implements InfinityProductService {
	
	@Autowired
	private InfinityProductRepository prodRepo;
	
	@Override
	public List<InfinityProduct> getAllProduct(){
		
		return (List<InfinityProduct>) prodRepo.findAll();
	}

	@Override
	public void addProduct(InfinityProduct newProduct) {
		
		prodRepo.save(  newProduct );
	}

	@Override
	public Optional<InfinityProduct> getProductByID(Integer id) {
		
		return prodRepo.findById(id);
				
	}
	
	@Override
	public Optional<InfinityProduct> replaceProduct(Integer id, InfinityProduct newProduct) {
		
		return prodRepo.findById(id)
				.map(Product -> {
					Product.setAmount(newProduct.getAmount());
					Product.setProductDescr(newProduct.getProductDescr());
					Product.setProductName(newProduct.getProductName());
					return prodRepo.save(Product);
				});
	}

	@Override
	public void deleteProduct(Integer id) {
		
		prodRepo.deleteById(id);
	}
	
}
