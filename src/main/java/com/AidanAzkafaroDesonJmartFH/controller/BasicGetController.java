package com.AidanAzkafaroDesonJmartFH.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.AidanAzkafaroDesonJmartFH.JsonTable;
import com.AidanAzkafaroDesonJmartFH.Serializable;

@RestController
public interface BasicGetController <T extends Serializable> {

	@GetMapping("/{id}")
	public default @ResponseBody T getById (int id) {
		for (T object : getJsonTable()) {
			if(object.id == id) {
				return object;
			}
		}
		return null;
	};
	
	public abstract JsonTable<T> getJsonTable ();
	
	@GetMapping("/page")
	public default @ResponseBody List<T> getPage (int page, int pageSize){
		return null;
	}
}
