package com.hcl.challenge.service;

import java.util.List;
import java.util.Optional;

import com.hcl.challenge.model.Pizza;
import com.hcl.challenge.model.Region;

public interface PizzaService {

	public List<Pizza> getAllPizza(String regionId);
	public Optional<Pizza> getPizza(String id);
	public void addPizza(Pizza p);
	public void updatePizza(Pizza p);
	public void deletePizza(String pId);
	public void intializeAllPizzas(List<Pizza> pizzaList);
	public void intializeAllRegions(Region region);
}
