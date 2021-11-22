package com.AidanAzkafaroDesonJmartFH.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.AidanAzkafaroDesonJmartFH.Algorithm;
import com.AidanAzkafaroDesonJmartFH.Coupon;
import com.AidanAzkafaroDesonJmartFH.JsonTable;
import com.AidanAzkafaroDesonJmartFH.Product;
import com.AidanAzkafaroDesonJmartFH.dbjson.JsonAutowired;

@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon> {

	@JsonAutowired(filepath ="C:\\Users\\aidan\\Programming\\OOP Tekkom\\Praktikum OOP\\jmart\\jsonFiles\\randomProductList.json", value = Coupon.class)
	public static JsonTable<Coupon> couponTable;

	
	@GetMapping("/{id}/canApply")
	public boolean canApply (
			@RequestParam int id,
			@RequestParam double price, 
			@RequestParam double discount
			)
	{
        for(Coupon coupon: getJsonTable()){
            if(coupon.id == id){
                return coupon.canApply(coupon.id, price, discount);
            }
        }
        return false;
    }
	
	@GetMapping("/getAvailable")
	public List<Coupon> getAvailable (
			@RequestParam int page, 
			@RequestParam int pageSize)
	{
		return Algorithm.paginate(couponTable, page, pageSize,pred->pred.isUsed() == false);

	}
	
	public JsonTable<Coupon> getJsonTable(){
		return couponTable;
	}
	
    @GetMapping("/{id}/isUsed")
    public boolean isUsed(int id){
        for(Coupon cou: getJsonTable()){
            if(cou.id == id){
                return cou.isUsed();
            }
        }
        return false;
    }
}
