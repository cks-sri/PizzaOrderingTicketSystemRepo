package com.hcl.challenge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.challenge.model.Region;

@Repository
public interface RegionRepository extends CrudRepository<Region, String>{

	
}
