package com.AidanAzkafaroDesonJmartFH.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.AidanAzkafaroDesonJmartFH.Account;
import com.AidanAzkafaroDesonJmartFH.JsonTable;
import com.AidanAzkafaroDesonJmartFH.Serializable;

@RestController
public interface BasicGetController<T extends Serializable> {

	public abstract JsonTable<T> getJsonTable();

    @GetMapping("/page")
    public default List<T> getPage(int page, int pageSize) {
        return getJsonTable().subList(page, pageSize);
    }

    @GetMapping("/{id}")
    public default T getById(int id) {
        return getJsonTable().get(id);
    }
}
