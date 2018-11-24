package com.hcl.challenge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.challenge.model.Pizza;
import com.hcl.challenge.model.Region;
import com.hcl.challenge.repository.PizzaRepository;
import com.hcl.challenge.repository.RegionRepository;

@Service
public class PizzaServiceImpl implements PizzaService{

	
	@Autowired
	private PizzaRepository pizzaRepo;
	
	@Autowired
	private RegionRepository regionRepo;
	
	
	public List<Pizza> getAllPizza(String regionId) {
		List<Pizza> pizzaList = new ArrayList<>();
		pizzaRepo.findByRegionId(regionId).forEach(pizzaList::add);
		return pizzaList;
	}
	
	public Optional<Pizza> getPizza(String pId) {
		return pizzaRepo.findById(pId);
	}
	
	public void addPizza(Pizza p) {
		pizzaRepo.save(p);
	}
	
	public void updatePizza(Pizza p) {
		pizzaRepo.save(p);
	}
	
	public void deletePizza(String pId) {
		pizzaRepo.deleteById(pId);
	}
	
	public void intializeAllRegions(Region region) {
		regionRepo.save(region);
	}
	
	public void intializeAllPizzas(List<Pizza> pizzaList) {
		for(Pizza pObj : pizzaList) {
			pizzaRepo.save(pObj);
		}
	}
}
