package com.infinity.GlobalSolutions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.infinity.GlobalSolutions.model.InfinityOrder;

@Repository
public interface InfinityOrderRepository  extends JpaRepository<InfinityOrder, Integer> {
	
	public List<InfinityOrder> findByCustomerId(Integer id);
	public List<InfinityOrder> findByOrderType(String orderType);

} 
