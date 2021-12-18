package com.AidanAzkafaroDesonJmartFH;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.AidanAzkafaroDesonJmartFH.dbjson.JsonDBEngine;

/**
 * Driver class dari project JMART
 * 
 * @author Aidan Azkafaro Deson
 * @version 1.0
 * @since 18 Desember 2021
 */

@SpringBootApplication
public class Jmart {


	public static void main(String[] args) {

		JsonDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
	}

}