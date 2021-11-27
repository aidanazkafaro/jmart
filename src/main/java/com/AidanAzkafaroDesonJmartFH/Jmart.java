package com.AidanAzkafaroDesonJmartFH;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.AidanAzkafaroDesonJmartFH.dbjson.JsonDBEngine;
/**
 *
 * @author (Aidan Azkafaro Deson)
 * 
 */

@SpringBootApplication
public class Jmart {

	public static long DELIVERED_LIMIT_MS = 1;
	public static long ON_DELIVERY_LIMIT_MS = 1;
	public static long ON_PROGRESS_LIMIT_MS = 1;
	public static long WAITING_CONF_LIMIT_MS = 1;

	public static boolean paymentTimeKeeper(Payment payment){
        long startTime = System.currentTimeMillis();
        if(System.currentTimeMillis() - startTime > WAITING_CONF_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "FAILED"));
        }
        else if(System.currentTimeMillis() - startTime > ON_PROGRESS_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "FAILED"));
        }
        else if(System.currentTimeMillis() - startTime > ON_DELIVERY_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, "ON_DELIVERY"));
        }
        else if(System.currentTimeMillis() - startTime > DELIVERED_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FINISHED, "DELIVERED"));
            return true;
        }
        return false;
    }

	public static void main(String[] args) {
		
		SpringApplication.run(Jmart.class, args);
		
	}

}
