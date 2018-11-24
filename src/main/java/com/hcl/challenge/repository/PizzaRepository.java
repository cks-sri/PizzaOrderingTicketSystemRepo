package com.hcl.challenge.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.challenge.model.Pizza;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, String>{

	Iterable<Pizza> findByRegionId(String regionId);
	Optional<Pizza> findById(String pid);
	
	
}
