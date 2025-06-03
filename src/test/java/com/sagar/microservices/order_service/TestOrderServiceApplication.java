package com.sagar.microservices.order;

import com.sagar.microservices.inventory.InventoryServiceApplication;
import org.springframework.boot.SpringApplication;

public class TestOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(InventoryServiceApplication::main).with(com.sagar.microservices.order.TestcontainersConfiguration.class).run(args);
	}

}
