package com.AidanAzkafaroDesonJmartFH;

import java.util.Date;

import com.AidanAzkafaroDesonJmartFH.dbjson.Serializable;

import java.util.ArrayList;

/**
 * Class Invoice berisi status dan rating terhadap pembelian barang
 * 
 * @author Aidan Azkafaro Deson
 * @version 1.0
 * @since 18 Desember 2021
 */

public abstract class Invoice extends Serializable
{
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public final Date date;

    /**
     * 
     * @param buyerId id pembeli
     * @param productId id produk yang dibeli
     */
    protected Invoice(int buyerId, int productId) {
        this.buyerId = buyerId;
        this.productId = productId;
        date = java.util.Calendar.getInstance().getTime();
        this.complaintId = -1;
        this.rating = Rating.NONE;
    }

    /**
     * enum berisi status pembelian dari saat pertama diorder sampai selesai
     */
    public enum Status {
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRESS,
        ON_DELIVERY,
        COMPLAINT,
        FINISHED,
        FAILED
    }

    /**
     * enum berisi rating produk
     */
    public enum Rating {
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }

    /**
     * method abstract yang digunakan untuk mendapatkan harga akhir setelah ditambah discount dan kupon
     * @param product
     * @return
     */
    public abstract double getTotalPay(Product product);

}