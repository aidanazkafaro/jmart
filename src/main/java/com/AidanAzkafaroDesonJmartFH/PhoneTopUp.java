package com.AidanAzkafaroDesonJmartFH;


/**
 * Class PhoneTopUp berfungsi untuk melakukan top up saldo pada aplikasi
 * 
 * @author Aidan Azkafaro Deson
 * @version 1.0
 * @since 18 Desember 2021
 */
public class PhoneTopUp extends Invoice{

	public String phoneNumber;
	public String status;
	
	/**
	 * constructor PhoneTopUp
	 * @param buyerId 
	 * @param productId 
	 * @param phoneNumber 
	 */
	public PhoneTopUp(int buyerId, int productId, String phoneNumber) {
		super(buyerId, productId);
		this.phoneNumber = phoneNumber;
	}


    @Override
	public double getTotalPay(Product product) {
		// TODO Auto-generated method stub
		return product.price + product.shipmentPlans;
	}

}
