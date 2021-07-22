package com.infinity.GlobalSolutions.service;

import java.util.List;
import java.util.Optional;
import com.infinity.GlobalSolutions.model.InfinityProduct;

public interface InfinityProductService {

	List<InfinityProduct> getAllProduct();
	Optional<InfinityProduct> getProductByID(Integer id);
	void addProduct(InfinityProduct newProduct);
	Optional<InfinityProduct> replaceProduct(Integer id, InfinityProduct newProduct);
	void deleteProduct(Integer id);
	
}
