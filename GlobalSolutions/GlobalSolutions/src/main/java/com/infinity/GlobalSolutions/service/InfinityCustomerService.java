package com.infinity.GlobalSolutions.service;

import java.util.List;
import java.util.Optional;

import com.infinity.GlobalSolutions.model.InfinityCustomer;


public interface InfinityCustomerService {

	List<InfinityCustomer> getAllCustomer();
	Optional<InfinityCustomer> getCustomerByID(Integer id);
    void addCustomer(InfinityCustomer newCustomer);
    Optional<InfinityCustomer> replaceCustomer(Integer id, InfinityCustomer newCustomer);
    void deleteCustomer(Integer id);
}
