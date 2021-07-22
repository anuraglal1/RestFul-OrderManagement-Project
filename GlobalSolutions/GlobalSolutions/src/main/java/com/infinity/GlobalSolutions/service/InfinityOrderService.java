package com.infinity.GlobalSolutions.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.method.annotation.InitBinderDataBinderFactory;

import com.infinity.GlobalSolutions.model.InfinityOrder;


public interface InfinityOrderService {

	List<InfinityOrder> getAllOrder();
	Optional<InfinityOrder> getOrderByID(Integer id);
	void addOrder(InfinityOrder newOrder);
	Optional<InfinityOrder> replaceOrder(Integer id, InfinityOrder newOrder);
	void deleteOrder(Integer id);
	List<InfinityOrder> findOrdersByCustomerId(Integer id);
	Optional<InfinityOrder> createOrderByCustomerId(Integer id, InfinityOrder newOrder);
	List<InfinityOrder> findOrdersByOrderType(String order_type);
}
