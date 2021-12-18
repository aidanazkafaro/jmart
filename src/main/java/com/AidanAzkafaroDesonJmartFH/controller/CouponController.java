package com.AidanAzkafaroDesonJmartFH.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.AidanAzkafaroDesonJmartFH.Algorithm;
import com.AidanAzkafaroDesonJmartFH.Coupon;
import com.AidanAzkafaroDesonJmartFH.Product;
import com.AidanAzkafaroDesonJmartFH.dbjson.JsonAutowired;
import com.AidanAzkafaroDesonJmartFH.dbjson.JsonTable;


/**
 * @author Aidan Azkafaro Deson
 * @version 1.0
 * @since 18 Desember 2021
 */
@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon> {
    @JsonAutowired(value = Coupon.class, filepath = "coupon.json")
    public static JsonTable<Coupon> couponTable;

    @Override
    public JsonTable<Coupon> getJsonTable() {
        return couponTable;
    }

    /**
     * mengecek apakah coupon sudah terpakai
     * @param id
     * @return
     */
    @GetMapping("/{id}/isUsed")
    @ResponseBody
    boolean isUsed
            (
                    @RequestParam int id
            )
    {
        for (Coupon data : couponTable) {
            if (data.id == id) {
                return data.isUsed();
            }
        }
        return false;
    }

    /**
     * 
     * @param id
     * @param price
     * @param discount
     * @return
     */
    @GetMapping("/{id}/canApply")
    @ResponseBody
    boolean canApply
            (
                    @RequestParam int id,
                    @RequestParam double price,
                    @RequestParam double discount
            )
    {
        for (Coupon data : couponTable) {
            if (data.id == id) {
                return data.canApply(price, discount);
            }
        }
        return false;
    }

    /**
     * 
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/getAvailable")
    @ResponseBody
    List<Coupon> getAvailable
            (
                    @RequestParam int page,
                    @RequestParam int pageSize
            )
    {
        return Algorithm.paginate(couponTable, page, pageSize, pred-> !pred.isUsed());
    }

    @Override
    public Coupon getById(int id) {
        return BasicGetController.super.getById(id);
    }

    @Override
    public List getPage(int page, int pageSize) {
        return BasicGetController.super.getPage(page, pageSize);
    }
}