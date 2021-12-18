package com.AidanAzkafaroDesonJmartFH;

import java.util.ArrayList;
import java.util.Date;

import com.AidanAzkafaroDesonJmartFH.controller.PaymentController;
import com.AidanAzkafaroDesonJmartFH.controller.ProductController;

/**
 * Class Payment berisi proses pembayaran produk
 * 
 * @author Aidan Azkafaro Deson
 * @version 1.0
 * @since 18 Desember 2021
 */
public class Payment extends Invoice
{
    public ArrayList<Record> history = new ArrayList<Record>();
    public int productCount;
    public Shipment shipment;
    public String productName;
    	
    /**
     * Constructor Payment untuk inisialisasi pembelian produk 
     * @param buyerId id pembeli
     * @param productId id produk yang dibeli
     * @param productCount jumlah produk yang dibeli
     * @param shipment metode pengiriman dari produk tersebut
     */
    public Payment(int buyerId, int productId, int productCount, Shipment shipment){
        super(buyerId, productId);
        this.productCount = productCount;
        this.productId = productId;
        this.shipment = shipment;
        this.productName = Algorithm.<Product>find(ProductController.productTable, product->product.id == productId).name;    }

    /**
     * method untuk mendapatkan total harga yang sudah dipengaruhi discount dan ongkos kirim
     * @param product
     */
    public double getTotalPay(Product product){
        return product.price * (product.discount/100) + shipment.cost;
    }

    /**
     * inner class
     * @author aidan
     * @since 18 Desember 2021
     */
    public static class Record{
        public Status status;
        public Date date;
        public String message;

        /**
         * 
         * @param status
         * @param message
         */
        public Record(Status status, String message){
            this.status = status;
            this.message = message;
            this.date = java.util.Calendar.getInstance().getTime();
        }
    }
}