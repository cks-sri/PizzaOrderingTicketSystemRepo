package com.hcl.challenge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.challenge.model.Pizza;
import com.hcl.challenge.model.Region;
import com.hcl.challenge.service.PizzaService;

@RestController
@RequestMapping(value="/pots")
public class PizzaOrderController {

	@Autowired
	private PizzaService pizzaService;
	
	@RequestMapping("/region/{rId}/pizza")
	public List<Pizza> getAllPizza(@PathVariable String rId) {
		return pizzaService.getAllPizza(rId);
	}
	
    @RequestMapping("/region/{regionId}/pizza/{id}") 
    public Optional<Pizza> getPizza(@PathVariable String id) {
        return pizzaService.getPizza(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/region/{regionId}/addPizza")
    public void addPizza(@RequestBody Pizza pizza, @PathVariable String regionId) { 
    	pizza.setRegion(new Region(regionId, ""));
        pizzaService.addPizza(pizza);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/region/{regionId}/pizza/{pid}")
    public void updatePizza(@RequestBody Pizza pizza,  @PathVariable String pid,  @PathVariable String regionId) { 
        pizza.setRegion(new Region(regionId, ""));
        pizzaService.updatePizza(pizza);

    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/region/{regionId}/pizza/{id}")
    public void deletePizza(@PathVariable String id, @PathVariable String regionId) {
    	pizzaService.deletePizza(id);

    }
}
