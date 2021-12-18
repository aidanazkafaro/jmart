package com.AidanAzkafaroDesonJmartFH;

/**
 * Class Pair 
 * @author Aidan Azkafaro Deson
 * @version 1.0
 * @since 18 Desember 2021
 */
public class Pair <T, U>{
	T first;
	T second;
	
	/**
	 * constructor Pair default (tanpa parameter)
	 */
	public Pair(){
		this.first = null;
		this.second = null;
	}
	
	/**
	 * constructor Pair dengan paramter
	 * @param first
	 * @param second
	 */
	public Pair(T first, T second){
		this.first = first;
		this.second = second;
	}
}
