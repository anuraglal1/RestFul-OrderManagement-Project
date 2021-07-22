package com.infinity.GlobalSolutions.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.infinity.GlobalSolutions.model.InfinityCustomer;
import com.infinity.GlobalSolutions.model.InfinityOrder;
import com.infinity.GlobalSolutions.model.InfinityPurchasedProduct;
import com.infinity.GlobalSolutions.repository.InfinityCustomerRepository;
import com.infinity.GlobalSolutions.repository.InfinityOrderRepository;
import com.infinity.GlobalSolutions.repository.InfinityPurchasedProductRepository;


@Service
public class InfinityOrderServiceImpl implements InfinityOrderService{
	
	@Autowired
	private InfinityOrderRepository orderRepo;
	
	@Autowired
	private InfinityCustomerRepository custRepo;
	
	@Autowired
	private InfinityPurchasedProductRepository ppRepo;
	
	@Override
	public List<InfinityOrder> getAllOrder(){
		
		return (List<InfinityOrder>) orderRepo.findAll();
	}

	@Override
	public void addOrder(InfinityOrder newOrder) {
		
		orderRepo.save(newOrder);
		System.out.print("NewOrder values service:------>"+ newOrder.getCustomerId() + " " + newOrder.getOrderType() + " " + newOrder.getProductId());
		InfinityPurchasedProduct newPurchasedProduct = new InfinityPurchasedProduct();
		newPurchasedProduct.setProductId(newOrder.getProductId());
		newPurchasedProduct.setOrderId(newOrder.getOrderId());
		ppRepo.save(newPurchasedProduct);
	}

	@Override
	public Optional<InfinityOrder> getOrderByID(Integer id) {
		
		return orderRepo.findById(id);
	}
	
	@Override
	public Optional<InfinityOrder> replaceOrder(Integer id, InfinityOrder newOrder) {
		
		return orderRepo.findById(id)
				.map(order -> {
					order.setOrderType(newOrder.getOrderType());
					order.setProductId(newOrder.getProductId());
					order.setCustomerId(newOrder.getCustomerId());
					return orderRepo.save(order);
				});
	}

	@Override
	public void deleteOrder(Integer id) {
		
		orderRepo.deleteById(id);
		
	}

	@Override
	public List<InfinityOrder> findOrdersByCustomerId(Integer id){
		
		List<InfinityOrder> li = orderRepo.findByCustomerId(id);
		return li;
		//return null;
	}

	@Override
	public Optional<InfinityOrder> createOrderByCustomerId(Integer id, InfinityOrder newOrder) {
		
//		List<Infinity_Order> li = new ArrayList<>();
//		Infinity_Customer customer1 = new Infinity_Customer();
//		
//		Optional<Infinity_Customer> byId = custRepo.findById(id);
//		
//		Infinity_Customer customer = byId.get();
//		
//		newOrder.setCustomer_id(customer.getCustomer_id());
//		
//		Infinity_Order order1 = orderRepo.save(newOrder);
//		li.add(order1);
//		
//		customer1.setOrders(li);
//		
//		return Optional.of(order1);
		return null;
	
	}

	@Override
	public List<InfinityOrder> findOrdersByOrderType(String order_type) {
		
		List<InfinityOrder> li = orderRepo.findByOrderType(order_type);
		return li;
	}

	

}
