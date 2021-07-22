package com.infinity.GlobalSolutions.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinity.GlobalSolutions.model.InfinityCustomer;
import com.infinity.GlobalSolutions.repository.InfinityCustomerRepository;

@Service
public class InfinityCustomerServiceImpl implements InfinityCustomerService {
	
	@Autowired
	private InfinityCustomerRepository custRepo;
	
	@Override
	public List<InfinityCustomer> getAllCustomer(){
		
		return (List<InfinityCustomer>) custRepo.findAll();
	}

	@Override
	public void addCustomer(InfinityCustomer newCustomer) {
		
		custRepo.save(newCustomer);
		
	}

	@Override
	public Optional<InfinityCustomer> getCustomerByID(Integer id) {
		
		return custRepo.findById(id);
	}

	@Override
	public Optional<InfinityCustomer> replaceCustomer(Integer id, InfinityCustomer newCustomer) {
		
		return custRepo.findById(id)
				.map(customer -> {
					customer.setAddress(newCustomer.getAddress());
					customer.setContact(newCustomer.getContact());
					customer.setEmail(newCustomer.getEmail());
					customer.setName(newCustomer.getName());
					return custRepo.save(customer);
				});
	}

	@Override
	public void deleteCustomer(Integer id) {
		
		custRepo.deleteById(id);
		
	}
	
	

}
