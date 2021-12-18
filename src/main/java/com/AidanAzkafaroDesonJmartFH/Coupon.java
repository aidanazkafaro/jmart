package com.AidanAzkafaroDesonJmartFH;

import com.AidanAzkafaroDesonJmartFH.dbjson.Serializable;

/**
 * Class Coupon dipakai untuk penerapan coupon pada pembelian barang
 * @author Aidan Azkafaro Deson
 * @version 1.0
 * @since 18 Desember 2021
 */
public class Coupon extends Serializable {
    public final int code;
    public final double cut, minimum;
    public final String name;
    public final Type type;
    private boolean used;

    /**
     * Constructor pembuatan Coupon
     * @param desc
     * @param code
     * @param type
     * @param cut
     * @param minimum
     */
    public Coupon(String name, int code, Type type, double cut, double minimum){
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        used = false;
    }

    /**
     * 
     * @param price harga barang yang ingin diberikan coupon
     * @param discount penyesuaian harga akhir produk berdasarkan nilai discount
     * @return
     */
    public double apply(double price, double discount){
        this.used = true;
        if (type == Type.DISCOUNT) {
            return (Treasury.getAdjustedPrice(price, discount) * ((100 - cut) / 100));
        }
        return (Treasury.getAdjustedPrice(price, discount) - cut);
    }

    /**
     * 
     * @param price harga barang yang ingin diberikan coupon
     * @param discount penyesuaian harga akhir produk berdasarkan nilai discount
     * @return
     */
    public boolean canApply(double price, double discount){
        if (Treasury.getAdjustedPrice(price, discount) >= minimum && !used){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 
     * @return boolean value yang menampilkan status coupon apakah sudah digunakan atau belum
     */
    public boolean isUsed(){
        return this.used;
    }

    public static enum Type{
        DISCOUNT,
        REBATE
    }
}