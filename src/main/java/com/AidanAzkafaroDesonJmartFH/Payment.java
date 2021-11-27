package com.AidanAzkafaroDesonJmartFH;

import java.util.ArrayList;
import java.util.Date;

public class Payment extends Invoice {
	public ArrayList<Record> history;
	public int productCount;
	public Shipment shipment;

	public Payment(int buyerId, int productId, int productCount, Shipment shipment) {
		super(buyerId, productId);
		this.productCount = productCount;
		this.shipment = shipment;
	}

	public double getTotalPay(Product product) {
		return product.price + product.shipmentPlans;
	}

	public static class Record {
		public Date date;
		public String message;
		public Status status;

		public Record(Status status, String message) {
			this.status = status;
			this.message = message;
			this.date = new Date();
		}
	}
}