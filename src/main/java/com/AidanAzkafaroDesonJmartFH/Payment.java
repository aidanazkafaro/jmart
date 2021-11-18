package com.AidanAzkafaroDesonJmartFH;

import java.util.ArrayList;
import java.util.Date;

/**
 * Write a description of class Payment here.
 *
 * @author (Aidan Azkafaro Deson)
 * @version (a version number or a date)
 */
public class Payment extends Invoice 
{
    // instance variables - replace the example below with your own
    public Shipment shipment;
    public int productCount;
    public ArrayList<Record> history = new ArrayList<>();
    
    public Payment(int buyerId, int productId, int productCount, Shipment shipment){
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }
    
    @Override
	public double getTotalPay(Product product) {
		// TODO Auto-generated method stub
		return product.price + product.shipmentPlans;
	}
    
    public static class Record {
    	public final Date date = new Date();
    	public String message;
    	public Status status;
    	
    	public Record (Status status, String message) {
    		this.status = status;
    		this.message = message;
    	}
    	
    }

	
}
