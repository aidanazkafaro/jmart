package com.AidanAzkafaroDesonJmartFH;

import com.AidanAzkafaroDesonJmartFH.dbjson.Serializable;

/**
 * Write a description of class Coupon here.
 *
 * @author (Aidan Azkafaro Deson)
 * @version (a version number or a date)
 */
public class Coupon extends Serializable {
    public final int code;
    public final double cut, minimum;
    public final String name;
    public final Type type;
    private boolean used;

    public Coupon(String name, int code, Type type, double cut, double minimum){
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        used = false;
    }

    public double apply(double price, double discount){
        this.used = true;
        if (type == Type.DISCOUNT) {
            return (Treasury.getAdjustedPrice(price, discount) * ((100 - cut) / 100));
        }
        return (Treasury.getAdjustedPrice(price, discount) - cut);
    }

    public boolean canApply(double price, double discount){
        if (Treasury.getAdjustedPrice(price, discount) >= minimum && !used){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isUsed(){
        return this.used;
    }

    public static enum Type{
        DISCOUNT,
        REBATE
    }
}