package com.AidanAzkafaroDesonJmartFH.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.AidanAzkafaroDesonJmartFH.Account;
import com.AidanAzkafaroDesonJmartFH.Algorithm;
import com.AidanAzkafaroDesonJmartFH.dbjson.JsonTable;
import com.AidanAzkafaroDesonJmartFH.dbjson.Serializable;

/**
 * @author Aidan Azkafaro Deson
 * @version 1.0
 * @since 18 Desember 2021
 */
@RestController
public interface BasicGetController<T extends Serializable> {
	@GetMapping("/{id}")
	public default T getById(@PathVariable int id) {
		return Algorithm.<T>find(getJsonTable(), e -> e.id == id);
	}

	public abstract JsonTable<T> getJsonTable();

	@GetMapping("/page")
	public default List<T> getPage(int page, int pageSize) {
		final JsonTable<T> table = getJsonTable();
		return Algorithm.paginate(table, page, pageSize, o -> true);
	}

}