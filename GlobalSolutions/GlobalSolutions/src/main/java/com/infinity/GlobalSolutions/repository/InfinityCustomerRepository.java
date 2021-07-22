package com.infinity.GlobalSolutions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.infinity.GlobalSolutions.model.InfinityCustomer;

@Repository
public interface InfinityCustomerRepository extends JpaRepository<InfinityCustomer, Integer> {

}
