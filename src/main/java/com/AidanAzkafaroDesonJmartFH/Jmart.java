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


	public static void main(String[] args) {

		JsonDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
	}

}
