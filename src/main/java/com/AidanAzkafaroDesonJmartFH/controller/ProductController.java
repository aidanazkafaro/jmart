package com.AidanAzkafaroDesonJmartFH.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AidanAzkafaroDesonJmartFH.Account;
import com.AidanAzkafaroDesonJmartFH.Algorithm;
import com.AidanAzkafaroDesonJmartFH.JsonTable;
import com.AidanAzkafaroDesonJmartFH.Product;
import com.AidanAzkafaroDesonJmartFH.ProductCategory;
import com.AidanAzkafaroDesonJmartFH.dbjson.JsonAutowired;

@RequestMapping("/product")
public class ProductController implements BasicGetController<Product> {
	
	@JsonAutowired(filepath ="C:\\Users\\aidan\\Programming\\OOP Tekkom\\Praktikum OOP\\jmart\\jsonFiles\\randomProductList.json", value = Product.class)
	public static JsonTable<Product> productTable;

	@PostMapping("/create")
	public Product create ( 
			@RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int weight,
            @RequestParam boolean conditionUsed,
            @RequestParam double price,
            @RequestParam double discount,
            @RequestParam ProductCategory category,
            @RequestParam byte shipmentPlans) {
		
//		if((Account.id == accountId) && Account.store != null) {
//			
//		}
				return null;
		
	}
	
	@Override
	public JsonTable<Product> getJsonTable() {
		// TODO Auto-generated method stub
		return productTable;
	}
	

	@GetMapping("/{id}/store")
	public List<Product> getProductByStore ( 
			@RequestParam int id,
            @RequestParam int page,
            @RequestParam int pageSize){
		return Algorithm.paginate(productTable, page, pageSize,pred->pred.accountId == id);
	}
	
	@GetMapping("/{id}/store")
	public List<Product> getProductFiltered (
			@RequestParam int page, 
			@RequestParam int pageSize,
			@RequestParam int accountId, 
			@RequestParam String search, 
			@RequestParam int minPrice, 
			@RequestParam int maxPrice,
			@RequestParam ProductCategory category)
	{
		return null;

	}
	

	
	
}
