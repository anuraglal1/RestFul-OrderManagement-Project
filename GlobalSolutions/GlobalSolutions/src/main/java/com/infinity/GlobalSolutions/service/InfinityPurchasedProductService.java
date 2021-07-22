package com.infinity.GlobalSolutions.service;

import java.util.List;
import com.infinity.GlobalSolutions.model.InfinityPurchasedProduct;

public interface InfinityPurchasedProductService {

	List<InfinityPurchasedProduct> findPurchasedProductsByOrderId(Integer id);
}
