package com.AidanAzkafaroDesonJmartFH.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.AidanAzkafaroDesonJmartFH.Account;
import com.AidanAzkafaroDesonJmartFH.Algorithm;
import com.AidanAzkafaroDesonJmartFH.Product;
import com.AidanAzkafaroDesonJmartFH.ProductCategory;
import com.AidanAzkafaroDesonJmartFH.dbjson.JsonAutowired;
import com.AidanAzkafaroDesonJmartFH.dbjson.JsonTable;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product> {
	@JsonAutowired(filepath = "Product.json", value = Product.class)

	public static JsonTable<Product> productTable;

	@Override
	public JsonTable<Product> getJsonTable() {
		return productTable;
	}

	@GetMapping("/{id}/store")
	@ResponseBody
	List<Product> getProductByStore(@RequestParam int id, @RequestParam int page, @RequestParam int pageSize) {
		return Algorithm.paginate(productTable, page, pageSize, pred -> pred.accountId == id);
	}

	@PostMapping("/create")
	@ResponseBody
	Product create(@RequestParam int accountId, @RequestParam String name, @RequestParam int weight,
			@RequestParam boolean conditionUsed, @RequestParam double price, @RequestParam double discount,
			@RequestParam ProductCategory category, @RequestParam byte shipmentPlans) {
		for (Product each : productTable) {
			if (each.accountId == accountId) {
				Product product = new Product(accountId, name, weight, conditionUsed, price, discount, category,
						shipmentPlans);
				productTable.add(product);
				return product;
			}
		}
		return null;
	}

    @GetMapping("/getFiltered")     
    @ResponseBody
    List<Product> getProductByFilter
            (
                    @RequestParam int page,
                    @RequestParam int pageSize,
                    @RequestParam String search,
                    @RequestParam double minPrice,
                    @RequestParam double maxPrice,
                    @RequestParam ProductCategory category,
                    @RequestParam boolean conditionUsed
            )
    {
        List<Product> tempProduct = new ArrayList<Product>();
        for (Product each : productTable) {
            if (each.name.contains(search))
                if (minPrice <= each.price)
                    if (maxPrice >= each.price)
                        if (each.category == category)
                            if(each.conditionUsed == conditionUsed)
                                tempProduct.add(each);
        }
        return Algorithm.paginate(tempProduct, page, pageSize,pred->pred.weight != 0);
    }
}