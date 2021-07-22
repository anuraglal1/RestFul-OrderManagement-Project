package com.infinity.GlobalSolutions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinity.GlobalSolutions.model.InfinityProduct;

@Repository
public interface InfinityProductRepository extends JpaRepository<InfinityProduct, Integer> {

}

