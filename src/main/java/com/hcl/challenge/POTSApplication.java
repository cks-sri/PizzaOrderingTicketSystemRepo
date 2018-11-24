package com.hcl.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hcl.challenge.model.Pizza;
import com.hcl.challenge.model.Region;
import com.hcl.challenge.service.PizzaService;

@SpringBootApplication
public class POTSApplication implements CommandLineRunner{

	@Autowired
	private PizzaService pizzaService;
	
	public static void main(String[] args) {
		SpringApplication.run(POTSApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Pizza Ordering System Server is started...");
		
		
		// Add initial pizza details to database
		Region region = new Region("101","WestCoast");
		pizzaService.intializeAllRegions(region);
		
		List<Pizza> pizzaList = new ArrayList<>(Arrays.asList(
		new Pizza("1","CaliforniaPizza","Onion and Chicken",12.0f,region),
		new Pizza("2","MargheritaPizza","tomatoes, garlic, oregano",14.0f,region),
		new Pizza("3","CrustPizza","mozzarella, basil",10.0f,region),
		new Pizza("4","ThinPizza","Pepperoni",15.0f,region)
		));
		
		pizzaService.intializeAllPizzas(pizzaList);
		
		
	}
}
